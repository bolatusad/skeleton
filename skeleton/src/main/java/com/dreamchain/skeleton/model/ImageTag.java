package com.dreamchain.skeleton.model;

import java.awt.Menu;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="image_tag")
public class ImageTag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5104766260357225085L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String phase;
	
	private Date tag_date;
	//用户id
	@ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user_id;
	//图片id
	@ManyToOne(targetEntity = ImageInfo.class)
    @JoinColumn(name = "img_info", referencedColumnName = "id")
	private ImageInfo img_info;
	//标记类型id
	@ManyToOne(targetEntity = Jgjcxx.class)
    @JoinColumn(name = "jg_info", referencedColumnName = "id")
	private Jgjcxx jg_info;
	
	public ImageTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImageTag(Long id, String phase, Date tag_date, User user_id, ImageInfo img_info, Jgjcxx ig_info) {
		super();
		this.id = id;
		this.phase = phase;
		this.tag_date = tag_date;
		this.user_id = user_id;
		this.img_info = img_info;
		this.jg_info = ig_info;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public Date getTag_date() {
		return tag_date;
	}
	public void setTag_date(Date tag_date) {
		this.tag_date = tag_date;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public ImageInfo getImg_info() {
		return img_info;
	}
	public void setImg_info(ImageInfo img_info) {
		this.img_info = img_info;
	}
	public Jgjcxx getJg_info() {
		return jg_info;
	}
	public void setJg_info(Jgjcxx jg_info) {
		this.jg_info = jg_info;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
