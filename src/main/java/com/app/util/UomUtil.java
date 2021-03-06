package com.app.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Uom;

@Component
public class UomUtil {
	public Map<String, String> getUomTypes() {
		Map<String, String> uomTypes = new LinkedHashMap<String, String>();
		uomTypes.put("PACK", "PACKING");
		uomTypes.put("NOPACK", "NOPACKING");
		uomTypes.put("NA", "-NA-");
		return uomTypes;
	}

	public List<Uom> replaceWithValues(List<Uom> uomList) {
		Iterator<Uom> uomItr = uomList.iterator();
		while (uomItr.hasNext()) {
			Uom uom = (Uom) uomItr.next();
			uom.setUomType(getUomTypes().get(uom.getUomType()));
		}
		return uomList;
	}

	public List<Uom> processUomImport(MultipartFile file) {
		List<Uom> uomList = null;
		if (file != null) {
			try {
				uomList = new ArrayList<Uom>();
				InputStream is = file.getInputStream();
				@SuppressWarnings("resource")
				XSSFWorkbook book = new XSSFWorkbook(is);
				XSSFSheet sheet = book.getSheet("UOMS");
				Iterator<Row> rowItr = sheet.iterator();
				while (rowItr.hasNext()) {
					Row row = (Row) rowItr.next();
					if (row.getRowNum() == 0)
						continue;
					uomList.add(new Uom(row.getCell(0).getStringCellValue(),
							row.getCell(1).getStringCellValue(), row.getCell(2)
									.getStringCellValue(),new Date()));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return uomList;
	}
}
