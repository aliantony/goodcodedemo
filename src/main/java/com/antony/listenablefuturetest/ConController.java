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
 * description:模拟多线程处理
 */
@RestController
@RequestMapping("con")
public class ConController {
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
 
            while (countNum < list.size()) {
                countNum += size;
                //创建一个对象，此对象继承Callable，下面会有源代码
                ConCallable callable = new ConCallable();
                //截取list的数据，分给不同线程处理
                /*这段代码写的很好，我喜欢这段，根据集合的下标，形成多线程，每个线程处理固定的数量，当最后一个线程要处理的数据大于总数的时候，
                则从上一个线程处理的末尾，到数据总数。真正意义上的多线程，本来多线程这块儿我是写死的，手动分配几个线程，代码效率低；
                这段儿代码，根据size可以随时对线程调优，仅需修改size，即可找到适合自己业务的线程数。*/
                callable.setList(ImmutableList.copyOf(list.subList(countNum - size, countNum < list.size() ? countNum : list.size())));
                //执行线程
                ListenableFuture listenableFuture = listeningExecutorService.submit(callable);
                //异步回调操作，原作者仅仅是展示下如何使用回调，
                /*如果有这种需求：多个线程执行，
                 都执行完毕，进行回调，则需要调用Futures.allAsList(futureList)，多线程同时回调的代码会在文章末尾 单独贴出来。*/
                Futures.addCallback(listenableFuture, new FutureCallback<List<String>>() {
                    @Override
                    public void onSuccess(List<String> list1) {
                        countDownLatch.countDown();//计数器-1
                        list2.addAll(list1);//将线程执行结果放入结果集
                    }
 
                    @Override
                    public void onFailure(Throwable throwable) {
                        countDownLatch.countDown();
                        logger.info("处理出错：", throwable);
 
                    }
                });
            }
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