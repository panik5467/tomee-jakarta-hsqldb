package com.mastertheboss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimpleProperty {

	public static SimpleProperty newSimpleProperty(String k, String v) {
		SimpleProperty o = new SimpleProperty();
		o.key = k;
		o.value = v;
		return o;
	}

	@Id
	@Column(name="id")
	private String key;

	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SimpleProperty [key=" + key + ", value=" + value + "]";
	}



}