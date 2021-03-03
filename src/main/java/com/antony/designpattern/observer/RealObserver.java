package com.antony.designpattern.observer;

//具体主题
public class RealObserver extends Subjecct {
    //被观察对象的属性
	 private int state;
	 public int getState(){
		 return state;
	 }
	 public void  setState(int state){
		 this.state=state;
		 //主题对象(目标对象)值发生改变
		 this.notifyAllObserver(state);
	 }
}