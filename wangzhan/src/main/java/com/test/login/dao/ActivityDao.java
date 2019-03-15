package com.test.login.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.test.login.domain.Activity;

public interface ActivityDao {
/*
	//动态保存活动信息
	@SelectProvider(type = ActivityDynaSqlProvider.class , method ="saveActivity" )
	void saveActivity(Activity activity);*/
	
	//根据id设置抽奖次数
	@Select(" update activity set times = #{times} where login_id = #{login_id}")
	void updateActivity(@Param("times")Integer times,@Param("login_id")Integer login_id);
	
	//抽奖次数查询
	@Select(" select times from activity " )
	Integer selectTimes();
}
