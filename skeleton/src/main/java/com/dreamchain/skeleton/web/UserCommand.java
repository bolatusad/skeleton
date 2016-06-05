package com.dreamchain.skeleton.web;

import com.dreamchain.skeleton.model.User;

public class UserCommand extends User {

	private static final long serialVersionUID = -4686811929329857418L;

	private Boolean selected = false;
	
	public UserCommand() {}

	public UserCommand(User user) {
		setId(user.getId());
		setName(user.getName());
		setPassword(user.getPassword());
		setEmail(user.getEmail());
		setAddress(user.getAddress());
		setRole(user.getRole());
		setUser_id(user.getUser_id());
	}

	public User toUser() {
		User user = new User();
		user.setId(getId());
		user.setName(getName());
		user.setPassword(getPassword());
		user.setEmail(getEmail());
		user.setAddress(getAddress());
		user.setRole(getRole());
		user.setUser_id(getUser_id());
		return user;
	}
	
	public Boolean getSelected() {
		return selected;
	}
	
	public void setSelected(Boolean changed) {
		this.selected = changed;
	}
	
}