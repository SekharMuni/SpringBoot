package com.app.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.controller.view.VendorInvoicePdfView;
import com.app.model.PurchaseOrder;
import com.app.model.PurchaseOrderDetails;
import com.app.service.IPurchaseOrderService;
import com.app.util.PurchaseOrderUtil;
import com.app.validator.PurchaseOrderValidator;

/**
 * @author Munisekhar Gunapati
 */

@Controller
public class PurchaseOrderController {
	
	@Autowired
	private PurchaseOrderValidator validator;
	
	@Autowired
	private PurchaseOrderUtil util;
	
	@Autowired
	private IPurchaseOrderService service;
	
	@GetMapping("regPurchaseOrder")
	public String showPurchaseOrder(ModelMap map) {
		util.getAllDynamics(map);
		map.addAttribute("po",new PurchaseOrder("OPEN"));
		return "PurchaseOrderRegister";
	}
	
	@PostMapping("insertPurchaseOrder")
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder po,ModelMap map) {
		util.getAllDynamics(map);
		long id=service.save(po);
		map.addAttribute("po",new PurchaseOrder("OPEN"));
		map.addAttribute("message","PurchaseOrder save("+id+") successfully");
		return "PurchaseOrderRegister";
		
	}
	
	@GetMapping("editPurchaseOrder")
	public String editPurchaseOrder(@RequestParam long poId,ModelMap map) {
		util.getAllDynamics(map);
		map.addAttribute("po",service.getOneById(poId));
		return "PurchaseOrderEdit";
		
	}
	
	@PostMapping("updatePurchaseOrder")
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder po,ModelMap map) {
		util.getAllDynamics(map);
		map.addAttribute("po",new PurchaseOrder("OPEN"));
		service.update(po);
		return "redirect:getAllPurchaseOrders";
	}
	
	@GetMapping("deletePurchaseOrder")
	public String deletePurchaseOrder(@RequestParam long poId,ModelMap map) {
		service.deleteById(poId);
		return "redirect:getAllPurchaseOrders";
	}
	
	@GetMapping("getAllPurchaseOrders")
	public String getAllPurchaseOrder(ModelMap map) {
		List<PurchaseOrder> pList=service.getAll();
		map.addAttribute("plists", pList);
		return "PurchaseOrderData";
	}
	
	
	
	@GetMapping("addPoItems")
	public String showAddItems(@RequestParam long orderId,ModelMap map) {
		PurchaseOrder po=service.getOneById(orderId);
		
		PurchaseOrderDetails poDtl=new PurchaseOrderDetails();
		poDtl.setPoHdrId(po.getPoId());
		poDtl.setSlno(po.getDetails().size()+1);
		map.addAttribute("poDtl", poDtl);
		map.addAttribute("po", po);
		
		
		map.addAttribute("venItems",util.getVendorItems(po.getVendor().getWhUserTypeId()));
		return "AddPoItems";
	}
	
	
	@PostMapping("poItemAdd")
	public String itemOperation(@ModelAttribute PurchaseOrderDetails poDtls,BindingResult errors,@RequestParam String itmOpr,ModelMap map) {
		PurchaseOrder po=service.getOneById(poDtls.getPoHdrId());
		String page=null;
		validator.validate(poDtls, errors);
		if("Add Item".equals(itmOpr)) {
			if(errors.hasErrors()) {
				map.addAttribute("poDtl",poDtls);
			}
			else {
				po.getDetails().add(poDtls);
				po.setDefaultStatus("PICKING");
				service.save(po);
				poDtls=new PurchaseOrderDetails();
				poDtls.setPoHdrId(po.getPoId());
				poDtls.setSlno(po.getDetails().size()+1);
				map.addAttribute("poDtl", poDtls);
				
			}
			map.addAttribute("venItems",util.getVendorItems(po.getVendor().getWhUserTypeId()));
			map.addAttribute("po", po);
			page="AddPoItems";
			
		}else if ("Save And Continue".equals(itmOpr)) {
			if(!po.getDetails().isEmpty()) {
				po.setDefaultStatus("ORDERED");
				service.update(po);
				page="redirect:getAllPurchaseOrders";
			}
		}
		
		return page;
	}
	
	@GetMapping("removeItem")
	public String removeItem(@RequestParam int slno,@RequestParam long orderId,ModelMap map) {
		PurchaseOrder po=service.getOneById(orderId);
		List<PurchaseOrderDetails> poDtlsList=po.getDetails();
		if(poDtlsList!=null) {
			Iterator poDtlitr=poDtlsList.iterator();
			while (poDtlitr.hasNext()) {
				PurchaseOrderDetails poDtls = (PurchaseOrderDetails) poDtlitr.next();
				if(poDtls.getSlno()==slno) 
					poDtlitr.remove();
			}
		}
		if(poDtlsList!=null && poDtlsList.size()>0) {
			int slNo=1;
			Iterator poDtlitr=poDtlsList.iterator();
			while (poDtlitr.hasNext()) {
			PurchaseOrderDetails poDtls = (PurchaseOrderDetails) poDtlitr.next();
				poDtls.setSlno(slNo++);
			}
		}
		if(poDtlsList.size()==0) po.setDefaultStatus("OPEN");
		service.update(po);
		PurchaseOrderDetails poDtls=new PurchaseOrderDetails();
		poDtls.setPoHdrId(po.getPoId());
		poDtls.setSlno(po.getDetails().size()+1);
		
		map.addAttribute("venItems",util.getVendorItems(po.getVendor().getWhUserTypeId()));
		map.addAttribute("po", po);
		map.addAttribute("poDtl", poDtls);
		return "AddPoItems";
	}
	
	
	@GetMapping("poConfirm")
	public String conformOrder(@RequestParam long poId) {
		PurchaseOrder po=service.getOneById(poId);
		po.setDefaultStatus("INVOICED");
		service.update(po);
		return "redirect:getAllPurchaseOrders";	
	}
	
	@GetMapping("cancelOrder")
	public String cancelOrder(@RequestParam long poId) {
		PurchaseOrder po=service.getOneById(poId);
		po.setDefaultStatus("CANCELLED");
		service.update(po);
		return "redirect:getAllPurchaseOrders";	
	}
	
	
	@GetMapping("poInvoiceGen")
	public ModelAndView generateInvoice(@RequestParam long poId) {
		PurchaseOrder po=service.getOneById(poId);
		ModelAndView m=null;
		if(po.getDefaultStatus().equals("INVOICED")){
			m=new ModelAndView(new VendorInvoicePdfView(),"po",po);
		}else{
			m=new ModelAndView("PurchaseOrderData","posList",service.getAll());
		}
		return m;
	}
}
