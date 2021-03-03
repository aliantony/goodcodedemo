package com.antony.designpattern.dynamicproxy;

public class UserDaoImpl implements UserDao {
	public void save() {
		System.out.println("保存数据方法");
	}

    @Override
    public void update() {
        System.out.println("更新数据方法");
    }
}