package com.test.login.service;

import com.test.login.domain.Activity;

public interface ActivityService {

/*	//��̬������Ϣ
	void saveActivityOn(Activity activity);*/
	
	//�齱����
	void updateActivityOn(Integer times,Integer login_id);
	
	//�齱������ѯ
	Integer selectTimesOn();
}
