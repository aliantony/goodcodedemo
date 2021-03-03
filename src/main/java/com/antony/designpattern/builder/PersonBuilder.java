package com.antony.designpattern.builder;

public interface PersonBuilder {

	void builderHelmetMurder();

	void builderArmorMurder();

	void builderWeaponMurder();

	void builderHelmetYanLong();

	void builderArmorYanLong();

	void builderWeaponYanLong();

	Arms BuilderArms(); //组装
}