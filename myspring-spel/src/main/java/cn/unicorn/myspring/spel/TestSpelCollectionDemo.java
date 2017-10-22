package cn.unicorn.myspring.spel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpelCollectionDemo {
	public static void main(String[] args) throws Exception {
		// 集合表达式
		// List<String> all = new ArrayList<>();
		// Set<String> all = new HashSet<>();
		// all.add("van游戏");
		// all.add("deep♂dark");
		// all.add("ass♂we♂can");
		Map<String, String> all = new HashMap<>();
		all.put("van", "deep♂dark");
		all.put("king", "ass♂we♂can");
		String str = "#allData['king']";// 通过索引访问数据
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(str);// 设置了一个自定义的根变量
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("allData", all);// 将自定义的集合设置进来
		System.out.println(exp.getValue(context));
		// 尝试List数据的添加
		// List<Integer> all = exp.getValue(context, List.class);
		// all.add(50);//进行新的数据追加。不可以进行数据添加,报java.util.Collections$UnmodifiableCollection.add(Unknown
		// Source)错误
	}
}
