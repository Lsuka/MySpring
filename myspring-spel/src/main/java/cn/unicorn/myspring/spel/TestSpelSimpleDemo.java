package cn.unicorn.myspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelSimpleDemo {
	public static void main(String[] args) {
		//变量操作(根变量的加入)
		String str = "#root=='mldn' ? 'bilibili' :'van游戏'";
		ExpressionParser parser = new SpelExpressionParser();// 定义一个SPEL的语法解析器
		Expression exp = parser.parseExpression(str);// 将字符串解析为一个正常的表达式对象
		//为这个根变量直接执行赋值处理操作
		EvaluationContext context = new StandardEvaluationContext("2333");// 实现表达式的具体计算处理
		System.out.println(exp.getValue(context));
	}
}
