package com.alone.demo.thread;

class MyThread implements Runnable { // 实现Runnable接口
	private int ticket = 50; // 一共5张票

	public synchronized void run() { // 覆写run()方法
		for (int i = 0; i < 10; i++) { // 超出票数的循环
			if (ticket > 0) { // 判断是否有剩余票
				System.out.println(Thread.currentThread().getName()+"卖票：ticket = " + ticket--);
			}
		}
	}
};

public class RunnableDemo02 {
	public static void main(String args[]) {
		MyThread my = new MyThread();
		new Thread(my).start(); // 启动三个线程
		new Thread(my).start(); // 启动三个线程
		new Thread(my).start(); // 启动三个线程
	}
};
