package com.smart.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
import com.smart.domain.User;

public class UserListExcelView extends AbstractXlsView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		response.setHeader("Context-Disposition", "attachment;filename="+ new String("用户列表".getBytes(), "ISO-8859-1"));
		List<User> userList = (List<User>) model.get("userList");
		HSSFSheet sheet = (HSSFSheet) workbook.createSheet("users");
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("账号");
		header.createCell(1).setCellValue("姓名");
		header.createCell(2).setCellValue("生日");
		
		int rowNum = 1;
		for(User user:userList) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(user.getUserName());
			row.createCell(1).setCellValue(user.getRealName());
			String createDate = DateFormatUtils.format(user.getBirthday(), "yyyy-MM-dd");
			row.createCell(2).setCellValue(createDate);
		}
	}
}