package cn.unicorn.myspring.di.vo;

import java.io.Serializable;

public class Dept implements Serializable {
	private Long deptno;
	private String dname;
	private Boolean enable;

	public Dept(Long deptno, String dname, Boolean enable) {
		this.deptno = deptno;
		this.dname = dname;
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", enable=" + enable + "]";
	}
}