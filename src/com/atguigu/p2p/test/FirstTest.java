package com.atguigu.p2p.test;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FirstTest {
	private static HttpServletRequest request;
	public void getUrl() {
		System.out.println(request.getRequestURI());
		System.out.println(request.getContextPath());
		System.out.println(this.getClass().getClassLoader().getResource(""));
		System.out.println(this.getClass().getPackage());
		File file = new File(""+this.getClass().getClassLoader().getResource(""));
		System.out.println(file.getAbsolutePath());
	}
	public static void main(String[] args) {
		String s= "墨西哥','巴拿马','尼加拉瓜','海地','多米尼加','古巴','哥斯达黎加','危地马拉','萨尔瓦多','洪都拉斯','玻利维亚','委内瑞拉','秘鲁','厄瓜多尔','哥伦比亚','巴西','阿根廷','巴拉圭','智利','乌拉圭','巴哈马群岛','格林纳达','牙买加','伯利兹','特立尼达和多巴哥','圣文森特','苏里南','圣基茨和尼维斯','多米尼克','圣卢西亚','圭亚那','安提瓜和巴布达";
		String[] strs = s.split(",");

		System.out.println(strs.length);
		/*FirstTest firstTest = new FirstTest();
		firstTest.getUrl();*/
		
	}
}
