package com.atguigu.p2p.test;

public class ThreadTest3 extends Thread {
	private int threadNo;
	private String lock;

	public ThreadTest3(int threadNo, String lock) {
		this.threadNo = threadNo;
		this.lock = lock;
	}

	public static void main(String[] args) throws Exception {
		String lock = "lock";
		for (int i = 0; i < 10; i++) {
			new ThreadTest2(i, lock).start();
			Thread.sleep(1);
		}
	}

	public synchronized static void num(int threadNo) {
		for (int i = 0; i < 100; i++) {
			System.out.println("No." + threadNo + ":" + i);
		}
	}

	@Override
	public void run() {
		num(threadNo);
	};

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		this.lock = lock;
	}

	public void setThreadNo(int threadNo) {
		this.threadNo = threadNo;
	}

	public int getThreadNo() {
		return threadNo;
	}

}
