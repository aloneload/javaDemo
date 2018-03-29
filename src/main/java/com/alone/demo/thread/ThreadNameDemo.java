package com.alone.demo.thread;

class MyThread04 implements Runnable{		// 实现Runnable接口
	public void run(){				// 覆写接口中的run()方法
		for(int i=0;i<3;i++){			// 循环输出3次
			System.out.println(Thread.currentThread().getName()
					+ "运行， i = " + i) ;					// 取得当前线程的名字
		}
	}
};
public class ThreadNameDemo {
	public static void main(String args[]) {
		MyThread04 my = new MyThread04() ;		// 定义Runnable子类对象
		new Thread(my).start() ;			// 系统自动设置线程名称
		new Thread(my,"线程-A").start() ;		// 手工设置线程名称
		new Thread(my,"线程-B").start() ;		// 手工设置线程名称
		new Thread(my).start() ;			// 系统自动设置线程名称
		new Thread(my).start() ;			// 系统自动设置线程名称
	}
};

