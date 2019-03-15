package com.test.login.service;

import java.util.List;

import com.test.login.common.PageModel;
import com.test.login.domain.Bamboo;

public interface BambooService {

	//动态保存
	void saveBambooOn(Bamboo bamboo);
	
	//查询每个用户的数据
	List<Bamboo> seBambooOn(Integer login_id);
	
	//动态分页查询
	List<Bamboo> selectBambooOn(Bamboo bamboo ,PageModel pageModel);
	
	//删除竹子
	void  deleteBambooOn(Integer id);
	
	//动态修改竹子信息
    void updateBambooOn(Bamboo bamboo);
}
