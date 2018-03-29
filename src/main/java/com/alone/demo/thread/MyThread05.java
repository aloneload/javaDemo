package com.alone.demo.thread;

public class MyThread05 implements Runnable {			// 实现Runnable接口
	public void run() {				// 覆写run()方法
		for (int i = 0; i < 10; i++) {			// 循环10次
		     System.out.println(Thread.currentThread().getName() 
					+ "运行 --> " + i);	// 输出线程名称
		}
	}
};
