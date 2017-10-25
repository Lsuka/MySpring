package cn.unicorn.myspring.main;

import cn.unicorn.myspring.remote.service.IMessageService;
import cn.unicorn.myspring.remote.service.impl.MessageServiceLocator;

public class TestMessageClient {
	public static void main(String[] args) throws Exception {
		IMessageService messageService = new MessageServiceLocator().getMessageServiceImplPort();
		System.out.println(messageService.echo("哔哩哔哩干杯"));
	}
}
