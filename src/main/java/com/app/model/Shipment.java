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
@Table(name="shipment_tab",uniqueConstraints=@UniqueConstraint(columnNames = { "s_mode","s_code" }))
public class Shipment implements Comparable<Shipment> {
	
	@Id
	@GeneratedValue(generator="shipmentget")
	@GenericGenerator(name="shipmentget",strategy="increment")
	@Column(name="s_id")
	private long shipmentId;

	@Column(name="s_mode")
	private String shipmentMode;
	@Column(name="s_code")
	private String shipmentCode;

	@Column(name="s_shipment")
	private String shmnt;
	@Column(name="s_grade")
	private String shipmentGrade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="s_cdate")
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="s_lmdate")
	private Date lastmodifiedDate;

	@Column(name="s_desc")
	private String description;
	
	/**
	 *  default constructor
	 */
	public Shipment() {
		super();
	}

	/**
	 * @param shipmentId
	 */
	/*public Shipment(long shipmentId) {
		super();
		this.shipmentId = shipmentId;
	}
    */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shipment [shipmentId=" + shipmentId + ", shipmentMode="
				+ shipmentMode + ", shipmentCode=" + shipmentCode + ", shmnt="
				+ shmnt + ", shipmentGrade=" + shipmentGrade + ", createdDate="
				+ createdDate + ", lastmodifiedDate=" + lastmodifiedDate
				+ ", description=" + description + "]";
	}
	/**
	 * @return the shipmentId
	 */
	public long getShipmentId() {
		return shipmentId;
	}


	/**
	 * @param shipmentId the shipmentId to set
	 */
	public void setShipmentId(long shipmentId) {
		this.shipmentId = shipmentId;
	}

	/**
	 * @return the shipmentMode
	 */
	public String getShipmentMode() {
		return shipmentMode;
	}
	
	/**
	 * @param shipmentMode the shipmentMode to set
	 */
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}

	/**
	 * @return the shipmentCode
	 */
	public String getShipmentCode() {
		return shipmentCode;
	}

	/**
	 * @param shipmentCode the shipmentCode to set
	 */
	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}


	/**
	 * @return the shmnt
	 */
	public String getShmnt() {
		return shmnt;
	}


	/**
	 * @param shmnt the shmnt to set
	 */
	public void setShmnt(String shmnt) {
		this.shmnt = shmnt;
	}


	/**
	 * @return the shipmentGrade
	 */
	public String getShipmentGrade() {
		return shipmentGrade;
	}


	/**
	 * @param shipmentGrade the shipmentGrade to set
	 */
	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
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
	 * @return the lastmodifiedDate
	 */
	public Date getLastmodifiedDate() {
		return lastmodifiedDate;
	}


	/**
	 * @param lastmodifiedDate the lastmodifiedDate to set
	 */
	public void setLastmodifiedDate(Date lastmodifiedDate) {
		this.lastmodifiedDate = lastmodifiedDate;
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
	public int compareTo(Shipment s) {
		return (int) (s.getShipmentId()-this.getShipmentId());
	}
}
