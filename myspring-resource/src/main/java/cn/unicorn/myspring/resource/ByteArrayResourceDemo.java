package cn.unicorn.myspring.resource;

import java.util.Scanner;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ByteArrayResourceDemo {
	public static void main(String[] args) throws Exception {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		// 创建一个内存去读的Resource对象
		//Resource resource = resourceLoader.getResource("file:D:/233.xml");//本地文件
		//Resource resource = resourceLoader.getResource("classpath:spring/spring-resource.xml");//ClassPath
		Resource resource =resourceLoader.getResource("http://www.baidu.com");
		// 读取内容可以使用Resource父接口InputStreamSrouce提供的getInputStream()方法来完成
		Scanner scanner = new Scanner(resource.getInputStream());
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();
	}
}
