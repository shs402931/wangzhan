package com.test.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.login.dao.ActivityDao;
import com.test.login.domain.Activity;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

/*	//动态保存活动信息
	@Override
	public void saveActivityOn(Activity activity) {
		// TODO Auto-generated method stub
		activityDao.saveActivity(activity);
	}*/

	//抽奖次数
	@Override
	public void updateActivityOn(Integer times, Integer login_id) {
		// TODO Auto-generated method stub
		activityDao.updateActivity(times, login_id);
	}

	@Override
	public Integer selectTimesOn() {
		// TODO Auto-generated method stub
		return activityDao.selectTimes();
	}
}
