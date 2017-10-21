package cn.unicorn.myspring.resource.util;

import org.springframework.core.io.Resource;

public class DefaultResourceBean {
	private Resource[] resources;// 直接定义要使用的Bean对象

	public void setResources(Resource[] resources) {
		this.resources = resources;
	}

	public Resource[] getResources() {
		return resources;
	}
}