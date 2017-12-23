package com.app.controller.multipart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.controller.view.UomsExcelView;
import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;

@Controller
public class UomMultipartController {
	@Autowired
	private IUomService service;
	@Autowired
	private UomUtil uomUtil;
	
	@GetMapping("/uomMultipart")
	public String showUomMultiprtFile(){
		return "UomMultipart";	
	}
	@GetMapping("/uomExport")
	public ModelAndView exportUom(){
		List<Uom> uoms=service.getAll();
		return new ModelAndView(new UomsExcelView(),"uomList",uoms);
	}
	@PostMapping("/uomImport")
	public String importUom(@RequestParam("eFile")MultipartFile file,ModelMap map){
		List<Uom> uomList=uomUtil.processUomImport(file);
		if(uomList !=null && uomList.size()>0)
			service.saveMultiple(uomList);
		map.addAttribute("importMessage", "Data Imported Successfully");
		return "UomMultipart";
	
	}
}
