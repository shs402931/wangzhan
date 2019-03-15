package com.test.login.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.test.login.domain.Activity;

public interface ActivityDao {
/*
	//��̬������Ϣ
	@SelectProvider(type = ActivityDynaSqlProvider.class , method ="saveActivity" )
	void saveActivity(Activity activity);*/
	
	//����id���ó齱����
	@Select(" update activity set times = #{times} where login_id = #{login_id}")
	void updateActivity(@Param("times")Integer times,@Param("login_id")Integer login_id);
	
	//�齱������ѯ
	@Select(" select times from activity " )
	Integer selectTimes();
}
