package cn.unicorn.myspring.context.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.unicorn.myspring.context.service.IDpetService;
import cn.unicorn.myspring.context.vo.Dept;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-context.xml" }) // 进行资源文件定位
@RunWith(SpringJUnit4ClassRunner.class) // 设置要使用的测试工具类
public class TestDeptServicejunit extends TestCase {
	@Resource
	private IDpetService deptServie;// 直接注入业务对象
	        

	@Test
	public void testAdd() {
		Dept dept = new Dept();
		dept.setDeptno(10L);
		dept.setDname("Ass♂We♂Can部");
		TestCase.assertTrue(this.deptServie.add(dept));
	}
}
