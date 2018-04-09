package com.atguigu.p2p.test.SingletonTest;

/**
 * 静态内部类
 * Created by WISE on 2018/4/2.
 */
public class SingleTon {
	private SingleTon(){};
	private static class SingtonInstance{
		private static final SingleTon INSTANCE  = new SingleTon();
	}
	public static SingleTon getInstance(){
		return SingtonInstance.INSTANCE ;
	}
}
