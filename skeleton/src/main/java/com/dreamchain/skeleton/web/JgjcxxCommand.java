package com.dreamchain.skeleton.web;

import com.dreamchain.skeleton.model.Jgjcxx;

public class JgjcxxCommand  extends Jgjcxx{

	public JgjcxxCommand(){}
	
	public JgjcxxCommand(Jgjcxx jgjcxx){
		setId(jgjcxx.getId());
		setJg_hm(jgjcxx.getJg_hm());
		setJg_msfl(jgjcxx.getJg_msfl());
		setJg_mz(jgjcxx.getJg_mz());
		setJg_yw(jgjcxx.getJg_yw());
	}
	
	public Jgjcxx toJgjcxx(){
		Jgjcxx jgjcxx = new  Jgjcxx();
		jgjcxx.setId(getId());
		jgjcxx.setJg_hm(getJg_hm());
		jgjcxx.setJg_msfl(getJg_msfl());
		jgjcxx.setJg_mz(getJg_mz());
		jgjcxx.setJg_yw(getJg_yw());
		return jgjcxx;
	}
}
