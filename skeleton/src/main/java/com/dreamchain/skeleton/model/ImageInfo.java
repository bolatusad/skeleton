package com.dreamchain.skeleton.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.groups.Default;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="image_info")
public class ImageInfo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3521068346267149792L;

	@Id
	@GeneratedValue
	private Long id;

	private String g;
	private String r;
	private String v;

	private int image_type;
	private int hard;

	private boolean is_complete;

	
	private Integer tag_times;
	
	private int pici;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getG() {
		return g;
	}

	public void setG(String g) {
		this.g = g;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public int getImage_type() {
		return image_type;
	}

	public void setImage_type(int image_type) {
		this.image_type = image_type;
	}

	public int getHard() {
		return hard;
	}

	public void setHard(int hard) {
		this.hard = hard;
	}

	public boolean isIs_complete() {
		return is_complete;
	}

	public void setIs_complete(boolean is_complete) {
		this.is_complete = is_complete;
	}

	public int getPici() {
		return pici;
	}

	public void setPici(int pici) {
		this.pici = pici;
	}

	@Column(name = "tag_times", columnDefinition = "integer default 0")
	public Integer getTag_times() {
		return tag_times;
	}

	public void setTag_times(Integer tag_times) {
		this.tag_times = tag_times;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ImageInfo [id=" + id + ", g=" + g + ", r=" + r + ", v=" + v + ", image_type=" + image_type + ", hard="
				+ hard + ", is_complete=" + is_complete + ", tag_times=" + tag_times + ", pici=" + pici + "]";
	}
	
	

}
