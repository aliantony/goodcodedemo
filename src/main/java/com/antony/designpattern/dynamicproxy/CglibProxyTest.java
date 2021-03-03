package com.antony.designpattern.dynamicproxy;
/**
 * @program goodcodedemo
 * @description 
 * @author wq
 * created on 2021-03-03
 * @version  1.0.0
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = (UserDao) cglibProxy.getInstance(new UserDaoImpl());
        userDao.save();
        userDao.update();
    }
}
