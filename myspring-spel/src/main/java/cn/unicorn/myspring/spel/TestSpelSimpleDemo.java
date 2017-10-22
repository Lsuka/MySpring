package cn.unicorn.myspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelSimpleDemo {
	public static void main(String[] args) {
		//String str = "'helloworld'[1]";// 获取指定字符串,相当于charAt()
		//String str = "'helloworld'.toUpperCase()";// 转大写
		String str = "'helloworld'.replaceAll('l','2')";// 字符串替换
		ExpressionParser parser = new SpelExpressionParser();// 定义一个SPEL的语法解析器
		Expression exp = parser.parseExpression(str);// 将字符串解析为一个正常的表达式对象
		EvaluationContext context = new StandardEvaluationContext(exp);// 实现表达式的具体计算处理
		Object value = exp.getValue(context);
		System.out.println(value);
	}
}
