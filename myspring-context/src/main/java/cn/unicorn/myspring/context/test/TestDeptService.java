package cn.unicorn.myspring.context.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.unicorn.myspring.context.service.IDpetService;
import cn.unicorn.myspring.context.vo.Dept;

public class TestDeptService {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml",
				"spring/spring-service.xml");// 加载所有的配置文件
		IDpetService deptService = ctx.getBean("deptService", IDpetService.class);
		Dept dept = new Dept();// 创建VO对象
		dept.setDeptno(10L);
		dept.setDname("ass♂we♂部");
		System.out.println(deptService.add(dept));
	}
}
