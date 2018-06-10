package com.atguigu.p2p.test;

import com.atguigu.p2p.util.JDBCUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WISE on 2018/3/27.
 */
public class DataVerification {
	private static final Logger logger = LoggerFactory.getLogger(ExsportData.class);
	@Test
	public void exsport() {
		Map<String, List<String[]>> map = new HashMap<String, List<String[]>>();
		String fileName = "";
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = JDBCUtils.getConnection();
	}
	public List<String> readExsel(){
return null;
	}

}
