package cn.unicorn.myspring.di.vo;

import java.io.Serializable;
import java.util.Map;

public class Dept implements Serializable {
	private Long deptno;
	private String dname;
	private Boolean enable;
	// 追加对象数据组(观察数组注入使用)
	private Map<String, Emp> emps;
	private Map<Integer, String> infos;

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

	public Map<String, Emp> getEmps() {
		return emps;
	}

	public void setEmps(Map<String, Emp> emps) {
		this.emps = emps;
	}

	public Map<Integer, String> getInfos() {
		return infos;
	}

	public void setInfos(Map<Integer, String> infos) {
		this.infos = infos;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", enable=" + enable + ", emps=" + emps + ", infos="
				+ infos + "]";
	}

}