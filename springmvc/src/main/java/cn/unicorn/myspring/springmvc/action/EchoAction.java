package cn.unicorn.myspring.springmvc.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // 所有需要被Spring管理的程序类一定要进行配置
@RequestMapping("/pages/message/*") // 与方法中的路径做结合
public class EchoAction {// 定义以恶搞自己的处理的程序类
	private Logger log = LoggerFactory.getLogger(EchoAction.class);

	@RequestMapping("echo_pre")
	public String echoPre() {
		return "/pages/message/message_input.jsp";
	}

	@RequestMapping(path = "echo", method = RequestMethod.POST) // 以后访问此方法的路径就是"echo.action"
	public ModelAndView echo(
			@RequestParam(name = "msg",//表示请求参数的配置,name=""表示映射的请求参数的名称
			required = false, //表示该参数是否必须传递
					defaultValue = "deep♂dark♂fanstansy"// 设置该参数为null时的默认值
			) String str) {// 该参数会根据参数名称自动进行匹配处理
		this.log.info("***EchoAction接收到请求参数,msg = " + str);
		// ModelAndView主要功能是设置跳转路径以及进行request属性的保存
		ModelAndView mav = new ModelAndView("/pages/message/message_show.jsp");
		mav.addObject("echoMessage", "[ECHO]msg = " + str);// 设置request属性范围
		return mav;
	}
}
