package com.dreamchain.skeleton.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jgjcxx")
public class Jgjcxx implements Serializable {

	private static final long serialVersionUID = 7837831050599016702L;

   @Id
   @GeneratedValue
   private Long id;
   
   
 
   private String jg_yw;

   private String jg_msfl;

   private String jg_hm;

   private String jg_mz;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getJg_yw() {
	return jg_yw;
}
public void setJg_yw(String jg_yw) {
	this.jg_yw = jg_yw;
}
public String getJg_msfl() {
	return jg_msfl;
}
public void setJg_msfl(String jg_msfl) {
	this.jg_msfl = jg_msfl;
}
public String getJg_hm() {
	return jg_hm;
}
public void setJg_hm(String jg_hm) {
	this.jg_hm = jg_hm;
}
public String getJg_mz() {
	return jg_mz;
}
public void setJg_mz(String jg_mz) {
	this.jg_mz = jg_mz;
}
   
}
