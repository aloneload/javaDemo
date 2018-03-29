package com.alone.demo.thread;

class MyThread06 implements Runnable {			// 实现Runnable接口
	public void run() {					// 覆写run()方法
		for (int i = 0; i < 5; i++) {			// 循环5次
			try {
				Thread.sleep(500);		// 线程休眠
			} catch (Exception e) {}			// 需要异常处理
			System.out.println(Thread.currentThread().getName() 
				+ "运行， i = " + i);		// 输出线程名称
		}
	}
};
public class ThreadSleepDemo {
	public static void main(String args[]) {
		Runnable mt = new MyThread06();			// 实例化对象
		new Thread(mt, "线程").start();			// 启动线程
	}
};

