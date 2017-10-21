package cn.unicorn.myspring.resource;

import java.util.Iterator;
import java.util.Scanner;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.unicorn.myspring.resource.util.DefaultResourceBean;

@ContextConfiguration(locations = { "classpath:spring/spring-resource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestResource {
	@Resource
	private DefaultResourceBean resourceBean;

	@Test
	public void testResource() throws Exception {
		Iterator<org.springframework.core.io.Resource> iter = this.resourceBean.getResources().iterator();
		while (iter.hasNext()) {
			Scanner scanner = new Scanner(iter.next().getInputStream());
			scanner.useDelimiter("\n");
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
			scanner.close();
		}
	}
}
