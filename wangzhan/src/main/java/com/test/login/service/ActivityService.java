package com.test.login.service;

import com.test.login.domain.Activity;

public interface ActivityService {

/*	//动态保存活动信息
	void saveActivityOn(Activity activity);*/
	
	//抽奖次数
	void updateActivityOn(Integer times,Integer login_id);
	
	//抽奖次数查询
	Integer selectTimesOn();
}
