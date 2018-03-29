package com.alone.demo.thread;

public class ThreadDeadLock implements Runnable { // 定义多线程类
	private static Zhangsan zs = new Zhangsan(); // 实例化static型对象，数据共享
	private static Lisi ls = new Lisi(); // 实例化static型对象，数据共享
	private boolean flag = false; // 声明标记，用于判断那个对象先执行

	public void run() { // 覆写run()方法
		if (flag) { // 判断标志位，Zhangsan先执行
			flag = false;
			synchronized (zs) { // 通过第一个对象
				zs.say(); // 调用方法
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 加入延迟，要处理异常
				synchronized (ls) { // 同步第二个对象
					zs.get(); // 调用方法
				}
			}
		} else { // Lisi先执行
			flag = true;
			synchronized (ls) { // 同步第二个对象
				ls.say(); // 调用方法
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 加入延迟，要处理异常
				synchronized (zs) { // 同步第一个对象
					ls.get(); // 调用方法
				}
			}
		}
	}
}

class Zhangsan { // 定义表示张三的类
	public void say() { // 定义say()方法
		System.out.println("张三对李四说：“你给我画，我就把书给你”。");
	}

	public void get() { // 定义得到东西的方法
		System.out.println("张三得到画了。");
	}
}

class Lisi { // 定义表示李四的类
	public void say() { // 定义say()方法
		System.out.println("李四对张三说：“你给我书，我就把画给你”。");
	}

	public void get() { // 定义得到东西的方法
		System.out.println("李四得到书了。");
	}
}
