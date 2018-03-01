package com.atguigu.p2p.test;

import com.atguigu.p2p.util.JDBCUtils;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WISE on 2018/3/1.
 */
public class ExsportData {
	private static final Logger logger = LoggerFactory.getLogger(ExsportData.class);
	@Test
	public void exsport() {
		Map<String, List<String[]>> map = new HashMap<String, List<String[]>>();
		String fileName = "";
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection =JDBCUtils.getConnection();
		try {
			statement = connection.createStatement();
			String seachconf = "SELECT id,`name`,subject_word FROM system_searchconf";
			resultSet = statement.executeQuery(seachconf);
			String SQL = "";
			while (resultSet.next()) {
				map.clear();
				int seachCofId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String keyword = resultSet.getString(3);
				SQL = "SELECT title,site_name FROM base_data WHERE search_conf_id ="
				+seachCofId+" AND publishtime>'2018-2-28 12:00:00' GROUP BY titlehash order by publishtime Desc LIMIT 100";
				List<String[]> result = JDBCUtils.query(SQL,2);
				String[] str = {"标题","网站来源"};
				result.add(0,str);
				fileName = keyword;
				map.put(name,result);
				reportExcel(map,fileName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.closeConnection(connection, statement, resultSet);
		}

	}
	// 生成excel的方法
	public static void reportExcel(Map<String, List<String[]>> map,String fileName) {
		String filePath = "C:\\Users\\WISE\\Desktop\\标题匹配";
		OutputStream out = null;
		WritableWorkbook workbook = null;
		try {
			/************** 设置单元格字体 ***************/
			WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 12);
			WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD);
			/** ************设置单元格样式，灵活备用************ */
			// 用于标题居中
			WritableCellFormat wcf_title = new WritableCellFormat(BoldFont);
			wcf_title.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf_title.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_title.setAlignment(Alignment.CENTRE); // 文字水平对齐
			wcf_title.setWrap(false); // 文字是否换行
			// 用于正文居左
			WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
			wcf_left.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_left.setAlignment(Alignment.LEFT); // 文字水平对齐
			wcf_left.setWrap(false); // 文字是否换行
			/************** 设置单元格样式，灵活备用 *************/
			// 创建输出流
			out = new FileOutputStream(filePath + "/" + fileName + ".xls");
			// 创建工作薄
			workbook = Workbook.createWorkbook(out);
			int len = map.size();
			WritableSheet[] sheets = new WritableSheet[len];
			/******* 正文数据 **********/
			int index = 0;
			for (Map.Entry<String, List<String[]>> entry : map.entrySet()) {// 查询接口集合
				List<String[]> list = entry.getValue();// 一个接口多个用户查询结果集合
				String interfaceName = entry.getKey();// 接口名
				// 创建工作表
				sheets[index] = workbook.createSheet(interfaceName, 0);
				for (int row = 0; row < list.size(); row++) {// 循环写入一个接口对应的所有数据到一个sheet中
					String[] str = list.get(row);
					for (int col = 0; col < str.length; col++) {// 写入一行数据
						String val = (str[col] + "").replace("null", "");
						sheets[index].addCell(new Label(col, row, val,
								row == 0 ? wcf_title : wcf_left));
					}
				}
				index++;
			}
			workbook.write();
			System.out.println("*********** 工作薄写入完成  ***********");
		} catch (Exception e) {
			logger.debug("工作薄Error: {}", e.getStackTrace());
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (Exception e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add(0,"0");
		for (String s:list){
			System.out.println(s);
		}
	}
}
