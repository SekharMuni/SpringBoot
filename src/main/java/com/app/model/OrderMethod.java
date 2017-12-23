/**
 * 
 */
package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Munisekhar Gunapati
 *
 */
@Entity
@Table(name="order_method",uniqueConstraints=@UniqueConstraint(columnNames={"order_mode","order_code"}))
public class OrderMethod implements Comparable<OrderMethod> {
	@Id
	@GeneratedValue(generator="orderGen")
	@GenericGenerator(name="orderGen",strategy="increment")
	@Column(name="order_id")
	private long orderMethodId;

	@Column(name="order_mode")
	private String orderMode;
	@Column(name="order_code")
	private String orderCode;

	@Column(name="order_mtd")
	private String orderMtd;
	@Column(name="order_accpt")
	private String orderAccept;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="order_crtdate")
	private Date createdDate;
	@Column(name="order_lmfdate")
	private Date lastModifiedDate;

	@Column(name="order_desc")
	private String description;
	
	public OrderMethod() {
		super();
	}
	
	public OrderMethod(long orderMethodId) {
		super();
		this.orderMethodId = orderMethodId;
	}

	@Override
	public String toString() {
		return "OrderMethod [orderMethodId=" + orderMethodId + ", orderMode="
				+ orderMode + ", orderCode=" + orderCode + ", orderMtd="
				+ orderMtd + ", orderAccept=" + orderAccept + ", createdDate="
				+ createdDate + ", lastModifiedDate=" + lastModifiedDate
				+ ", description=" + description + "]";
	}

	/**
	 * @return the orderMethodId
	 */
	public long getOrderMethodId() {
		return orderMethodId;
	}

	/**
	 * @param orderMethodId the orderMethodId to set
	 */
	public void setOrderMethodId(long orderMethodId) {
		this.orderMethodId = orderMethodId;
	}

	/**
	 * @return the orderMode
	 */
	public String getOrderMode() {
		return orderMode;
	}

	/**
	 * @param orderMode the orderMode to set
	 */
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	/**
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * @param orderCode the orderCode to set
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * @return the orderMtd
	 */
	public String getOrderMtd() {
		return orderMtd;
	}

	/**
	 * @param orderMtd the orderMtd to set
	 */
	public void setOrderMtd(String orderMtd) {
		this.orderMtd = orderMtd;
	}

	/**
	 * @return the orderAccept
	 */
	public String getOrderAccept() {
		return orderAccept;
	}

	/**
	 * @param orderAccept the orderAccept to set
	 */
	public void setOrderAccept(String orderAccept) {
		this.orderAccept = orderAccept;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int compareTo(OrderMethod o) {
		return (int) (o.getOrderMethodId()-this.getOrderMethodId());
	}

}
