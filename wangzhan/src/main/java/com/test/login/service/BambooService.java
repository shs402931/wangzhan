package com.test.login.service;

import java.util.List;

import com.test.login.common.PageModel;
import com.test.login.domain.Bamboo;

public interface BambooService {

	//��̬����
	void saveBambooOn(Bamboo bamboo);
	
	//��ѯÿ���û�������
	List<Bamboo> seBambooOn(Integer login_id);
	
	//��̬��ҳ��ѯ
	List<Bamboo> selectBambooOn(Bamboo bamboo ,PageModel pageModel);
	
	//ɾ������
	void  deleteBambooOn(Integer id);
	
	//��̬�޸�������Ϣ
    void updateBambooOn(Bamboo bamboo);
}
