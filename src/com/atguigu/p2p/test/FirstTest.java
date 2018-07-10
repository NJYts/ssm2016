package com.atguigu.p2p.test;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

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


	/**
	 * 写入二进制
	 * @param file
	 */
	public static void writeFile(File file){
		if(file != null){
			try {
				FileOutputStream fos = new FileOutputStream(file);
				DataOutputStream dos = new DataOutputStream(fos);
				dos.writeUTF("abcdefg");
				dos.writeUTF("学习");
				dos.writeUTF("are you ok?");
				dos.writeBoolean(true);
				dos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * 读取二进制文件
	 * @param file
	 */
	public static void readFile(File file){
		if(file != null){
			try {
				FileInputStream fis = new FileInputStream(file);
				DataInputStream dis = new DataInputStream(fis);
				System.out.println(dis.readUTF());
				System.out.println(dis.readUTF());
				System.out.println(dis.readUTF());
				System.out.println(dis.readBoolean());
				/*while(dis.available() != 0){
					System.out.print((char)dis.readByte());
				}*/
				dis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}


	public static void main(String[] args) {
		String s= "墨西哥','巴拿马','尼加拉瓜','海地','多米尼加','古巴','哥斯达黎加','危地马拉','萨尔瓦多','洪都拉斯','玻利维亚','委内瑞拉','秘鲁','厄瓜多尔','哥伦比亚','巴西','阿根廷','巴拉圭','智利','乌拉圭','巴哈马群岛','格林纳达','牙买加','伯利兹','特立尼达和多巴哥','圣文森特','苏里南','圣基茨和尼维斯','多米尼克','圣卢西亚','圭亚那','安提瓜和巴布达";
		String[] strs = s.split(",");

		System.out.println(strs.length);
		/*FirstTest firstTest = new FirstTest();
		firstTest.getUrl();*/

		File file  = new File("fileTest2.txt");
		writeFile(file);
		readFile(file);

	}
}
