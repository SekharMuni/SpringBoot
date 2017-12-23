package com.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author Munisekhar Gunapati
 */
@Component
public class WhUserTypeUtil {
	public List<String> getWhUserTypes(){
		List<String> mlist=new ArrayList<String>();
		mlist.add("Vendor");
		mlist.add("Customer");
		return mlist;
	}
	public List<String> getWhUserIdTypes(){
		List<String> mlist=new ArrayList<String>();
		mlist.add("PAN CARD");
		mlist.add("AADHAR");
		mlist.add("VOTERID");
		mlist.add("OTHER");
		return mlist;
	}
	public void getAllWhUserTypes(ModelMap map){
		map.addAttribute("whUserTypes",getWhUserTypes());
		map.addAttribute("whUserIdTypes", getWhUserIdTypes());
	}

}
