package com.dreamchain.skeleton.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="image_pici")
public class Pici {
	
	@Id
	@GeneratedValue
	private int id;//批次 
	
	private String start;
	private String end;
	private int num;//如果真实数量，比它大，我们就抽取指定数量，如果比它小，就抽取所有的
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Pici [id=" + id + ", start=" + start + ", end=" + end + ", num=" + num + "]";
	}
	
	
	
	
	
	
}
