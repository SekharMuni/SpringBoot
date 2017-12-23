package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.specification.UomSpecification;
import com.app.util.UomUtil;
import com.app.validator.UomValidator;

@Controller
public class UomController {
	
	@Autowired
	private IUomService service;
	@Autowired
	private UomUtil uomUtil;
	
	@Autowired
	private UomValidator validator;

	/**
	 * 1. Show Uom Register JSP on enter URL 'regUom' in Browser
	 */
	@GetMapping(value = {"/regUom"})
	public String showRegPage(ModelMap map) {
		map.addAttribute("uom", new Uom());
		map.addAttribute("uomTypes",uomUtil.getUomTypes());
		return "UomRegister";
	}

	/**
	 * 2. On submit UomRegister JSP Form, Insert Data into DB.
	 * 
	 */
	@PostMapping("/insertUom")
	public String saveUom(@ModelAttribute @Valid Uom uom, BindingResult errors,
			ModelMap map) {
		validator.validate(uom,errors);
		if (errors.hasErrors()) {
			map.addAttribute("uom", uom);
			map.addAttribute("uomTypes",uomUtil.getUomTypes());
		} else {
			long uomId = service.save(uom);
			map.addAttribute("message", "UOM (" + uomId + ") Created ");
			map.addAttribute("uom", new Uom());
		}
		map.addAttribute("uomTypes",uomUtil.getUomTypes());
		return "UomRegister";
	}

	/**
	 * 3. Data Fetch From DB to UI
	 */
	@GetMapping("/getAllUoms")
	public String getUoms(
			@PageableDefault(sort = "uomId", size = 5, direction = Direction.DESC) Pageable pageable,
			@ModelAttribute Uom uom, ModelMap map) {
		Specification<Uom> spec = new UomSpecification(uom);
		Page<Uom> uomPage = service.getAll(spec, pageable);
		List<Uom> uomList = uomPage.getContent();
		uomUtil.replaceWithValues(uomList);
		map.addAttribute("uoms", uomList);
		map.addAttribute("uomPage", uomPage);
		return "UomData";
	}

	/**
	 * 4. DELETE the data from DB to UI
	 */
	@GetMapping("/deleteUom")
	public String deleteUom(@RequestParam("uomId") long uomId) {
		service.deleteById(uomId);
		return "redirect:getAllUoms";
	}

	/**
	 * 5.Update Data From DB to UI
	 */
	@GetMapping("/editUom")
	public String showEdit(@RequestParam("uomId") long uomId, ModelMap map) {
		Uom ob = service.getOneById(uomId);
		map.addAttribute("uom", ob);
		map.addAttribute("uomTypes", uomUtil.getUomTypes());
		return "UomDataEdit";
	}

	@PostMapping("/updateUom")
	public String updateUom(@Valid Uom uom, BindingResult errors, ModelMap map) {
		validator.validate(uom, errors);
		String page=null;
		// service.update(uom);
		// //map.addAttribute("uom",uom);
		// return "redirect:getAllUoms";
		if (errors.hasErrors()) {
			map.addAttribute("uom", uom);
			// map.addAttribute("uom", ob);
			map.addAttribute("uomTypes", uomUtil.getUomTypes());
			// map.addAttribute("uom", new Uom());
			page="UomDataEdit";
		} else {
			service.update(uom);
			map.addAttribute("uom",new Uom());
			page="redirect:getAllUoms";
		}
		// return "redirect:getAllUoms";
		return page;
	}
}