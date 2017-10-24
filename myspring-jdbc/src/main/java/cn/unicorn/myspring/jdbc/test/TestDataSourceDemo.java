package cn.unicorn.myspring.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDataSourceDemo extends TestCase {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testConnection() throws Exception {
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES(?,?,?,?,?)";
		String title = "哔哩哔哩干杯";
		Date pubdate = new Date();
		String note = "高清无码搞比利";
		double price = 6.6;
		int readcount = 6;
		int len = this.jdbcTemplate.update(sql, title, pubdate, note, price, readcount);// 更新操作方式一
		// int len = this.jdbcTemplate.update(sql, new PreparedStatementSetter() {//
		// 更新操作方式二
		// //实际上这种方式给了用户自定义的空间
		// @Override
		// public void setValues(PreparedStatement ps) throws SQLException {
		// ps.setString(1, title);
		// ps.setDate(2, new java.sql.Date(pubdate.getTime()));
		// ps.setString(3, note);
		// ps.setDouble(4, price);
		// ps.setInt(5, readcount);
		// }
		// });
		System.out.println("更新行数" + len);
		TestCase.assertEquals(len, 1);
	}

	@Test
	public void testAdd() throws Exception {
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES(?,?,?,?,?)";
		String title = "哔哩哔哩干杯";
		Date pubdate = new Date();
		String note = "高清无码搞比利";
		double price = 6.6;
		int readcount = 6;
		KeyHolder keyHolder = new GeneratedKeyHolder();// 获取增长后的ID数据
		int len = this.jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, title);
				ps.setDate(2, new java.sql.Date(pubdate.getTime()));
				ps.setString(3, note);
				ps.setDouble(4, price);
				ps.setInt(5, readcount);
				return ps;// 手工创建Statement对象
			}
		}, keyHolder);
		System.out.println("更新行数" + len + ",当前的新闻ID ： " + keyHolder.getKey());
		TestCase.assertEquals(len, 1);
	}
}
