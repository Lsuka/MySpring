package cn.unicorn.myspring.transaction.service;

import cn.unicorn.myspring.transaction.vo.News;

public interface INewService {
	public boolean add(News vo);

	public News get(long nid);
}
