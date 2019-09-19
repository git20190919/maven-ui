package org.lanqiao.entity;

import java.util.List;

public class Role {
	private int id;
	private String rname;
	private String by001;//存放图片的url地址
	private List<Priv> lp;
	
	public String getPrivs() {
		String s = "";
		if(lp != null) {
			for(Priv p : lp) {
				s+=p.getName()+"、";
			}
		}
		return s;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public List<Priv> getLp() {
		return lp;
	}
	public void setLp(List<Priv> lp) {
		this.lp = lp;
	}


	public String getBy001() {
		return by001;
	}


	public void setBy001(String by001) {
		this.by001 = by001;
	}
	
}
