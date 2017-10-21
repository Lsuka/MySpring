package cn.unicorn.myspring.context.dao.impl;

import org.springframework.stereotype.Repository;

import cn.unicorn.myspring.context.dao.IDeptDAO;
import cn.unicorn.myspring.context.vo.Dept;

@Repository //等价于<bean id="deptDAO" class="cn.unicorn.myspring.context.dao.impl.DeptDAOImpl"/>
public class DeptDAOImpl implements IDeptDAO {
	@Override
	public boolean doCreate(Dept dept) {
		System.out.println("[数据层-DeptDAOImpl]增加新部门:" + dept);
		return true;
	}
}
