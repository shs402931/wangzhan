package com.test.login.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.login.common.PageModel;
import com.test.login.dao.BambooDao;
import com.test.login.domain.Bamboo;

@Service("bambooService")
public class BambooServiceImpl implements BambooService {

	@Autowired
	private BambooDao bambooDao;
	
	//动态保存
	@Override
	public void saveBambooOn(Bamboo bamboo) {
		// TODO Auto-generated method stub
		bambooDao.saveBamboo(bamboo);
	}


	//查询每个用户的数据
	@Override
	public List<Bamboo> seBambooOn(Integer login_id) {
		// TODO Auto-generated method stub
		return bambooDao.seBamboo(login_id);
	}


	//分页查询
	@Override
	public List<Bamboo> selectBambooOn(Bamboo bamboo, PageModel pageModel) {
		// TODO Auto-generated method stub
		Map<String , Object> params  = new HashMap<>();
		params.put("bamboo",bamboo);
		int recordCount = bambooDao.selectCount(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount>0){
			params.put("pageModel", pageModel);
		}
		List<Bamboo> bamboos = bambooDao.selectBamboo(params);
		return bamboos;
	}


	//删除竹子
	@Override
	public void deleteBambooOn(Integer id) {
		// TODO Auto-generated method stub
		bambooDao.deleteBamboo(id);
	}


	@Override
	public void updateBambooOn(Bamboo bamboo) {
		// TODO Auto-generated method stub
		bambooDao.updateBamboo(bamboo);
	}
}
