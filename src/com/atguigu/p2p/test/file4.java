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
public class file4 {
	public static void main(String[] args) {
		try {
			StringBuffer sb = new StringBuffer("");

			FileReader reader = new FileReader("C:\\Users\\WISE\\Desktop\\新建文本文档.txt");
			BufferedReader br = new BufferedReader(reader);

			String str = null;
			int count = 0;
			while ((str = br.readLine()) != null) {
				if (str != null && !"".equals(str)) {
					if (str.indexOf("111") > -1){
						System.out.println(count);
						count = 0;
						sb.append(")\r\n"+str.replace("111","")+"\r\n:(");
					}else{
						count++;
						str = str.replace("、","','");
						sb.append(str);
					}


				}
				System.out.println(str);
			}
			System.out.println(sb.toString());
			br.close();
			reader.close();
			// write string to file
			FileWriter writer = new FileWriter("C:\\Users\\WISE\\Desktop\\新建文本文档2.txt");
			BufferedWriter bw = new BufferedWriter(writer);
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

