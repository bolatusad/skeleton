package com.dreamchain.skeleton.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.dreamchain.skeleton.model.Jgjcxx;
import com.dreamchain.skeleton.model.User;

public class JgjcxxGrid {
	
	@Valid
	private Map<Long, JgjcxxCommand> jgjcxxMap;
	
	public JgjcxxGrid() {
	}
	
	public JgjcxxGrid(List<Jgjcxx> jgjcxxs) {
		jgjcxxMap = new LinkedHashMap<Long, JgjcxxCommand>();
		for (Jgjcxx jgjcxx : jgjcxxs){
			jgjcxxMap.put(jgjcxx.getId(), new JgjcxxCommand(jgjcxx));
		}
	}
	
	public List<Jgjcxx> getUsers() {
		List<Jgjcxx> jgjcxxs = new ArrayList<Jgjcxx>();
		for (JgjcxxCommand jgjcxxCommand : jgjcxxMap.values()) {
			jgjcxxs.add(jgjcxxCommand.toJgjcxx());
		}
		return jgjcxxs;
	}

	public Map<Long, JgjcxxCommand> getUserMap() {
		return jgjcxxMap;
	}

	public void setUserMap(Map<Long, JgjcxxCommand> jgjcxxs) {
		this.jgjcxxMap = jgjcxxs;
	}
	
}
