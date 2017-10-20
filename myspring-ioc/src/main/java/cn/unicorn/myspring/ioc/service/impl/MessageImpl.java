package cn.unicorn.myspring.ioc.service.impl;

import cn.unicorn.myspring.ioc.service.IMessage;

public class MessageImpl implements IMessage {

	@Override
	public String echo(String msg) {
		return "[ECHO]" + msg;
	}

}
