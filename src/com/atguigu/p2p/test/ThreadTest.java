package com.atguigu.p2p.test;

public class ThreadTest extends Thread {
	private int threadNo;

	public ThreadTest(int threadNo) {
		this.threadNo = threadNo;
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			new ThreadTest(i).start();
			Thread.sleep(1);
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("No." + threadNo + ":" + i);
		}
	};

	public void setThreadNo(int threadNo) {
		this.threadNo = threadNo;
	}

	public int getThreadNo() {
		return threadNo;
	}

}
