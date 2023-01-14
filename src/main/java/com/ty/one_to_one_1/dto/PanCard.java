package com.ty.one_to_one_1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PanCard {
	@Id
	private int p_id;
	private String p_name;
	private String p_address;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	@Override
	public String toString() {
		return "PanCard [p_id=" + p_id + ", p_name=" + p_name + ", p_address=" + p_address + "]";
	}
	

}
