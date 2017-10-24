package cn.unicorn.myspring.aop.service.impl;

import org.springframework.stereotype.Service;

import cn.unicorn.myspring.aop.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {

	@Override
	public String echo(String str) {
		System.out.println("[MessageServiceImpl业务层实现]接收到消息内容: " + str);
		return "[ECHO]msg = " + str;
	}

}
