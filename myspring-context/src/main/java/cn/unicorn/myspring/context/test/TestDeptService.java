package cn.unicorn.myspring.context.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.unicorn.myspring.context.service.IDpetService;
import cn.unicorn.myspring.context.vo.Dept;

public class TestDeptService {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-context.xml");// 加载所有的配置文件
		IDpetService deptService = ctx.getBean("deptServiceImpl", IDpetService.class);//利用Annotation自动设置的业务层注解名称为类名称(第一个字幕小写(例:deptServiceImpl)),而后可以自动找到指定的名称进行注入的操作处理
		Dept dept = new Dept();// 创建VO对象
		dept.setDeptno(10L);
		dept.setDname("ass♂we♂部");
		System.out.println(deptService.add(dept));
	}
}
