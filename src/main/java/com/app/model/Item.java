package com.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Munisekhar Gunapati
 */
@Entity
@Table(name="item_tab")
public class Item implements Comparable<Item> {
	
	@Id
	@GeneratedValue(generator="itemgen")
	@GenericGenerator(name="itemgen",strategy="increment")
	@Column(name="itm_id")
	private long itemId;
	
	@Column(name="itm_code",unique=true)
	private String itemCode;
	@Column(name="itm_width")
	private String itemWidth;
	
	@Column(name="itm_length")
	private String itemLength;
	@Column(name="itm_height")
	private String itemHeight;
	
	@Column(name="itm_basecost")
	private Double itemBaseCost;
	@Column(name="itm_currency")
	private String itemBaseCurrency;

	@ManyToOne
	@JoinColumn(name="item_uom_fk")
	private Uom itemUom=new Uom();
	@ManyToOne
	@JoinColumn(name="item_ors_fk")
	private OrderMethod itemSaleOrdeMethod=new OrderMethod();
	@ManyToOne
	@JoinColumn(name="item_orp_fk")
	private OrderMethod itemPurchaseOrdeMethod=new OrderMethod();
	
	@ManyToMany
	@JoinTable(name="item_ven",joinColumns=@JoinColumn(name="item_fk"),inverseJoinColumns=@JoinColumn(name="item_ven_fk"))
	private List<WhUserType> itemVendors=new ArrayList<WhUserType>(0);
	
	@ManyToMany
	@JoinTable(name="item_cust",joinColumns=@JoinColumn(name="item_fk"),inverseJoinColumns=@JoinColumn(name="item_cust_fk"))
	private List<WhUserType> itemCustomers=new ArrayList<WhUserType>(0);
	
	@Column(name="itm_desc")
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="itm_cdrdate")
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="itm_lmdate")
	private Date lastModifiedDate;
	
	
	public Item() {
	}

	/**
	 * @param itemId
	 */
	public Item(long itemId) {
		this.itemId = itemId;
	}
	
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(String itemWidth) {
		this.itemWidth = itemWidth;
	}

	public String getItemLength() {
		return itemLength;
	}
	
	

	public void setItemLength(String itemLength) {
		this.itemLength = itemLength;
	}

	public String getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(String itemHeight) {
		this.itemHeight = itemHeight;
	}

	public Double getItemBaseCost() {
		return itemBaseCost;
	}

	public void setItemBaseCost(Double itemBaseCost) {
		this.itemBaseCost = itemBaseCost;
	}

	public String getItemBaseCurrency() {
		return itemBaseCurrency;
	}

	public void setItemBaseCurrency(String itemBaseCurrency) {
		this.itemBaseCurrency = itemBaseCurrency;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Uom getItemUom() {
		return itemUom;
	}

	public void setItemUom(Uom itemUom) {
		this.itemUom = itemUom;
	}

	public OrderMethod getItemSaleOrdeMethod() {
		return itemSaleOrdeMethod;
	}

	public void setItemSaleOrdeMethod(OrderMethod itemSaleOrdeMethod) {
		this.itemSaleOrdeMethod = itemSaleOrdeMethod;
	}

	public OrderMethod getItemPurchaseOrdeMethod() {
		return itemPurchaseOrdeMethod;
	}

	public void setItemPurchaseOrdeMethod(OrderMethod itemPurchaseOrdeMethod) {
		this.itemPurchaseOrdeMethod = itemPurchaseOrdeMethod;
	}

	
	public List<WhUserType> getItemVendors() {
		return itemVendors;
	}

	public void setItemVendors(List<WhUserType> itemVendors) {
		this.itemVendors = itemVendors;
	}

	public List<WhUserType> getItemCustomers() {
		return itemCustomers;
	}

	public void setItemCustomers(List<WhUserType> itemCustomers) {
		this.itemCustomers = itemCustomers;
	}

	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode
				+ ", itemWidth=" + itemWidth + ", itemLength=" + itemLength
				+ ", itemHeight=" + itemHeight + ", itemBaseCost="
				+ itemBaseCost + ", itemBaseCurrency=" + itemBaseCurrency
				+ ", itemUom=" + itemUom + ", itemSaleOrdeMethod="
				+ itemSaleOrdeMethod + ", itemPurchaseOrdeMethod="
				+ itemPurchaseOrdeMethod + ", itemVendors=" + itemVendors
				+ ", itemCustomers=" + itemCustomers + ", description="
				+ description + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	@Override
	public int compareTo(Item i) {
		return (int) (i.getItemId()-this.getItemId());
	}

}
