package com.antony.designpattern.builder;

public class PersonDirector {
	
	//组装
	public Arms constructPerson(PersonBuilder pb) {
		pb.builderHelmetYanLong();
		pb.builderArmorMurder();
		pb.builderWeaponMurder();
		return pb.BuilderArms();
	}

	//这里进行测试
	public static void main(String[] args) {
		PersonDirector pb = new PersonDirector();
		Arms arms = pb.constructPerson(new ArmsBuilder());
		System.out.println(arms.getHelmet());
		System.out.println(arms.getArmor());
		System.out.println(arms.getWeapon());
	}
}