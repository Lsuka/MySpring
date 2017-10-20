package cn.unicorn.myspring.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmpDemo {
public static void main(String[] args) {
	//启动Spring上下问,在以后的实际开发过程中,这一启动会由WEB容器负责
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-di.xml");
	System.out.println(ctx.getBean("emp"));
}
}
