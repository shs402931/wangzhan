package com.test.login.service;

import java.util.List;

import com.test.login.domain.Prize;

public interface PrizeService {

	//���ý�Ʒ
	void savePrizeOn(Prize prize);
	
	//��ѯ��Ʒ�ȼ�
	Prize selectPrizeOn(Integer prize_id);
	
	//�޸Ľ�Ʒ
	void updatePrizeOn(Prize prize);
	
	//��ѯһ�Ƚ����	
	Integer ATotalOn();
	
	//��ѯ���Ƚ����	
	Integer BTotalOn();
		
	//��ѯ���Ƚ����	
	Integer CTotalOn();
	
	//����ID��ѯ��Ʒһ�Ƚ�
	List<Prize> ALevelOn();
	//����ID��ѯ��Ʒ���Ƚ�
	List<Prize> BLevelOn();
	//����ID��ѯ��Ʒ���Ƚ�
	List<Prize> CLevelOn();
	
	//�����޸�һ�Ƚ����
	void  updateAStockOn(Integer stock,Integer prize_id);

	
	//��ȡһ�Ƚ��齱�ĸ���
	Integer ARatioOn();
	//��ȡ���Ƚ��齱�ĸ���
	Integer BRatioOn();
	//��ȡ���Ƚ��齱�ĸ���
	Integer CRatioOn();
	
	//���ݽ�Ʒ�ȼ���ѯ�н�����Ϣ
	List<Prize> LevelOn(Integer prize_id);
}
