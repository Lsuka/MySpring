package cn.unicorn.myspring.remote.service.impl;

import javax.jws.WebService;

import cn.unicorn.myspring.remote.service.IMessageService;

//定义本操作要描述的远程接口,而后设置一个引用的名称
@WebService(endpointInterface = "cn.unicorn.myspring.remote.service.IMessageService", serviceName = "messageService")
public class MessageServiceImpl implements IMessageService {

	@Override
	public String echo(String msg) {
		return "[ECHO]msg = " + msg;
	}

}
