package com.test.login.dao;

import org.apache.ibatis.jdbc.SQL;

import com.test.login.domain.Prize;

public class PrizeDynaSqlProvider {

	//设置奖品
	public String savePrize(Prize prize){
		String sql = new SQL(){
			{
				INSERT_INTO("prize_award");
				if(prize.getPrize_id()!=null && !prize.getPrize_id().equals("")){
					VALUES(" prize_id " , " #{prize_id} ");
				}
				if(prize.getPrize_name() !=null && !prize.equals("")){
					VALUES(" prize_name " ," #{prize_name}");
				}
				if(prize.getCreate_time() !=null && !prize.getCreate_time().equals("")){
					VALUES(" create_time " ," #{create_time}");
				}
				if(prize.getUpdate_time() !=null && !prize.getUpdate_time().equals("")){
					VALUES(" update_time "," #{update_time}");
				}
				if(prize.getStock() !=null && !prize.getStock().equals("")){
					VALUES(" stock "," #{stock}");
				}
				if(prize.getRatio() !=null && !prize.getRatio().equals("") ){
					VALUES(" ratio "," #{ratio}");
				}
			}
		}.toString();
		return sql;
	}
	
	//修改奖品
	public String updatePrize(Prize prize){
		String sql = new SQL(){
			{
				UPDATE("prize_award");
				if(prize.getPrize_name() !=null && !prize.equals("")){
					SET(" prize_name = #{prize_name}");
				}
				if(prize.getUpdate_time() !=null && !prize.getUpdate_time().equals("")){
					SET(" update_time = #{update_time}");
				}
				if(prize.getStock() !=null && !prize.getStock().equals("")){
					SET(" stock = #{stock}");
				}
				if(prize.getRatio() !=null && !prize.getRatio().equals("") ){
					SET(" ratio = #{ratio}");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
		return sql;
	}
}
