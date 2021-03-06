package com.inno.modelview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MV_ENTITYCOLUMN")
public class EntityColumn {

	public EntityColumn() {}

	public EntityColumn(CoreEntity owner, CoreEntity foreignKey, String columnDescription, String columnName, String columnType) {
		this.owner = owner;
		this.foreignKey = foreignKey;
		this.columnDescription = columnDescription;
		this.columnName = columnName;
		this.columnType = columnType;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COREENTITY_ID", nullable = false)
	private CoreEntity owner;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="foreignKey")
	private CoreEntity foreignKey;

	@Column(length = 255)
	private String columnDescription;

	@Column(length = 255)
	private String columnName;

	@Column(length = 255)
	private String columnType;

	@JsonIgnore
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonIgnore
	public CoreEntity getOwner() {
		return owner;
	}

	public void setOwner(CoreEntity owner) {
		this.owner = owner;
	}

	public CoreEntity getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(CoreEntity foreignKey) {
		this.foreignKey = foreignKey;
	}

	public String getColumnDescription() {
		return columnDescription;
	}

	public void setColumnDescription(String columnDescription) {
		this.columnDescription = columnDescription;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	@Override
	public String toString() {
		return "EntityColumn{" +
				"id=" + id +
				", owner=" + owner +
				", foreignKey=" + foreignKey +
				", columnDescription='" + columnDescription + '\'' +
				", columnName='" + columnName + '\'' +
				", columnType='" + columnType + '\'' +
				'}';
	}
}
