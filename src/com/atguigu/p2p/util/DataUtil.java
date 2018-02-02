package com.atguigu.p2p.util;


import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WISE on 2017/9/4.
 */
public class DataUtil {
	//private static final QueryRunner runner = new QueryRunner();
	public synchronized static Connection openConn(String host, String port,
												   String name, String username, String password) {
		Connection conn = null;
		try {
			String driver;
			String url;
			driver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://"
					+ host
					+ ":"
					+ port
					+ "/"
					+ name
					+ "?useUnicode=true&zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static boolean push() {
		List<String> fuzhu = new ArrayList<String>();
		List<String> zhuti = new ArrayList<String>();
		boolean flag = false;
		Connection connection = openConn("47.94.58.148", "5636", "pom_ys",
				"spiderdb", "WiseWeb123");
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.getResultSet();
			resultSet1 = statement.getResultSet();
			try {
				StringBuffer sb = new StringBuffer("");
				FileReader reader = new FileReader("C:\\Users\\WISE\\Desktop\\新建文本文档.txt");
				BufferedReader br = new BufferedReader(reader);
				FileReader reader1 = new FileReader("C:\\Users\\WISE\\Documents\\Tencent Files\\2829573051\\FileRecv\\主体词.txt");
				BufferedReader br1 = new BufferedReader(reader1);
				FileReader reader2 = new FileReader("C:\\Users\\WISE\\Documents\\Tencent Files\\2829573051\\FileRecv\\停用词.txt");
				BufferedReader br2 = new BufferedReader(reader2);
				String str = br.readLine();
				String str1 = br1.readLine();
				String strs2 = br2.readLine();
				String[] strs = str.split(" ");
				String[] strs1 = str1.split(" ");
				System.out.println(strs.length);
				int count = 0;
				int id = 0;
				String result = "";
				String save = "";
				String sqlsearch = "insert into wise_web_searchconf "
						+ "(name,keyword,last_gather_time,gather_time_interval,disabled,gather_id,flag,words_distance,words_distance_flag,local_words_distance,local_words_distance_flag) values ";
				String sql = "insert into wise_web_keywords_much_one (keyword,searchconfig_id,disabled,flag) values ";
				String sqlReturn = "insert into wise_web_keywords_return "
						+ "(local_word,subject_word,assist_wordb,assist_worda,remove_word,searchconfig_id,disabled,flag,words_distance,words_distance_flag,local_words_distance,local_words_distance_flag) values ";
				for (int j = 0; j < strs.length; j++) {
					result = result + strs[j] + "/";
					count++;
					if (count % 20 == 0) {
						result = result.substring(0, result.length() - 1);
						fuzhu.add(result);
						result = "";
					}
				}
				if(result.length() > 0){
					fuzhu.add(result.substring(0, result.length() - 1));
				}
				result = "";
				for (int i = 0; i < strs1.length; i++) {
					result = strs1[i] + "+";
					for (int j = 0; j < fuzhu.size(); j++) {
						result = result + fuzhu.get(i);

						id++;
						sqlsearch = sqlsearch+"('','"+result.substring(0, result.length()-1)+"','2017-09-4 11:48:42','20','1','2','0','20','0','0','1'),";
						statement.executeUpdate(sqlsearch.substring(0,sqlsearch.length() - 1));
						sql = sql + "('" + result.substring(0, result.length()-1) + "','" + id + "'" + ",'1','1'),";
						statement.executeUpdate(sql.substring(0, sql.length() - 1));
						sqlReturn = sqlReturn + "('','"+strs1[i]+"','','"+ result.substring(0, result.length()-1) + "','" + strs2 + "','" + id+ "',1,1,20,0,0,1),";
						statement.executeUpdate(sqlReturn.substring(0,sqlReturn.length() - 1));
						result = "";
					}
				}
				br1.close();
				reader1.close();
				br.close();
				reader.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
					if (resultSet1 != null) {
						resultSet1.close();
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean pushWaijiaobu() {
		List<String> fuzhu = new ArrayList<String>();
		List<String> zhuti = new ArrayList<String>();
		boolean flag = false;
		Connection connection = openConn("47.93.162.134", "5720", "wjbdb",
				"wisedb", "Wi$eWeb123");
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.getResultSet();
			resultSet1 = statement.getResultSet();
			try {
				StringBuffer sb = new StringBuffer("");
				/*FileReader reader = new FileReader("C:\\Users\\WISE\\Desktop\\新建文本文档.txt");
				BufferedReader br = new BufferedReader(reader);
				FileReader reader1 = new FileReader("C:\\Users\\WISE\\Documents\\Tencent Files\\2829573051\\FileRecv\\主体词.txt");
				BufferedReader br1 = new BufferedReader(reader1);
				FileReader reader2 = new FileReader("C:\\Users\\WISE\\Documents\\Tencent Files\\2829573051\\FileRecv\\停用词.txt");
				BufferedReader br2 = new BufferedReader(reader2);*/
				InputStreamReader reader = new InputStreamReader(new FileInputStream("C:\\Users\\WISE\\Desktop\\新建文本文档.txt"),"utf-8");
				BufferedReader br = new BufferedReader(reader);
				String s = null;
				String result = "";
				String searchZhuTi = "";
				int count = 0;
				while((s=br.readLine())!=null){
					result = result  + s + "/";
					searchZhuTi += s + " ";
					count++;
					if (count % 10 == 0) {
						result = result.substring(0, result.length() - 1);
						fuzhu.add(result);
						result = "";
					}
				}
				if(result.length() > 0){
					fuzhu.add(result.substring(0, result.length() - 1));
				}
				//String str = br.readLine();
				//String str1 = br1.readLine();
				//String strs2 = br2.readLine();
				//String[] strs = str.split(" ");
				//String[] strs1 = str1.split(" ");
				//System.out.println(str);
				/*for (int j = 0; j < strs.length; j++) {
					result = result + strs[j] + "/";
					count++;
					if (count % 10 == 0) {
						result = result.substring(0, result.length() - 1);
						fuzhu.add(result);
						result = "";
					}
				}
				if(result.length() > 0){
					fuzhu.add(result.substring(0, result.length() - 1));
				}*/
				String sqlsearchNew = "";
				String sqlsearch = "insert into `system_searchconf` "
						+ "(`name`,`last_gather_time`,gather_time_interval,disabled,gather_id,flag,`local_word`,`subject_word`,`assist_worda`,`assist_wordb`,`remove_word`,words_distance,words_distance_flag,local_words_distance,local_words_distance_flag) values ";
				String sql = "insert into `system_searchconf_keywords` (`keyword`,`special_keywords`,`searchconf_id`,`disabled`,`flag`) values ";
				result = "";
				//for (int i = 0; i < strs1.length; i++) {
					//result = strs1[i] + "+";
					for (int j = 0; j < fuzhu.size(); j++) {
						result = result + fuzhu.get(j);

						sqlsearchNew = sqlsearch + "('数据采集" + j + "','2017-11-30 00:00:00','20','1','2','0','','" + result.replace("/", " ") + "','','','','0','0','0','0')";
						statement.executeUpdate(sqlsearchNew);
						String getId = "select id from `system_searchconf` as s where s.name='数据采集"+j+"'";
						resultSet = statement.executeQuery(getId);
						if (resultSet.next()) {
							sql = sql + "('" + result.trim() + "',''," + resultSet.getLong(1) + ",'1','0'),";
						}
						result = "";
					}
				//}
				//}
				System.out.println(sql);
				statement.executeUpdate(sql.substring(0, sql.length() - 1));
				//br1.close();
				//reader1.close();
				br.close();
				reader.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
					if (resultSet1 != null) {
						resultSet1.close();
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void main(String[] args) {
		pushWaijiaobu();
	}


}
