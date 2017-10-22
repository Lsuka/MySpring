package cn.unicorn.myspring.schedule.task;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTask {
	public void runTask() {// 随意定义的方法,用于被调度
		System.out.println("[当前的日期时间]" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}
}
