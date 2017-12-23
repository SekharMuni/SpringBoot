package com.app.controller.view;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.PurchaseOrder;
import com.app.model.PurchaseOrderDetails;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorInvoicePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter w,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PurchaseOrder po=(PurchaseOrder) map.get("po");
		
		List<PurchaseOrderDetails> podtls=po.getDetails();
		double finalCost=0.0;
		
		for (PurchaseOrderDetails dtls : podtls) {
			finalCost+=dtls.getItemDetails().getItemBaseCost()*dtls.getItemsQty();
		}
		doc.add(new Paragraph("VENDOR INVOICE CODE:VEN-"+po.getOrderCode()));
		
		Font font=FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		
		PdfPTable table=new PdfPTable(4);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[]{2.5f,2.5f,2.5f,2.5f});
		table.setSpacingBefore(10);
		
		cell.setPhrase(new Phrase("Vendor Code",font));
		table.addCell(cell);
		table.addCell(po.getVendor().getWhUserCode());
		
		cell.setPhrase(new Phrase("Order Code",font));
		table.addCell(cell);
		table.addCell(po.getOrderCode());
		
		cell.setPhrase(new Phrase("Final Cost",font));
		table.addCell(cell);
		table.addCell(new BigDecimal(finalCost).setScale(3,RoundingMode.CEILING).toString());
		
		
		cell.setPhrase(new Phrase("Shipment Type",font));
		table.addCell(cell);
		table.addCell(po.getShipmentMode().getShipmentCode());
		
		
		PdfPTable table1=new PdfPTable(5);
		table1.setWidthPercentage(100.0f);
		table1.setWidths(new float[]{1.0f,3.0f,2.0f,2.0f,2.0f});
		table1.setSpacingBefore(10);
		
		
		cell.setPhrase(new Phrase("Sl NO",font));
		table1.addCell(cell);
		
		cell.setPhrase(new Phrase("Item",font));
		table1.addCell(cell);
		
		cell.setPhrase(new Phrase("Cost",font));
		table1.addCell(cell);
		
		cell.setPhrase(new Phrase("Quantity",font));
		table1.addCell(cell);
		
		cell.setPhrase(new Phrase("Total",font));
		table1.addCell(cell);
		
		for(PurchaseOrderDetails details:podtls) {
			table1.addCell(String.valueOf(details.getSlno()));
			table1.addCell(String.valueOf(details.getItemDetails().getItemCode()));
			table1.addCell(String.valueOf(details.getItemDetails().getItemBaseCost()));
			table1.addCell(String.valueOf(details.getItemsQty()));
			table1.addCell(String.valueOf(details.getItemDetails().getItemBaseCost()*details.getItemsQty()));
		}
		
		doc.add(table);
		doc.add(table1);
		
		doc.add(new Phrase("Generated On:"+new Date()));
		
	}

}
