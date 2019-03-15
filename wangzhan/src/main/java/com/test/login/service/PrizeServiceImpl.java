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
	
	
	//���ý�Ʒ
	@Override
	public void savePrizeOn(Prize prize) {
		// TODO Auto-generated method stub
		prizeDao.savePrize(prize);
	}


	//��ѯ��Ʒ�ȼ�
	@Override
	public Prize selectPrizeOn(Integer prize_id) {
		// TODO Auto-generated method stub
		return prizeDao.selectPrize(prize_id);
	}


	//�޸Ľ�Ʒ
	@Override
	public void updatePrizeOn(Prize prize) {
		// TODO Auto-generated method stub
		prizeDao.updatePrize(prize);
	}

	//��ѯһ�Ƚ����	
	@Override
	public Integer ATotalOn() {
		// TODO Auto-generated method stub
		return prizeDao.ATotal();
	}

	//��ѯ���Ƚ����
	@Override
	public Integer BTotalOn() {
		// TODO Auto-generated method stub
		return prizeDao.BTotal();
	}

	//��ѯ���Ƚ����
	@Override
	public Integer CTotalOn() {
		// TODO Auto-generated method stub
		return prizeDao.CTotal();
	}

	//����ID��ѯ��Ʒһ�Ƚ�
	@Override
	public List<Prize> ALevelOn() {
		// TODO Auto-generated method stub
		return prizeDao.ALevel();
	}

	//����ID��ѯ��Ʒ���Ƚ�
	@Override
	public List<Prize> BLevelOn() {
		// TODO Auto-generated method stub
		return prizeDao.BLevel();
	}

	//����ID��ѯ��Ʒ���Ƚ�
	@Override
	public List<Prize> CLevelOn() {
		// TODO Auto-generated method stub
		return prizeDao.CLevel();
	}

	//�����޸�һ�Ƚ����
	@Override
	public void updateAStockOn(Integer stock,Integer prize_id) {
		// TODO Auto-generated method stub
		prizeDao.updateAStock(stock,prize_id);
	}


	//��ȡһ�Ƚ��齱�ĸ���
	@Override
	public Integer ARatioOn() {
		// TODO Auto-generated method stub
		return prizeDao.ARatio();
	}

	//��ȡ���Ƚ��齱�ĸ���
	@Override
	public Integer BRatioOn() {
		// TODO Auto-generated method stub
		return prizeDao.BRatio() ;
	}

	//��ȡ���Ƚ��齱�ĸ���
	@Override
	public Integer CRatioOn() {
		// TODO Auto-generated method stub
		return prizeDao.CRatio();
	}

	//���ݽ�Ʒ�ȼ���ѯ�н�����Ϣ
	@Override
	public List<Prize> LevelOn(Integer prize_id) {
		// TODO Auto-generated method stub
		return prizeDao.Level(prize_id);
	}

}