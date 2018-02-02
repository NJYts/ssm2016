package com.atguigu.p2p.test;

import java.io.*;
/**
 * 按行读写文件
* <p>Title: file</p>
* <p>Description: </p>
* <p>Company: </p> 
* @author WISE
* @date 2017年6月16日下午2:33:09
 */
public class file {
	public static void main(String[] args) {
		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");

			FileReader reader = new FileReader("C:\\Users\\WISE\\Documents\\Tencent Files\\2829573051\\FileRecv\\经纬度.txt");
			BufferedReader br = new BufferedReader(reader);

			String str = null;
			int count = 0;
			while ((str = br.readLine()) != null) {
				sb.append(str + "/");
				count++;
				if(count == 10){
					count = 0 ;
					//sb.substring(0, sb.length()-1);
					sb.append("\r\n\r\n");
					System.out.println(str);
					//writer.newLine();//换行
				}
			}
			
			br.close();
			reader.close();

			// write string to file
			FileWriter writer = new FileWriter("C:\\Users\\WISE\\Desktop\\jieguo.txt");
			BufferedWriter bw = new BufferedWriter(writer);
			System.out.println(sb);
			bw.write(sb.toString());

			bw.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
