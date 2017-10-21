package cn.unicorn.myspring.context.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.unicorn.myspring.context.dao.IDeptDAO;
import cn.unicorn.myspring.context.dao.impl.DeptDAOImpl;

@Configuration // 表示当前的类是一个专门用于配置的实现类
public class MyDAOConfig {
	@Bean(name = "deptDAOImpl")//等于<bean id="deptDAO" class="cn.unicorn.myspring.context.dao.impl.DeptDAOImpl"/>
	public IDeptDAO getDeptDAOInstance() {
		return new DeptDAOImpl();
	}
}
