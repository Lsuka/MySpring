package cn.unicorn.myspring.springmvc.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.unicorn.myspring.springmvc.util.action.AbstractAction;
import cn.unicorn.myspring.springmvc.vo.Dept;
import cn.unicorn.myspring.springmvc.vo.Emp;

@Controller
@RequestMapping("/pages/emp/*")
public class EmpAction extends AbstractAction {
	@RequestMapping("emp_add")
	@ResponseBody // 使用此注解就表示返回的对象自动变为JSON对象
	public Object add(Emp emp) {
		return emp;
	}

	@RequestMapping("emp_list")
	@ResponseBody
	public Object list() {
		List<Emp> all = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Emp vo = new Emp();
			vo.setEmpno(7369L + i);
			vo.setEname("Smith-" + i);
			Dept dept = new Dept();
			dept.setDeptno(10L + i);
			dept.setDname("哲学部" + i);
			vo.setDept(dept);
			all.add(vo);
		}
		return all;
	}

	@RequestMapping("emp_map")
	@ResponseBody
	public Object map() {
		Map<String, Emp> all = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			Emp vo = new Emp();
			vo.setEmpno(7369L + i);
			vo.setEname("Smith-" + i);
			Dept dept = new Dept();
			dept.setDeptno(10L + i);
			dept.setDname("哲学部" + i);
			vo.setDept(dept);
			all.put("雇佣信息-" + i, vo);
		}
		return all;
	}
}
