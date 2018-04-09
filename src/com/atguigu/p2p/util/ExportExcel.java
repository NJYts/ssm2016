package com.atguigu.p2p.util;

import org.ansj.app.summary.SummaryComputer;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class ExportExcel {

	private static String path = "dowloads";

	public static File writeToExcel(List<Object[]> data, String source) throws Exception {
		try {
			File outFile = createNewFile();
			HSSFWorkbook workbook = new HSSFWorkbook();
			if (data.size() > 5000) {
				int size = data.size();
				double sheetSize = Math.ceil(size / 5000);
				for (int index = 0; index <= sheetSize; index++) {
					int start = index * 5000;
					int end = (start + 5000) > size ? size : start + 5000;
					List<Object[]> subList = data.subList(start, end);
					HSSFSheet sheet = workbook.createSheet("data_" + index);
					insertSheetData(outFile, workbook, sheet, subList);
				}
			} else {
				HSSFSheet sheet = workbook.createSheet("data");
				outFile = insertSheetData(outFile, workbook, sheet, data);
			}
			return outFile;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static File insertSheetData(File outFile, HSSFWorkbook workbook, HSSFSheet sheet, List<Object[]> data) throws Exception {
		sheet = addHeader(sheet);
		for (int index = 0; index < data.size(); index++) {
			try {
				HSSFRow row = sheet.createRow(index + 1);

				Object[] info = data.get(index);
				HSSFCell titleCell = row.createCell(0);
				HSSFCell publishtimeCell = row.createCell(1);
				HSSFCell siteCell = row.createCell(2);
				HSSFCell urlCell = row.createCell(3);
				HSSFCell tendencyCell = row.createCell(4);
				HSSFCell abstractCell = row.createCell(5);
				titleCell.setCellValue(info[0].toString());
				publishtimeCell.setCellValue(DateUtil.yyyyMMddHHmmss.format(info[1]));
				siteCell.setCellValue(info[2].toString());
				urlCell.setCellValue(info[3].toString());
				tendencyCell.setCellValue((Integer) info[4] == -1 ? "敏感" : "不敏感");
				String content = "";
				if (info[5] != null && StringUtils.isNotBlank(info[5].toString())) {
					SummaryComputer summaryComputer = new SummaryComputer(800, info[0].toString(), info[5].toString());

						/*content = HanLP.extractSummary(info[5].toString(),8).toString();*/
					content = summaryComputer.toSummary().getSummary();
					summaryComputer = null;
				}
				abstractCell.setCellValue(content);

			} catch (Exception e) {
				System.out.println("数据写入EXCEL异常：" + e.getMessage());
				continue;
			}

		}
		FileOutputStream outputStream = new FileOutputStream(outFile, false);
		workbook.write(outputStream);
		return outFile;
	}

	private static HSSFSheet addHeader(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		HSSFCell titleCell = row.createCell(0);
		HSSFCell publishtimeCell = row.createCell(1);
		HSSFCell siteCell = row.createCell(2);
		HSSFCell urlCell = row.createCell(3);
		HSSFCell tendencyCell = row.createCell(4);
		HSSFCell abstractCell = row.createCell(5);
		titleCell.setCellValue("标题");
		siteCell.setCellValue("网站");
		publishtimeCell.setCellValue("发布时间");
		tendencyCell.setCellValue("敏感性");
		urlCell.setCellValue("链接");
		abstractCell.setCellValue("摘要");
		return sheet;
	}
	public static File createNewFile() throws Exception {
		File file = new File("/");
		String filePath = file.getAbsolutePath() + "\\dowloads";
		File outFile = new File(filePath);
		if (!outFile.exists()) {
			outFile.mkdirs();
			outFile.setReadable(true);
			outFile.setWritable(true);
		}
		String fileName = generateFileName();
		File xlsFile = new File(outFile.getAbsolutePath() + "\\" + fileName);
		xlsFile.createNewFile();
		return xlsFile;
	}

	private static String generateFileName() {
		Calendar nowTime = Calendar.getInstance();
		Date time = nowTime.getTime();
		String fileName = time.getTime() + ".xls";
		return fileName;
	}

	public static void main(String[] args) {
		startRead();
	}
	private static void startRead() {
		File file = new File("C:\\Users\\WISE\\Downloads\\201804090937.xlsx");
		Date date = new Date();
		int count = 0;
		List<String[]> list = readXlsx(file, 0, 0, 0);
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime() - 86400L * 1000L * 2);
		for (int i = 1; i < list.size(); i++) {
			if (!"".equals(list.get(i)[0]) && !"".equals(list.get(i)[1])){
				String sql = "select id,url,title from `base_data` where url = '" + list.get(i)[4] + "'";
				List<String[]> list1 = JDBCUtils.query(sql, 3);
				if (list1.size() < 1) {
					count++;
					System.out.println(i+"、"+list.get(i)[1] + "   此内容未找到");
				} else {
					System.out.println(i+"、"+list.get(i)[1] + "   已存入 id:" + list1.get(0)[0]);
				}
				System.out.println("    "+sql);
			}
		}
		System.out.println("结束：" + (new Date().getTime() - date.getTime()) + " 未查到条数："+count);
	}

	public static List<String[]> readXls() throws IOException {
		InputStream is = new FileInputStream("C:\\Users\\WISE\\Desktop\\327.xls");
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<String[]> list = new ArrayList<>();
		// 循环工作表Sheet
		for (int numSheet = 1; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			int i = hssfSheet.getLastRowNum();
			// 循环行Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					HSSFCell siteId = hssfRow.getCell(0);
					HSSFCell vname = hssfRow.getCell(1);
					HSSFCell url = hssfRow.getCell(2);
					String[] test = {siteId==null?"":siteId.toString().replace(".0",""), vname==null?"":vname.toString(), url==null?"":url.toString()};
					list.add(test);
				}
			}
		}

		return list;


	}
	/*读取xlsx文件*/
	public static List<String[]> readXlsx(File file, int startrow, int startcol, int sheetnum) {
		List<String[]> list = new ArrayList<String[]>();
		FileInputStream fi = null;
		try {
			//File target = new File(filepath, filename);
			//File target = new File(file);
			fi = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fi);//xslx
			XSSFSheet sheet= wb.getSheetAt(sheetnum); //sheet 从0开始
			int rowNum = sheet.getLastRowNum() + 1;                     //取得最后一行的行号
			for (int i = startrow; i < rowNum; i++) {
				XSSFRow row = sheet.getRow(i);                             //行
				int cellNum = row.getLastCellNum();                     //每行的最后一个单元格位置
				String[] cells = new String[cellNum];
				for (int j = startcol; j < cellNum; j++) {                //列循环开始
					if (row != null) {
						//row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
						XSSFCell cell = row.getCell(j);
						if (cell != null){
							cells[j] = buildDate(cell);
						}
					}
				}
				list.add(cells);
			}

		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			try {
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public static String buildDate(XSSFCell cell) {
		String result = new String();
		switch (cell.getCellType()) {
			case XSSFCell.CELL_TYPE_NUMERIC:
				if (cell.getCellStyle().getDataFormat() == 176) {
					// 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					double value = cell.getNumericCellValue();
					Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
					result = sdf.format(date);
				} else {
					double value = cell.getNumericCellValue();
					CellStyle style = cell.getCellStyle();
					DecimalFormat format = new DecimalFormat();
					String temp = style.getDataFormatString();
					// 单元格设置成常规
					if (temp.equals("General")) {
						format.applyPattern("#");
					}
					result = format.format(value);
				}
				break;
			case XSSFCell.CELL_TYPE_STRING:// String类型
				result = cell.getStringCellValue();
				break;
			default:
				result = "";
				break;
		}
		return result;
	}
}


