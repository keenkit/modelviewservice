package com.inno.modelview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="coreEntity")
public class CoreEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private String entityName;
	private String businessValue;
	private String entityBuilder;
	private CoreEntity parentEntity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getBusinessValue() {
		return businessValue;
	}
	public void setBusinessValue(String businessValue) {
		this.businessValue = businessValue;
	}
	public String getEntityBuilder() {
		return entityBuilder;
	}
	public void setEntityBuilder(String entityBuilder) {
		this.entityBuilder = entityBuilder;
	}
	public CoreEntity getParentEntity() {
		return parentEntity;
	}
	public void setParentEntity(CoreEntity parentEntity) {
		this.parentEntity = parentEntity;
	}
	
	
}

