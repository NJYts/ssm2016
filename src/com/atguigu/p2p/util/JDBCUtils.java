package com.atguigu.p2p.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
	private static final Logger LOGGER = Logger.getLogger(JDBCUtils.class);
	private static ComboPooledDataSource dataSource;
	static {
		//创建连接对象
		dataSource = new ComboPooledDataSource();
		InputStream input = JDBCUtils.class.getResourceAsStream("/dbcp.properties");
		Properties properties = new Properties();
		//配置数据库连接参数
		try {
			properties.load(input);
			dataSource.setDriverClass(properties.getProperty("jdbc.driver"));
			dataSource.setJdbcUrl(properties.getProperty("jdbc.url"));
			dataSource.setUser(properties.getProperty("jdbc.username"));
			dataSource.setPassword(properties.getProperty("jdbc.password"));
			//配置连接池
			dataSource.setAcquireIncrement(5);
			dataSource.setInitialPoolSize(20);
			dataSource.setMaxPoolSize(50);
			dataSource.setMinPoolSize(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(dataSource);
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("获取数据库连接失败！");
		}
	}
	
	/***
	 * 初始化关键词
	 * @param countSql
	 * @param list
	 * @return
	 */
	public static List<String> findKeywords(String countSql, List<String> list) {
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			
			statement = connection.createStatement();
			 resultSet = statement.executeQuery(countSql);

			while (resultSet.next()) {
				String str = resultSet.getString(1);
				/*object[0] = resultSet.getLong(1);
				object[1] = resultSet.getInt(2);*/
				list.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection(connection, statement, resultSet);
		}
		return list;
	}
	/**
	 * 释放数据库连接
	 * @param con
	 * @param statement
	 * @param resultSet
	 */
	public synchronized static void closeConnection(Connection con, Statement statement,
													ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
				resultSet = null;
			}
			if(statement != null) {
				statement.close();
				statement = null;
			}
			if(con != null) {
				con.close();
				con = null;
			}
		} catch(Exception e) {
			throw new RuntimeException("释放连接失败！");
		}
	}

	public static List<String[]> queryKeywords(String sql_keywords) {
		List<String[]> keywords = new ArrayList<String[]>();
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql_keywords);
			while(resultSet.next()) {
				String[] str = new String[4];
				str[0] = resultSet.getString(1);
				str[1] = resultSet.getString(2);
				str[2] = resultSet.getString(3);
				str[3] = resultSet.getString(4);
				keywords.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, statement, resultSet);
		}
		return keywords;
	}
	
	/***
	 * 根据sql查询返回String[]集合
	 * @param sql
	 * @param size 参数个数
	 * @return
	 */
	public static List<String[]> query(String sql, int size) {
		List<String[]> list = new ArrayList<String[]>();
		Connection connection = JDBCUtils.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String[] str = new String[size];
				for(int i=0;i<size;i++)
					str[i] = resultSet.getString(i+1);
				list.add(str);
			}
		} catch (SQLException e) {
			LOGGER.error("query fail.sql="+sql);
		} finally {
			JDBCUtils.closeConnection(connection, statement, resultSet);
		}
		return list;
	}
	public static int saveOrUpdate(String sql) {
		if(sql == null || sql.isEmpty()) return -1;
		int count = 0;
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			count = statement.executeUpdate(sql);
		} catch (SQLException e) {
			count = -1;
			LOGGER.error("saveOrUpdate Faile.\n sql="+sql);
		} finally {
			closeConnection(connection, statement, null);
		}
		return count;
	}
	public static int saveListSql(List<String> sqlList) {
		if(sqlList == null || sqlList.size()==0) return -1;
		int count = 0;
		Connection connection = getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			for (String sql:sqlList){
				statement.addBatch(sql);
				count ++;
			}
			statement.executeBatch();
			System.out.println("执行成功，共"+count+"条!");
		} catch (SQLException e) {
			count = -1;
			e.getMessage();
		} finally {
			closeConnection(connection, statement, null);
		}
		return count;
	}
	public static String queryUnique(String sql) {
		Connection connection = JDBCUtils.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		String maxId = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				maxId = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeConnection(connection, statement, resultSet);
		}
		return maxId;
	}


}
