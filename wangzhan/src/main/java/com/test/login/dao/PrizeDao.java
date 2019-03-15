package com.test.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.test.login.domain.Prize;

public interface PrizeDao {

	//设置奖品
	@SelectProvider(type=PrizeDynaSqlProvider.class , method = "savePrize")
	void savePrize(Prize prize);
	
	//查询奖品等级
	@Select(" select prize_id from prize_award where prize_id = #{prize_id} ")
	Prize selectPrize(@Param("prize_id")Integer prize_id );
	
	//修改奖品
	@SelectProvider(type=PrizeDynaSqlProvider.class , method = "updatePrize")
	void updatePrize(Prize prize);
	
	//查询一等奖库存
	@Select (" select stock from prize_award where prize_id = 1 ")
	Integer ATotal();
	//查询二等奖库存
	@Select (" select stock from prize_award where prize_id = 2 ")
	Integer BTotal();
	//查询三等奖库存
	@Select (" select stock from prize_award where prize_id = 3 ")
	Integer CTotal();
	
	//根据ID查询奖品一等奖
	@Select (" select prize_id,prize_name from prize_award where prize_id = 1 ")
	List<Prize> ALevel();
	//根据ID查询奖品二等奖
	@Select (" select prize_id,prize_name from prize_award where prize_id = 2 ")
	List<Prize> BLevel();
	//根据ID查询奖品三等奖
	@Select (" select prize_id,prize_name from prize_award where prize_id = 3 ")
	List<Prize> CLevel();
	
	//设置修改一等奖库存
    @Select(" update prize_award set stock = #{stock} where prize_id = #{prize_id} ")
    void  updateAStock(@Param("stock")Integer stock,@Param("prize_id")Integer prize_id);
    
    //获取一等奖抽奖的概率
    @Select(" select ratio from prize_award where prize_id = 1  ")
    Integer ARatio();
    //获取二等奖抽奖的概率
    @Select(" select ratio from prize_award where prize_id = 2  ")
    Integer BRatio();
    //获取三等奖抽奖的概率
    @Select(" select ratio from prize_award where prize_id = 3  ")
    Integer CRatio();
    
    //根据奖品等级查询中奖的信息
    @Select (" select prize_id,prize_name from prize_award where prize_id = #{prize_id} ")
	List<Prize> Level(Integer prize_id);
}
