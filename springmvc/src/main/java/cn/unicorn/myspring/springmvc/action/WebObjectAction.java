package cn.unicorn.myspring.springmvc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.IOP.ServiceContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
@RequestMapping("/pages/web/*")
public class WebObjectAction {
	//进行业务处理方法上直接定义内置对象
	@RequestMapping("show")
	@ResponseBody
	public Object showObject(String msg, HttpServletRequest request, HttpServletResponse response) {
		List<String> all = new ArrayList<>();
		all.add("***[request内置对象]ContextPath=" + request.getContextPath());
		all.add("***[Application内置对象]RealPath=" + request.getServletContext().getRealPath("/"));
		all.add("***[response内置对象]RealPath=" + request.getLocale());
		all.add("***[sesssion内置对象]SessionID=" + request.getSession().getId());
		return all;
	}
	//内置提供的类获取request,response
	@RequestMapping("support")
	@ResponseBody
	public Object showObjectSupport(String msg) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		List<String> all = new ArrayList<>();
		all.add("***[request内置对象]ContextPath=" + request.getContextPath());
		all.add("***[Application内置对象]RealPath=" + request.getServletContext().getRealPath("/"));
		all.add("***[response内置对象]RealPath=" + request.getLocale());
		all.add("***[sesssion内置对象]SessionID=" + request.getSession().getId());
		return all;
	}
}
