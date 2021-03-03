package com.antony.designpattern.builder;

import lombok.Data;

/**
 * 建造者模式关注一个复杂对象各组成部分的构建顺序。
 * 工厂模式注重单个对象的创建，抽象工厂就是工厂的工厂，对每类产品的工厂的抽象。
 */
//装备类
@Data
public class Arms {
	//头盔
	private String helmet;
	//铠甲
	private String armor;
	//武器
	private String weapon;
}