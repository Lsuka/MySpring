package cn.unicorn.myspring.transaction.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.unicorn.myspring.transaction.service.INewService;
import cn.unicorn.myspring.transaction.vo.News;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestNewsService {
	@Resource
	private INewService newService;

	@Test
	public void testAdd() throws Exception {
		News vo = new News();
		vo.setTitle("搞比利");
		vo.setNote("哔哩哔哩干杯");
		vo.setPubdate(new Date());
		vo.setPrice(233.3);
		vo.setReadcount(23333);
		TestCase.assertTrue(this.newService.add(vo));
	}

	@Test
	public void testGet() {
		News vo = this.newService.get(1);
		System.err.println(vo);
		TestCase.assertNotNull(vo);
	}
}
