package com.dreamchain.skeleton.model;

public class Display {
	private String image_name;
	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getJg_id() {
		return jg_id;
	}

	public void setJg_id(String jg_id) {
		this.jg_id = jg_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage_Tagid() {
		return image_Tagid;
	}

	public void setImage_Tagid(String image_Tagid) {
		this.image_Tagid = image_Tagid;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String jg_id;
	private String username;
	private String image_Tagid;
	private String phase;
	private String date;
	
	public Display(String image_name,String jg_id,String username,String image_Tagid,String phase,String date) {
		this.image_name = image_name;
		this.jg_id = jg_id;
		this.phase = phase;
		this.username = username;
		this.date =date;
		this.image_Tagid = image_Tagid;
	}
}
