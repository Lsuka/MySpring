package cn.unicorn.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ValidationInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class);
	
	@Resource
	private MessageSource messageSource;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {// 执行向下转型前应该首先判断其是否是指定类的实例
			HandlerMethod handlerMethod = (HandlerMethod) handler;// 强制转换
			//本次的设计是没有考虑到重名类定义情况,因为实际的开发之中,如果要处理某一个信息有可能是有后台或前台
			String validationRuleKey = handlerMethod.getBeanType().getSimpleName()+"."+handlerMethod.getMethod().getName();
			String validationRule=null;//保存要读取指定的资源KEY对象的验证规则
			try {//如果指定的key不存在,表示现在不需要进行验证
				validationRule = this.messageSource.getMessage(validationRuleKey, null,null);
			} catch (Exception e) {
				if (validationRule!=null) {//此时有验证处理操作,则需要进行验证处理
					this.logger.info("[验证规则 - {"+request.getRequestURI()+"}]"+validationRule);
				}
			}
//			this.logger.info("[处理的Action对象]" + handlerMethod.getBean());
//			this.logger.info("[处理的Action-Class对象]" + handlerMethod.getBeanType());
//			this.logger.info("[Action处理方法名称]" + handlerMethod.getMethod());
//			for (int i = 0; i < handlerMethod.getMethodParameters().length; i++) {
//				this.logger.info("@@[Action处理方法参数 - " + i + "]" + handlerMethod.getMethodParameters()[i]);
//			}
		}
		return true;// 返回true表示放行,而如果返回false表示不执行后续的Action或拦截器
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		this.logger.info("@@@2.[***postHandle***]" + handler.getClass());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		this.logger.info("@@@3.[***afterCompletion***]" + handler.getClass());
	}
}
