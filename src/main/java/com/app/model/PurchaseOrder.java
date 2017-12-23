package com.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Munisekhar Gunapati
 */

@Entity
@Table(name="po_tab")
public class PurchaseOrder implements Comparable<PurchaseOrder> {
	
	@Id
	@GeneratedValue(generator="pogen")
	@GenericGenerator(name="pogen",strategy="increment")
	@Column(name="po_id")
	private long poId;
	
	@Column(name="po_code")
	private String orderCode;
	
	@ManyToOne
	@JoinColumn(name="po_shm_id")
	private Shipment shipmentMode=new Shipment();
	@ManyToOne
	@JoinColumn(name="po_wh_id")
	private WhUserType vendor=new WhUserType();
	
	@Column(name="po_refnum")
	private String referenceNumber;
	
	@Column(name="po_check")
	private String qualityCheck;
	
	@Column(name="po_status")
	private String defaultStatus;
	@Column(name="po_desc")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="po_idfk")
	private List<PurchaseOrderDetails>	details=new ArrayList<PurchaseOrderDetails>();
	
	
	@Column(name="po_crddate")
	private Date createdDate;
	@Column(name="po_lmdate")
	private Date lastModifiedDate;
	
	public PurchaseOrder() {
		super();
	}

	/**
	 * @param defaultStatus
	 */
	public PurchaseOrder(String defaultStatus) {
		super();
		this.defaultStatus = defaultStatus;
	}
	
	
	@Override
	public String toString() {
		return "PurchaseOrder [poId=" + poId + ", orderCode=" + orderCode + ", shipmentMode=" + shipmentMode
				+ ", vendor=" + vendor + ", referenceNumber=" + referenceNumber + ", qualityCheck=" + qualityCheck
				+ ", defaultStatus=" + defaultStatus + ", description=" + description + ", details=" + details
				+ ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	public long getPoId() {
		return poId;
	}

	public void setPoId(long poId) {
		this.poId = poId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
	public Shipment getShipmentMode() {
		return shipmentMode;
	}

	public void setShipmentMode(Shipment shipmentMode) {
		this.shipmentMode = shipmentMode;
	}

	public WhUserType getVendor() {
		return vendor;
	}

	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}
	
	public List<PurchaseOrderDetails> getDetails() {
		return details;
	}

	public void setDetails(List<PurchaseOrderDetails> details) {
		this.details = details;
	}

	@Override
	public int compareTo(PurchaseOrder o) {
		return (int) (o.getPoId()-this.getPoId());
	}

}