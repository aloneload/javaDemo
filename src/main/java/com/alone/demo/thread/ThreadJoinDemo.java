package com.alone.demo.thread;


public class ThreadJoinDemo {
	public static void main(String args[]) {
		MyThread05 mt = new MyThread05();			// 实例化对象
		Thread t = new Thread(mt, "线程");			// 实例化Thread对象
		t.start();					// 线程启动
		for (int i = 0; i < 10; i++) {			// 循环10次
			if (i > 5) {			// 判断变量内容
				try {
					t.join(); 		// 线程t进行强制运行
				} catch (Exception e) {}	// 需要进行异常处理
			}
			System.out.println("Main 线程运行 --> " + i);
		}
	}
};

