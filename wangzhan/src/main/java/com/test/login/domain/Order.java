package com.test.login.domain;

import java.util.List;

public class Order {

	private Integer id;
	private String code;
	private Double total;
	//�������û��Ƕ��һ��ϵ
	private User user;
	//��������Ʒ�Ƕ�Զ��ϵ
	private List<Article> articles;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
