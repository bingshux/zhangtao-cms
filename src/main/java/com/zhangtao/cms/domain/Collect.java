package com.zhangtao.cms.domain;

import java.io.Serializable;
import java.util.Date;

public class Collect implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String text;
	private String url;
	private User user;
	private Date created;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Collect(Integer id, String text, String url, User user, Date created) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.user = user;
		this.created = created;
	}
	
	public Collect() {
		super();
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", text=" + text + ", url=" + url + ", user=" + user + ", created=" + created
				+ "]";
	}
	
	
}
