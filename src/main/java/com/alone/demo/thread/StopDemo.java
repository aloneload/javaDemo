package com.alone.demo.thread;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap;

class MyThread11 implements Runnable {
	private boolean flag = true; // 定义标志位属性

	public void run() { // 覆写run()方法
		int i = 0;
		while (this.flag) { // 循环输出
			System.out.println(Thread.currentThread().getName() + "运行，i = " + (i++)); // 输出当前线程名称
		}
	}

	public void stop() { // 编写停止方法
		this.flag = false; // 修改标志位
	}
}

public class StopDemo {
	public static void main(String[] args) {
		
		MyThread11 my = new MyThread11(); // 实例化Runnable接口对象
		Thread t = new Thread(my, "线程"); // 建立线程对象
		t.start(); // 启动线程
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		my.stop(); // 线程停止，修改标志位
	}
}

