package com.test.login.dao;

import org.apache.ibatis.jdbc.SQL;

import com.test.login.domain.Activity;

/*public class ActivityDynaSqlProvider {

	//动态保存活动信息
	public String saveActivity(Activity activity){
		String sql = new SQL(){
			{
				INSERT_INTO("activity");
				if(activity.getAward_detail()!=null && !activity.getAward_detail().equals("")){
					VALUES(" award_detail "," #{award_detail} ");
				}
				if(activity.getLogin_id() !=null && !activity.getLogin_id().equals("")){
					VALUES(" login_id "," #{login_id} ");
				}
			}
		}.toString();
		return sql;
	}
}*/
