package com.atguigu.p2p.test.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WISE on 2018/3/26.
 */
public class StackOverAndOutOfMemory {
	private int stackLength=1;
	/**
	   *    @author  : niujianye
	   *    @time    : 2018/3/26 17:35
	   *    @description : 堆栈溢出，java栈是线程的私有区域，它的生命周期与与线程相同。每个线程都有自己的java栈。线程每执行一个方法，都会在java栈中添加一个元素，我们称元素为“栈帧”
	   *    	            ，栈帧里存有局部变量和用于存放中间状态值得操作栈。当java栈内存不足时，则会出异常。常见操作就是次数过多的递归。
	   *    @param :  * @param null
	   *    @version : v2.0
	   */
	@Test
	public void StackOverFlow() throws Throwable {
		try {
			stackLength++;
			StackOverFlow();
		}catch (Throwable  e){
			System.out.println(stackLength);
		}
	}

	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	public static void main(String[]args)throws Throwable{
		StackOverAndOutOfMemory oom=new StackOverAndOutOfMemory();
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println("stack length："+oom.stackLength);
			throw e;
		}
	}
	/**
	   *    @author  : niujianye
	   *    @time    : 2018/3/26 18:11
	   *    @description : java 堆是线程共享区域，对象实例都存在这里。当线程过多或者线程内实例过多，堆内存不够时就会报异常。
	   *    @param :  * @param null
	   *    @version : v2.0
	   */
	@Test
	public void stackLeakByThread(){
		int count = 0;
		while(count < 2){
			count++;
			System.out.println(count);
			Thread thread = new Thread(new Runnable(){
				@Override
				public void run(){
					serviceOne();
				}
			});
			thread.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}
	@Test
	public void serviceOne(){
		System.out.println("serviceOne()开始");
		List list = new ArrayList();
		while (true){
			int[] ss = new int[1000000];
			list.add(ss);
		}

	}
}
