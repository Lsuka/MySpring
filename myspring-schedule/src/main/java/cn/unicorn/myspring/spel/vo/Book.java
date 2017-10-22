package cn.unicorn.myspring.spel.vo;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
	private String title;
	private String pub;// 出版社

	@Override
	public String toString() {
		return "Book [title=" + title + ", pub=" + pub + ", pubdate=" + pubdate + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	private Date pubdate;// 出版日期
}
