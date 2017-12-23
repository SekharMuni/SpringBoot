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

@Entity
@Table(name = "uom_tab",uniqueConstraints={@UniqueConstraint(columnNames={"u_type","u_model"})})
public class Uom implements Comparable<Uom> {
	@Id
	@Column(name = "u_id")
	@GeneratedValue(generator="uomgen")
	@GenericGenerator(name="uomgen",strategy="increment")
	private long uomId;
	@Column(name = "u_type")
	private String uomType;
	@Column(name = "u_model")
	private String uomModel;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "u_cdate")
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "u_lmdate")
	private Date lastModifiedDate;
	@Column(name = "u_desc")
	private String description;
	
	public Uom() {
	}

	public long getUomId() {
		return uomId;
	}

	public void setUomId(long uomId) {
		this.uomId = uomId;
	}

	public String getUomType() {
		return uomType;
	}

	public void setUomType(String uomType) {
		this.uomType = uomType;
	}
	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uomType=" + uomType + ", uomModel="
				+ uomModel + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", description="
				+ description + "]";
	}

	public String getUomModel() {
		return uomModel;
	}

	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
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

	public Uom(long uomId) {
		this.uomId = uomId;
	}
	public Uom(String uomType, String uomModel, String description,Date createdDate) {
		this.uomType = uomType;
		this.uomModel = uomModel;
		this.description = description;
		this.createdDate = createdDate;
	}
	@Override
	public int compareTo(Uom o) {
		return (int) (o.getUomId()-this.getUomId());
	}

}
