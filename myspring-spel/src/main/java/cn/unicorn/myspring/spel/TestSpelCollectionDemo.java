package cn.unicorn.myspring.spel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelCollectionDemo {
	public static void main(String[] args) throws Exception {
		//集合内容的修改
		List<String> all = new ArrayList<>();
		all.add("van游戏");
		all.add("deep♂dark");
		all.add("ass♂we♂can");
		String str = "#allData[1]='www.bilibili.com'";//修改集合中的内容
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);// 设置了一个自定义的根变量
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("allData", all);// 将自定义的集合设置进来
		System.out.println(exp.getValue(context));
	}
}
