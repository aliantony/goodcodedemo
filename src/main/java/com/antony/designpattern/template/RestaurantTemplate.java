package com.antony.designpattern.template;

//模板方法
public abstract class RestaurantTemplate {

	// 1.看菜单
	public void menu() {
		System.out.println("看菜单");
	}

	// 2.点菜业务
	abstract void spotMenu();

	// 3.吃饭业务
	public void havingDinner(){ System.out.println("吃饭"); }

	// 3.付款业务
	abstract void payment();

	// 3.走人
	public void GoR() { System.out.println("走人"); }

	//模板通用结构
	public void process(){
		menu();
		spotMenu();
		havingDinner();
		payment();
		GoR();
	}
}