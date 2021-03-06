package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomsExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			Workbook book, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		//File Name Setting
		res.addHeader("Content-Description", "attachment;filemenu=\"UOMsData.xslx\"");
		List<Uom> uomList=(List<Uom>) map.get("uomList");
		Sheet sheet=(Sheet) book.createSheet("Uoms");
		setHead(sheet);
		setBody(sheet,uomList);
	}
	private void setHead(Sheet sheet){
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("UOM ID");
		row.createCell(1).setCellValue("UOM TYPE");
		row.createCell(2).setCellValue("UOM MODEL");
		row.createCell(3).setCellValue("UOM CREATED");
		row.createCell(4).setCellValue("UOM MODIFIED");
		row.createCell(5).setCellValue("UOM NOTES");
	}
	private void setBody(Sheet sheet,List<Uom> uomList){
		int rowNum=1;
		for(Uom uom:uomList){
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(uom.getUomId());
			row.createCell(1).setCellValue(uom.getUomModel());
			row.createCell(2).setCellValue(uom.getUomModel());
			row.createCell(3).setCellValue(uom.getCreatedDate().toString());
			row.createCell(4).setCellValue(uom.getLastModifiedDate()!=null?uom.getLastModifiedDate().toString():"-NA-");
			row.createCell(5).setCellValue(uom.getDescription());
			
		}
	}
}
