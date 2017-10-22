package cn.unicorn.myspring.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelCollectionDemo {
	public static void main(String[] args) throws Exception {
		// List集合表达式,基础使用
		String str = "{10,20,30}[1]";// 通过索引访问数据
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);// 设置了一个自定义的根变量
		EvaluationContext context = new StandardEvaluationContext();
		System.out.println(exp.getValue(context));
		//尝试List数据的添加
//		List<Integer> all = exp.getValue(context, List.class);
//		all.add(50);//进行新的数据追加。不可以进行数据添加,报java.util.Collections$UnmodifiableCollection.add(Unknown Source)错误
	}
}
