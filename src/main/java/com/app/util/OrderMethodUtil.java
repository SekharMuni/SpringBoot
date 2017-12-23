package com.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author Munisekhar Gunapati
 */
@Component
public class OrderMethodUtil {
	public List<String> getOrderModes(){
		List<String> mlist=new ArrayList<String>();
		mlist.add("Sale");
		mlist.add("Purchase");
		return mlist;
	}
	public List<String> getOrderMethods(){
		List<String> mlist=new ArrayList<String>();
		mlist.add("FIFO");
		mlist.add("LIFO");
		mlist.add("FCFO");
		mlist.add("FEFO");
		return mlist;
	}
	public List<String> getOrderAccepts(){
		List<String> mlist=new ArrayList<String>();
		mlist.add("Multi-Model");
		mlist.add("Accept Return");
		return mlist;
	}
	public void getAllOrderMethods(ModelMap map){
		map.addAttribute("orderModes",getOrderModes());
		map.addAttribute("orderMethods",getOrderMethods());
		map.addAttribute("orderAccepts",getOrderAccepts());
	}

}
