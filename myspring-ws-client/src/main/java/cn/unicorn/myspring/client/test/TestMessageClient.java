package cn.unicorn.myspring.client.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.unicorn.myspring.remote.service.IMessageService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMessageClient extends TestCase {
@Resource 
private IMessageService messageService;
@Test
public void testEcho() throws Exception{
	System.err.println(this.messageService.echo("do you like what you see"));
}
}
