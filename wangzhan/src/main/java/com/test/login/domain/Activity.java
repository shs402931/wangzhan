package com.test.login.domain;

import java.util.Date;

public class Activity {

	private Integer id;
	private Integer times;
	private Date create_time;
	private String award_detail;
	private Integer login_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getAward_detail() {
		return award_detail;
	}
	public void setAward_detail(String award_detail) {
		this.award_detail = award_detail;
	}
	public Integer getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
}
