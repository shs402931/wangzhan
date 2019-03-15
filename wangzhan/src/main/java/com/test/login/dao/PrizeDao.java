package com.test.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.test.login.domain.Prize;

public interface PrizeDao {

	//���ý�Ʒ
	@SelectProvider(type=PrizeDynaSqlProvider.class , method = "savePrize")
	void savePrize(Prize prize);
	
	//��ѯ��Ʒ�ȼ�
	@Select(" select prize_id from prize_award where prize_id = #{prize_id} ")
	Prize selectPrize(@Param("prize_id")Integer prize_id );
	
	//�޸Ľ�Ʒ
	@SelectProvider(type=PrizeDynaSqlProvider.class , method = "updatePrize")
	void updatePrize(Prize prize);
	
	//��ѯһ�Ƚ����
	@Select (" select stock from prize_award where prize_id = 1 ")
	Integer ATotal();
	//��ѯ���Ƚ����
	@Select (" select stock from prize_award where prize_id = 2 ")
	Integer BTotal();
	//��ѯ���Ƚ����
	@Select (" select stock from prize_award where prize_id = 3 ")
	Integer CTotal();
	
	//����ID��ѯ��Ʒһ�Ƚ�
	@Select (" select prize_id,prize_name from prize_award where prize_id = 1 ")
	List<Prize> ALevel();
	//����ID��ѯ��Ʒ���Ƚ�
	@Select (" select prize_id,prize_name from prize_award where prize_id = 2 ")
	List<Prize> BLevel();
	//����ID��ѯ��Ʒ���Ƚ�
	@Select (" select prize_id,prize_name from prize_award where prize_id = 3 ")
	List<Prize> CLevel();
	
	//�����޸�һ�Ƚ����
    @Select(" update prize_award set stock = #{stock} where prize_id = #{prize_id} ")
    void  updateAStock(@Param("stock")Integer stock,@Param("prize_id")Integer prize_id);
    
    //��ȡһ�Ƚ��齱�ĸ���
    @Select(" select ratio from prize_award where prize_id = 1  ")
    Integer ARatio();
    //��ȡ���Ƚ��齱�ĸ���
    @Select(" select ratio from prize_award where prize_id = 2  ")
    Integer BRatio();
    //��ȡ���Ƚ��齱�ĸ���
    @Select(" select ratio from prize_award where prize_id = 3  ")
    Integer CRatio();
    
    //���ݽ�Ʒ�ȼ���ѯ�н�����Ϣ
    @Select (" select prize_id,prize_name from prize_award where prize_id = #{prize_id} ")
	List<Prize> Level(Integer prize_id);
}
