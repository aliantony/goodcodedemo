package com.antony.listenablefuturetest;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * author:lightClouds917
 * date:2018/1/22
 * description:模拟多线程处理,多线程同时回调
 */
@RestController
@RequestMapping("con1")
public class ConController2 {
    private final static Logger logger = LoggerFactory.getLogger(Logger.class);
    //    线程池
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 50, 500,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(200),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );
    //使用Guava的ListeningExecutorService装饰线程池
    ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(threadPoolExecutor);
 
    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public String test1() {
        try {
            //10万条数据
            List<String> list = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
 
            for (int i = 1; i <= 100000; i++) {
                list.add("test:" + i);
            }
 
            //每条线程处理的数据尺寸
            int size = 250;
            int count = list.size() / size;  //根据size得出线程数量
            if (count * size != list.size()) {
                count++; //如果已有线程要处理数据的总数，不等于list数据集合的总数，线程+1
            }
            int countNum = 0;//统计处理数据
            final CountDownLatch countDownLatch = new CountDownLatch(count);//线程计数器
            //在循环外创建一个list数组，用于存放线程
            List futureList = new ArrayList<ListenableFuture>();

            while (countNum < list.size()) {
                countNum += size;
                //创建一个对象，此对象实现Callable接口
                ConCallable callable = new ConCallable();
                //截取list的数据，分给不同线程处理
                callable.setList(ImmutableList.copyOf(list.subList(countNum - size, countNum < list.size() ? countNum : list.size())));
                //执行线程
                ListenableFuture listenableFuture = listeningExecutorService.submit(callable);
                //将子线程添加至线程集合
                futureList.add(listenableFuture);
            }
            /*都执行完毕，进行回调，则需要调用Futures.allAsList(futureList)，多线程同时回调.
             * 由于是所有的线程一起回调，线程的返回结果自动存放在一个list中，
             * 因此需要将上面的List<String> 改为：List<List<String>>*/
            Futures.addCallback(Futures.allAsList(futureList), new FutureCallback<List<List<String>>>() {
                @Override
                public void onSuccess(List<List<String>> list1) {
                    for (List<String> list : list1) {
                        countDownLatch.countDown();//计数器-1
                        list2.addAll(list);//将线程执行结果放入结果集
                    }
                }

                @Override
                public void onFailure(Throwable throwable) {
                    countDownLatch.countDown();
                    logger.info("处理出错：", throwable);

                }
            });
            //主线程阻塞，我直接这么用的countDownLatch.await(); 
            // 原作者这个应该是个超时策略，超过这个时间的线程，直接舍弃。
            countDownLatch.await(30, TimeUnit.MINUTES);
            logger.info("符合条件的返回数据个数为：" + list2.size());
            logger.info("回调函数：" + list2.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "正在处理......";
 
    }
}