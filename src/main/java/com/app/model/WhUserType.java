package com.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Munisekhar Gunapati
 */
@Entity
@Table(name="whuser_tab",uniqueConstraints=@UniqueConstraint(columnNames={"whuser_type","whuser_code"}))
public class WhUserType implements Comparable<WhUserType> {
	@Id
	@Column(name="whuser_id")
	@GeneratedValue(generator="whusergen")
	@GenericGenerator(name="whusergen",strategy="increment")
	private long whUserTypeId;

	@Column(name="whuser_type")
	private String userType;
	@Column(name="whuser_code")
	private String whUserCode;

	@Column(name="whuser_for")
	private String whUserFor;
	@Column(name="whuser_mail")
	private String whUserMail;
	
	@Column(name="whuser_contact")
	private String whUserContact;
	@Column(name="whuser_idtype")
	private String whUserIdType;

	@Column(name="whuser_idother")
	private String whUserIdOther;
	@Column(name="whuser_idnumber")
	private String whUserIdNumber;
	
	@ManyToMany(mappedBy="itemVendors")
	private List<Item> venItems=new ArrayList<Item>(0);
	@ManyToMany(mappedBy="itemCustomers")
	private List<Item> custItems=new ArrayList<Item>(0);
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="whuser_crtdate")
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="whuser_lmdate")
	private Date lastModifiedDate;
	/**
	 * 
	 */
	public WhUserType() {
	}
	/**
	 * @param whUserTypeId
	 */
	public WhUserType(long whUserTypeId) {
		this.whUserTypeId = whUserTypeId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WhUserType [whUserTypeId=" + whUserTypeId + ", userType="
				+ userType + ", whUserCode=" + whUserCode + ", whUserFor="
				+ whUserFor + ", whUserMail=" + whUserMail + ", whUserContact="
				+ whUserContact + ", whUserIdType=" + whUserIdType
				+ ", whUserIdOther=" + whUserIdOther + ", whUserIdNumber="
				+ whUserIdNumber + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
	/**
	 * @return the whUserTypeId
	 */
	public long getWhUserTypeId() {
		return whUserTypeId;
	}
	/**
	 * @param whUserTypeId the whUserTypeId to set
	 */
	public void setWhUserTypeId(long whUserTypeId) {
		this.whUserTypeId = whUserTypeId;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the whUserCode
	 */
	public String getWhUserCode() {
		return whUserCode;
	}
	/**
	 * @param whUserCode the whUserCode to set
	 */
	public void setWhUserCode(String whUserCode) {
		this.whUserCode = whUserCode;
	}
	/**
	 * @return the whUserFor
	 */
	public String getWhUserFor() {
		return whUserFor;
	}
	/**
	 * @param whUserFor the whUserFor to set
	 */
	public void setWhUserFor(String whUserFor) {
		this.whUserFor = whUserFor;
	}
	/**
	 * @return the whUserMail
	 */
	public String getWhUserMail() {
		return whUserMail;
	}
	/**
	 * @param whUserMail the whUserMail to set
	 */
	public void setWhUserMail(String whUserMail) {
		this.whUserMail = whUserMail;
	}
	/**
	 * @return the whUserContact
	 */
	public String getWhUserContact() {
		return whUserContact;
	}
	/**
	 * @param whUserContact the whUserContact to set
	 */
	public void setWhUserContact(String whUserContact) {
		this.whUserContact = whUserContact;
	}
	/**
	 * @return the whUserIdType
	 */
	public String getWhUserIdType() {
		return whUserIdType;
	}
	/**
	 * @param whUserIdType the whUserIdType to set
	 */
	public void setWhUserIdType(String whUserIdType) {
		this.whUserIdType = whUserIdType;
	}
	/**
	 * @return the whUserIdOther
	 */
	public String getWhUserIdOther() {
		return whUserIdOther;
	}
	/**
	 * @param whUserIdOther the whUserIdOther to set
	 */
	public void setWhUserIdOther(String whUserIdOther) {
		this.whUserIdOther = whUserIdOther;
	}
	/**
	 * @return the whUserIdNumber
	 */
	public String getWhUserIdNumber() {
		return whUserIdNumber;
	}
	/**
	 * @param whUserIdNumber the whUserIdNumber to set
	 */
	public void setWhUserIdNumber(String whUserIdNumber) {
		this.whUserIdNumber = whUserIdNumber;
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
	@Override
	public int compareTo(WhUserType w) {
		return (int) (w.whUserTypeId-(this.whUserTypeId));
	}
	
	
	

}
