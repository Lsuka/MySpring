package cn.unicorn.myspring.transaction.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import cn.unicorn.myspring.transaction.dao.INewsDAO;
import cn.unicorn.myspring.transaction.service.INewService;
import cn.unicorn.myspring.transaction.vo.News;

@Service
public class NewsServiceImpl implements INewService {
	@Resource
	private INewsDAO newsDAO;

	@Override
	public boolean add(News vo) {
		return this.newsDAO.doCreate(vo);
	}

	@Override
	public News get(long nid) {
		return this.newsDAO.findById(nid);
	}

}
