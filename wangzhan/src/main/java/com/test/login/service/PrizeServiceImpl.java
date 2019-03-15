package com.test.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.login.common.Lottery;
import com.test.login.dao.PrizeDao;
import com.test.login.domain.Prize;

@Service("prizeService")
public class PrizeServiceImpl implements PrizeService {

	@Autowired
	private PrizeDao prizeDao;
	
	
	//设置奖品
	@Override
	public void savePrizeOn(Prize prize) {
		// TODO Auto-generated method stub
		prizeDao.savePrize(prize);
	}


	//查询奖品等级
	@Override
	public Prize selectPrizeOn(Integer prize_id) {
		// TODO Auto-generated method stub
		return prizeDao.selectPrize(prize_id);
	}


	//修改奖品
	@Override
	public void updatePrizeOn(Prize prize) {
		// TODO Auto-generated method stub
		prizeDao.updatePrize(prize);
	}

	//查询一等奖库存	
	@Override
	public Integer ATotalOn() {
		// TODO Auto-generated method stub
		return prizeDao.ATotal();
	}

	//查询二等奖库存
	@Override
	public Integer BTotalOn() {
		// TODO Auto-generated method stub
		return prizeDao.BTotal();
	}

	//查询三等奖库存
	@Override
	public Integer CTotalOn() {
		// TODO Auto-generated method stub
		return prizeDao.CTotal();
	}

	//根据ID查询奖品一等奖
	@Override
	public List<Prize> ALevelOn() {
		// TODO Auto-generated method stub
		return prizeDao.ALevel();
	}

	//根据ID查询奖品二等奖
	@Override
	public List<Prize> BLevelOn() {
		// TODO Auto-generated method stub
		return prizeDao.BLevel();
	}

	//根据ID查询奖品三等奖
	@Override
	public List<Prize> CLevelOn() {
		// TODO Auto-generated method stub
		return prizeDao.CLevel();
	}

	//设置修改一等奖库存
	@Override
	public void updateAStockOn(Integer stock,Integer prize_id) {
		// TODO Auto-generated method stub
		prizeDao.updateAStock(stock,prize_id);
	}


	//获取一等奖抽奖的概率
	@Override
	public Integer ARatioOn() {
		// TODO Auto-generated method stub
		return prizeDao.ARatio();
	}

	//获取二等奖抽奖的概率
	@Override
	public Integer BRatioOn() {
		// TODO Auto-generated method stub
		return prizeDao.BRatio() ;
	}

	//获取三等奖抽奖的概率
	@Override
	public Integer CRatioOn() {
		// TODO Auto-generated method stub
		return prizeDao.CRatio();
	}

	//根据奖品等级查询中奖的信息
	@Override
	public List<Prize> LevelOn(Integer prize_id) {
		// TODO Auto-generated method stub
		return prizeDao.Level(prize_id);
	}

}