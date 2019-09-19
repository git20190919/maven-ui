package org.lanqiao.entity;

public class Student {
	private Long sno;
	private String sname;
	private Integer sage;
	private String ssex;
	
	
	
	public Student(Long sno, String sname, Integer sage, String ssex) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sage = sage;
		this.ssex = ssex;
	}
	
	
	public Student() {
	
	}


	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	
	

}
