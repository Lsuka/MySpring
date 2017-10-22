package cn.unicorn.myspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelSimpleDemo {
	public static void main(String[] args) throws Exception {
		// null处理,使用Groovy表达式处理
		String str = "#root?.time";
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);// 设置了一个自定义的根变量
		// 为这个根变量直接执行赋值处理操作
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
	}
}
