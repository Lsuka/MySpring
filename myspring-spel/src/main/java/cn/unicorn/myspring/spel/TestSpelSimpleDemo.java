package cn.unicorn.myspring.spel;

import java.lang.reflect.Method;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelSimpleDemo {
	public static void main(String[] args) throws Exception {
		// 变量操作(根变量的加入)
		String str = "#myInt('666')";// myInt表示的就是方法引用设置的别名
		Method method = Integer.class.getMethod("parseInt", String.class);// 获取该方法引用的反射对象
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);// 设置了一个自定义的根变量
		// 为这个根变量直接执行赋值处理操作
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.registerFunction("myInt", method);
		System.out.println(exp.getValue(context));
	}
}
