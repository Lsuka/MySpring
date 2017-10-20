package cn.unicorn.myspring.ioc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.unicorn.myspring.ioc.service.IMessage;

public class TestMessageDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-ioc.xml");
		IMessage message = ctx.getBean("messageImpl", IMessage.class);// 获取实例化对象
		System.out.println(message.echo("bilibili干杯[]~(￣▽￣\")~*"));
	}
}
