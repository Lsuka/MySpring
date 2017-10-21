package cn.unicorn.myspring.context.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.unicorn.myspring.context.dao.IDeptDAO;
import cn.unicorn.myspring.context.service.IDpetService;
import cn.unicorn.myspring.context.vo.Dept;

@Service // 等价于<bean id="deptService"
			// class="cn.unicorn.myspring.context.service.impl.DeptServiceImpl"/>
public class DeptServiceImpl implements IDpetService {
	@Resource // 等价于<property name="deptDAO" ref="deptDAO"/>
	private IDeptDAO deptDAO;// 定义IDeptDAO接口对象,表示该对象通过容器负责注入,会根据类型匹配

	public void setDeptDAO(IDeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

	@Override
	public boolean add(Dept dept) {
		System.out.println("*******Dept业务层调用**********");
		return this.deptDAO.doCreate(dept);
	}

}
