package com.antony.designpattern.builder;

public class ArmsBuilder implements PersonBuilder {
    private Arms arms;

    //创建一个Arms实例,用于调用set方法
    public ArmsBuilder() {
        arms = new Arms();
    }

    @Override
    public void builderHelmetMurder() {
        arms.setHelmet("夺命头盔");
    }

    @Override
    public void builderArmorMurder() {
        arms.setArmor("夺命铠甲");
    }

    @Override
    public void builderWeaponMurder() {
        arms.setWeapon("夺命宝刀");
    }

    @Override
    public void builderHelmetYanLong() {
        arms.setHelmet("炎龙头盔");
    }

    @Override
    public void builderArmorYanLong() {
        arms.setArmor("炎龙铠甲");
    }

    @Override
    public void builderWeaponYanLong() {
        arms.setWeapon("炎龙宝刀");
    }

    @Override
    public Arms BuilderArms() {
        return arms;
    }
}