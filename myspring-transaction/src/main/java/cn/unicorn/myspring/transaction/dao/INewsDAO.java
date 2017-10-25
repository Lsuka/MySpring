package cn.unicorn.myspring.transaction.dao;

import cn.unicorn.myspring.transaction.vo.News;

public interface INewsDAO {
	public boolean doCreate(News vo);

	public News findById(Long nid);
}
