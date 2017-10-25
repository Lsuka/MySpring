package cn.unicorn.myspring.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.unicorn.myspring.springmvc.util.action.AbstractAction;
import cn.unicorn.myspring.springmvc.vo.Emp;

@Controller
@RequestMapping("/pages/emp/*")
public class EmpAction extends AbstractAction {
	@RequestMapping("emp_add")
	public ModelAndView add(Emp emp) {
		System.err.println(emp);
		return null;
	}
}