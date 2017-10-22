package cn.unicorn.myspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelSimpleDemo {
	public static void main(String[] args) {
		//Class类型表达式
		//获取Class
//		String str = "T(java.lang.String)";
//		String str = "T(java.util.Date)";
		//静态属性
//		String str = "T(Integer).MAX_VALUE";
//		String str = "T(Integer).parseInt('6666')";
		//对象实例化
//		String str = "new java.util.Date()";
		//instanceof
		String str = "'van游戏' instanceof T(String)";
		ExpressionParser parser = new SpelExpressionParser();// 定义一个SPEL的语法解析器
		Expression exp = parser.parseExpression(str);// 将字符串解析为一个正常的表达式对象
		EvaluationContext context = new StandardEvaluationContext(exp);// 实现表达式的具体计算处理
//		Class<?> cls = exp.getValue(context,Class.class);
//		Integer num = exp.getValue(context,Integer.class);
//		Date date = exp.getValue(context,Date.class);
		System.out.println(exp.getValue(context));
	}
}
