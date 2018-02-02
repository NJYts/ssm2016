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
public class file3 {
	public static void main(String[] args) {
		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");

			FileReader reader = new FileReader("C:\\Users\\WISE\\Desktop\\国家中文名经纬度.txt");
			BufferedReader br = new BufferedReader(reader);

			String str = null;
			int count = 0;
			while ((str = br.readLine()) != null) {
				if (str != null && !"".equals(str)) {
					sb.append(str.replace(",'",",\r\n'").replace("'",""));
				}
				System.out.println(str);
			}
			br.close();
			reader.close();
			// write string to file
			FileWriter writer = new FileWriter("C:\\Users\\WISE\\Desktop\\temp.txt");
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(sb.toString());

			bw.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}}
