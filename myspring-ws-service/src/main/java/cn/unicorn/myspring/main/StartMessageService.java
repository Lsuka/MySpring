package cn.unicorn.myspring.main;

import javax.xml.ws.Endpoint;

import cn.unicorn.myspring.remote.service.IMessageService;
import cn.unicorn.myspring.remote.service.impl.MessageServiceImpl;

public class StartMessageService {
	public static void main(String[] args) {
		IMessageService msgObj = new MessageServiceImpl();//实例化接口
		Endpoint.publish("http://192.168.28.136:7777/message", msgObj);
	}
}
