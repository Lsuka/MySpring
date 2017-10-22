package cn.unicorn.myspring.spel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelCollectionDemo {
	public static void main(String[] args) throws Exception {
		// 集合的投影处理,投影处理指的是可以通过表达式进行集合内容的操作
		//对Map集合进行数据筛选
		Map<String, String> all = new HashMap<>();
		all.put("van", "deep♂dark");
		all.put("king", "ass♂we♂can");
		//整个处理之中就将Map.Entry隐含了
		String str = "#allData.![#this.key.contains('king')]";//表示集合中的数据
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);// 设置了一个自定义的根变量
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("allData", all);// 将自定义的集合设置进来
		System.out.println(exp.getValue(context));//此时就是一个List集合
	}
}
