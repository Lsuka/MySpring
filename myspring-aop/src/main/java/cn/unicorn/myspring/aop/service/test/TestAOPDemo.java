package cn.unicorn.myspring.aop.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.unicorn.myspring.aop.service.IMessageService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAOPDemo extends TestCase {
	@Resource
	private IMessageService messageService;

	@Test
	public void test() {
		System.out.println(this.messageService.echo("哔哩哔哩干杯"));
	}
}
