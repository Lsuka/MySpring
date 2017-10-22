package cn.unicorn.myspring.schedule.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component // 必须明确的告诉Spring,现在的MyTask是一个Spring容器管理的bean
public class MyTask1 {
	@Scheduled(cron = "* * * * * ?") // 定时调度参数
	public void runTask() throws InterruptedException {// 随意定义的方法,用于被调度
	TimeUnit.SECONDS.sleep(5);//每一次休眠5s,模拟多任务配置中,任务用时长的一个任务
		System.out.println("###[第一个任务--当前的日期时间]" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}
}
