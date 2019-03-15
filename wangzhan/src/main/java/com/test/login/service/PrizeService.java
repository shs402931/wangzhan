package com.test.login.service;

import java.util.List;

import com.test.login.domain.Prize;

public interface PrizeService {

	//设置奖品
	void savePrizeOn(Prize prize);
	
	//查询奖品等级
	Prize selectPrizeOn(Integer prize_id);
	
	//修改奖品
	void updatePrizeOn(Prize prize);
	
	//查询一等奖库存	
	Integer ATotalOn();
	
	//查询二等奖库存	
	Integer BTotalOn();
		
	//查询三等奖库存	
	Integer CTotalOn();
	
	//根据ID查询奖品一等奖
	List<Prize> ALevelOn();
	//根据ID查询奖品二等奖
	List<Prize> BLevelOn();
	//根据ID查询奖品三等奖
	List<Prize> CLevelOn();
	
	//设置修改一等奖库存
	void  updateAStockOn(Integer stock,Integer prize_id);

	
	//获取一等奖抽奖的概率
	Integer ARatioOn();
	//获取二等奖抽奖的概率
	Integer BRatioOn();
	//获取三等奖抽奖的概率
	Integer CRatioOn();
	
	//根据奖品等级查询中奖的信息
	List<Prize> LevelOn(Integer prize_id);
}
