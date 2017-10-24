package cn.unicorn.myspring.jdbc.vo;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
	private String title;
	private Date pubdate;
	private String note;
	private double price;
	private int readcount;
	private long nid;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", pubdate=" + pubdate + ", note=" + note + ", price=" + price + ", readcount="
				+ readcount + ", nid=" + nid + "]";
	}

}
