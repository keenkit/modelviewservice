package com.inno.modelview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Step {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	private String shortDescription;
	
	private String descroption;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="owner")
	private Topic topic;
	
	private String screenShot;
	
	public int getId() {
		return id;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public String getDescroption() {
		return descroption;
	}
	public Topic getTopic() {
		return topic;
	}
	public String getScreenShot() {
		return screenShot;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public void setDescroption(String descroption) {
		this.descroption = descroption;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public void setScreenShot(String screenShot) {
		this.screenShot = screenShot;
	}
	
	
	
}
