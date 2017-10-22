package cn.unicorn.myspring.spel.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.unicorn.myspring.spel.vo.Book;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBook {
	@Resource
	private Book book;

	@Test
	public void testPrint() {
		System.out.println(this.book);
	}
}
