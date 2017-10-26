package cn.unicorn.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 所有需要被Spring管理的程序类一定要进行配置
public class ErrorAction {
	@RequestMapping("/pages/error")
	public String error() {
		return "error";
	}
}
