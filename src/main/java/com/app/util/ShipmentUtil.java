package com.app.util;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Munisekhar Gunapati
 */
@Component
public class ShipmentUtil {
	public List<String> getShipmentModes(){
		List<String> mlist=new LinkedList<String>();
		mlist.add("Air");
		mlist.add("Trunk");
		mlist.add("Ship");
		mlist.add("Train");
		return mlist;
	}
	public List<String> getShipmentGrades(){
		List<String> glist=new LinkedList<String>();
		glist.add("A");
		glist.add("B");
		glist.add("C");
		return glist;
		
	}
}
