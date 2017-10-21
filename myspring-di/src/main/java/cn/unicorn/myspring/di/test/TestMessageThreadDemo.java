package cn.unicorn.myspring.di.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.unicorn.myspring.di.vo.Message;

public class TestMessageThreadDemo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-di.xml");
		for (int i = 0; i < 3; i++) {
			new Thread(() -> {
				Message msg = ctx.getBean("message", Message.class);// 获取程序类
				System.out.println(Thread.currentThread().getName() + ",msg = " + msg);
			}).start();
		}
		ctx.registerShutdownHook();// 触发销毁方法
	}
}
