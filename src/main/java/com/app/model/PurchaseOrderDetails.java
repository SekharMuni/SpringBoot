package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Munisekhar Gunapati
 */
@Entity
@Table(name="po_dtls_tab")
public class PurchaseOrderDetails implements Comparable<PurchaseOrderDetails> {
	
	@Id
	@GeneratedValue(generator="")
	@GenericGenerator(name="podtlgen",strategy="increment")
	@Column(name="podtls_id")
	private Long poDtlId; 
	
	@Column(name="podtls_hdrid")
	private Long poHdrId;
	
	@Column(name="podtls_slno")
	private int slno;
	
	@ManyToOne
	@JoinColumn(name="po_itm_fk")
	private Item itemDetails;
	
	@Column(name="podtls_basecost")
	private Double baseCost;
	
	@Column(name="podtls_itmqty")
	private Long itemsQty;
	
	@Column(name="podtls_linevalue")
	private Double lineValue;
	

	public PurchaseOrderDetails() {
		super();
	}
	
	

	/**
	 * @param poDtlId
	 * @param poHdrId
	 * @param slno
	 * @param itemDetails
	 * @param baseCost
	 * @param itemsQty
	 * @param lineValue
	 */
	public PurchaseOrderDetails(Long poDtlId, Long poHdrId, int slno, Item itemDetails, Double baseCost, Long itemsQty,
			Double lineValue) {
		super();
		this.poDtlId = poDtlId;
		this.poHdrId = poHdrId;
		this.slno = slno;
		this.itemDetails = itemDetails;
		this.baseCost = baseCost;
		this.itemsQty = itemsQty;
		this.lineValue = lineValue;
	}


	public Long getPoDtlId() {
		return poDtlId;
	}



	public void setPoDtlId(Long poDtlId) {
		this.poDtlId = poDtlId;
	}



	public Long getPoHdrId() {
		return poHdrId;
	}



	public void setPoHdrId(Long poHdrId) {
		this.poHdrId = poHdrId;
	}



	public int getSlno() {
		return slno;
	}



	public void setSlno(int slno) {
		this.slno = slno;
	}



	public Item getItemDetails() {
		return itemDetails;
	}



	public void setItemDetails(Item itemDetails) {
		this.itemDetails = itemDetails;
	}



	public Double getBaseCost() {
		return baseCost;
	}



	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}



	public Long getItemsQty() {
		return itemsQty;
	}



	public void setItemsQty(Long itemsQty) {
		this.itemsQty = itemsQty;
	}



	public Double getLineValue() {
		return lineValue;
	}



	public void setLineValue(Double lineValue) {
		this.lineValue = lineValue;
	}

	@Override
	public String toString() {
		return "PurchaseOrderDetails [poDtlId=" + poDtlId + ", poHdrId=" + poHdrId + ", slno=" + slno + ", itemDetails="
				+ itemDetails + ", baseCost=" + baseCost + ", itemsQty=" + itemsQty + ", lineValue=" + lineValue + "]";
	}

	@Override
	public int compareTo(PurchaseOrderDetails o) {
		return o.getSlno()-this.getSlno();
	}

}
