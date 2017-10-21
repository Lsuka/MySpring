package cn.unicorn.myspring.resource;

import java.util.Scanner;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class ByteArrayResourceDemo {
	public static void main(String[] args) throws Exception {
		// 创建一个内存去读的Resource对象
		//Resource resource = new FileSystemResource(new File("D:"+File.separatorChar+"233.xml"));//本地文件
		//Resource resource = new ClassPathResource("spring/spring-resource.xml");//ClassPath
		//Resource resource = new ByteArrayResource("deep♂dark♂fanstansy".getBytes());//内存流
		Resource resource = new UrlResource("http://www.baidu.com");
		// 读取内容可以使用Resource父接口InputStreamSrouce提供的getInputStream()方法来完成
		Scanner scanner = new Scanner(resource.getInputStream());
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();
	}
}
