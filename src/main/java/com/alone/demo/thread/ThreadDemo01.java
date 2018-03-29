package com.alone.demo.thread;

class MyThread01 extends Thread { // 继承Thread类
	private String name; // 在类中定义一个属性

	public MyThread01(String name) { // 通过构造方法设置属性内容
		this.name = name; // 为name属性赋值
	}

	public void run() { // 覆写Thread类中的run()方法
		for (int i = 0; i < 10; i++) { // 循环10次输出
			System.out.println(name + "运行，i = " + i);
		}
	}
};


public class ThreadDemo01 {
	public static void main(String args[]) {
		MyThread01 mt1 = new MyThread01("线程A "); // 实例化对象
		MyThread01 mt2 = new MyThread01("线程B "); // 实例化对象
		// mt1.run(); // 调用线程主体
		// mt2.run(); // 调用线程主体
		mt1.start();
		mt2.start();
	}
};
