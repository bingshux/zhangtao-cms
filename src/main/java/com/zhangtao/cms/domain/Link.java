package com.zhangtao.cms.domain;

public class Link {
	private Integer id;
	private String text;
	private String url;
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
	public Link(Integer id, String text, String url) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
	}
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Link [id=" + id + ", text=" + text + ", url=" + url + "]";
	}
	
}
