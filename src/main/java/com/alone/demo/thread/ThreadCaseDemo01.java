package com.alone.demo.thread;

public class ThreadCaseDemo01 {
	public static void main(String[] args) {
		Info i = new Info(); // 实例化Info对象
		Producer pro = new Producer(i); // 实例化生产者，传递Info引用
		Consumer con = new Consumer(i); // 实例化消费者，传递Info引用
		new Thread(pro).start(); // 启动生产者线程
		new Thread(con).start(); // 启动消费者线程
	}
}

class Info { // 定义信息类
	private String name = "香蕉标签"; // 信息名称，指定默认值
	private String content = "香蕉"; // 信息内容，指定默认值
	private boolean flag = false; // 设置标志位

	public synchronized void set(String name, String content) throws InterruptedException { // 设置信息名称及内容
		if (!flag) { // 标志位为false，不可以生产
			super.wait(); // 等待消费者取走，处理异常
		}
		this.setName(name); // 设置信息名称
		Thread.sleep(300); // 加入延迟，处理异常
		this.setContent(content); // 设置信息内容
		flag = false; // 修改标志位，表示可以取走
		super.notify(); // 唤醒等待线程
	}

	public synchronized void get() throws InterruptedException { // 取得信息内容
		if (flag) { // 标志位为true，不可以取走
			super.wait(); // 等待生产者生产，处理异常
		}
		Thread.sleep(300); // 加入延迟，处理异常
		System.out.println(this.getName() + " --> " + this.getContent()); // 输出信息
		flag = true; // 修改标志位为true，表示可以生产
		super.notify(); // 唤醒等待线程
	}
	// setter()及getter()方法

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

class Producer implements Runnable { // 定义生产者线程
	private Info info = null; // 保存Info引用

	public Producer(Info info) { // 通过构造方法设置Info属性内容
		this.info = info; // 为info属性初始化
	}

	public void run() { // 覆写run()方法
		boolean flag = false; // 定义标记位
		for (int i = 0; i < 50; i++) { // 循环50次
			if (flag) { // 如果为true，则设置第一个信息
				try {
					this.info.set("苹果标签", "苹果");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 设置信息
				flag = false; // 修改标记位
			} else { // 如果为false，则设置第二个信息
				try {
					this.info.set("香蕉标签", "香蕉");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 设置信息
				flag = true; // 修改标记位
			}
		}
	}
}

class Consumer implements Runnable { // 定义消费者线程
	private Info info = null; // 保存Info引用

	public Consumer(Info info) { // 通过构造方法设置Info属性内容
		this.info = info; // 为info属性初始化
	}

	public void run() { // 覆写run()方法
		for (int i = 0; i < 50; i++) { // 循环50次
			try {
				Thread.sleep(100); // 加入延迟
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				this.info.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 取出信息
		}
	}
}
