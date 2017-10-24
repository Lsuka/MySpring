package cn.unicorn.myspring.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.unicorn.myspring.jdbc.vo.News;
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

	// 下面实现CRUD
	@Test
	public void testEdit() {
		String sql = "UPDATE news SET title=?,pubdate=?,note=?,price=?,readcount=? WHERE nid=?";
		String title = "搞比利";
		Date pubdate = new Date();
		String note = "哔哩哔哩干杯";
		double price = 23.3;
		int readcount = 233;
		long nid = 1;
		int len = this.jdbcTemplate.update(sql, title, pubdate, note, price, readcount, nid);
		System.out.println("更新行数" + len);
		TestCase.assertEquals(len, 1);
	}

	@Test
	public void testDelete() {
		String sql = "DELETE FROM news WHERE nid=? ";
		long nid = 2;
		int len = this.jdbcTemplate.update(sql, nid);
		System.out.println("更新行数" + len);
		TestCase.assertEquals(len, 1);
	}

	// 批量更新
	@Test
	public void testBatch() {
		String sql = "INSERT INTO news (title,pubdate,note,price,readcount) VALUES(?,?,?,?,?)";
		List<News> allNews = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			News vo = new News();
			vo.setTitle("搞比利" + i);
			vo.setNote("哔哩哔哩干杯" + i);
			vo.setPubdate(new Date());
			vo.setPrice(233.3);
			vo.setReadcount(rand.nextInt(66666));
			allNews.add(vo);
		}
		int len[][] = this.jdbcTemplate.batchUpdate(sql, allNews, allNews.size(),
				new ParameterizedPreparedStatementSetter<News>() {
					@Override
					public void setValues(PreparedStatement ps, News vo) throws SQLException {
						ps.setString(1, vo.getTitle());
						ps.setDate(2, new java.sql.Date(vo.getPubdate().getTime()));
						ps.setString(3, vo.getNote());
						ps.setDouble(4, vo.getPrice());
						ps.setInt(5, vo.getReadcount());
					}
				});
		for (int i = 0; i < len.length; i++) {
			System.out.println("[" + i + "]更新记录" + Arrays.toString(len[i]));
		}
	}

	// 查询
	@Test
	public void testSelectObject() {
		String sql = "SELECT nid,title,pubdate,note,price,readcount FROM news WHERE nid=?";
		News vo = this.jdbcTemplate.queryForObject(sql, new Object[] { 5 }, new RowMapper<News>() {
			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News vo = new News();
				vo.setNid(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setPubdate(rs.getDate(3));
				vo.setNote(rs.getString(4));
				vo.setPrice(rs.getDouble(5));
				vo.setReadcount(rs.getInt(6));
				return vo;
			}
		});
		System.out.println(vo);
	}

	// 分页查询
	@Test
	public void testSelectSplit() {
		String column = "title";
		String keyWord = "比利";
		Long currentPage = 1L;
		Integer lineSize = 5;
		String sql = "SELECT nid,title,pubdate,note,price,readcount FROM news WHERE " + column + " LIKE ? LIMIT ?,?";
		List<News> allNews = this.jdbcTemplate.query(sql,
				new Object[] { "%" + keyWord + "%", (currentPage - 1) * lineSize, lineSize }, new RowMapper<News>() {
					@Override
					public News mapRow(ResultSet rs, int rowNum) throws SQLException {
						News vo = new News();
						vo.setNid(rs.getLong(1));
						vo.setTitle(rs.getString(2));
						vo.setPubdate(rs.getDate(3));
						vo.setNote(rs.getString(4));
						vo.setPrice(rs.getDouble(5));
						vo.setReadcount(rs.getInt(6));
						return vo;
					}
				});
		System.out.println(allNews);
	}

	// 统计查询数量
	@Test
	public void testSelectCount() {
		String column = "title";
		String keyWord = "比利";
		String sql = "SELECT COUNT(*) FROM news WHERE " + column + " LIKE ?";
		Long count = this.jdbcTemplate.queryForObject(sql, Long.class, "%" + keyWord + "%");
		System.out.println("数据量统计" + count);
	}
}
