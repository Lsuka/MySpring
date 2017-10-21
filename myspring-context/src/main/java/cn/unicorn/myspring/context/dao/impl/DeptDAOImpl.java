package cn.unicorn.myspring.context.dao.impl;

import cn.unicorn.myspring.context.dao.IDeptDAO;
import cn.unicorn.myspring.context.vo.Dept;

public class DeptDAOImpl implements IDeptDAO {
	@Override
	public boolean doCreate(Dept dept) {
		System.out.println("[数据层-DeptDAOImpl]增加新部门:" + dept);
		return true;
	}
}
