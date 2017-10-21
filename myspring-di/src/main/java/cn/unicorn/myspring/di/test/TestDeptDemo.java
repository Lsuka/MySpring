package cn.unicorn.myspring.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.unicorn.myspring.di.vo.Dept;

public class TestDeptDemo {
	public static void main(String[] args) {
		// 启动Spring上下问,在以后的实际开发过程中,这一启动会由WEB容器负责
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-di.xml");
		Dept dept = ctx.getBean("deptObj", Dept.class);
		System.out.println(dept);
		System.out.println(dept.getInfos());
	}
}
