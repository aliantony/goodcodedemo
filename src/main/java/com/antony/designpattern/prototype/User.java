package com.antony.designpattern.prototype;

import lombok.Data;

import java.util.ArrayList;

@Data
public class User implements Cloneable {
    private String name;
    private String password;
    private ArrayList<String> phones;

    @Override
    protected User clone() throws CloneNotSupportedException {
        try {
            User user = (User) super.clone();
            //重点，如果要连带引用类型一起复制，需要添加底下一条代码，如果不加就对于是复制了引用地址
            user.phones = (ArrayList<String>) this.phones.clone();//设置深复制
            return user;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}