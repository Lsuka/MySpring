package cn.unicorn.myspring.di.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Dept implements Serializable {
	private Long deptno;
	private String dname;
	private Boolean enable;
	// 追加对象数据组(观察数组注入使用)
	private Emp[] emps;
	private String[] infos;

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Emp[] getEmps() {
		return emps;
	}

	public void setEmps(Emp[] emps) {
		this.emps = emps;
	}

	public String[] getInfos() {
		return infos;
	}

	public void setInfos(String[] infos) {
		this.infos = infos;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", enable=" + enable + ", emps=" + Arrays.toString(emps)
				+ ", infos=" + Arrays.toString(infos) + "]";
	}
}
