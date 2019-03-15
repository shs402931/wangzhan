package com.test.login.dao;


import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.test.login.domain.Bamboo;

public class BambooDynaSqlProvider {

	//��̬����
	public String saveBamboo(Bamboo bamboo){
		String sql = new SQL(){
			{
				INSERT_INTO("bamboo");
				if(bamboo.getName() !=null && !bamboo.getName().equals("")){
					VALUES(" name "," #{name} ");
				}
				if(bamboo.getLogin_id() !=null && !bamboo.getLogin_id().equals("")){
					VALUES(" login_id " , " #{login_id} ");
				}
				if(bamboo.getAddress() !=null && !bamboo.getAddress().equals("")){
					VALUES(" address "," #{address} ");
				}
			}
		}.toString();
		return sql;
	}
	
	//��̬ͳ��ÿ���û�������
	public String count(Map<String , Object> params){
		String sql  = new SQL(){
			{
				SELECT("count(*)");
				FROM("bamboo");
				if(params.get("bamboo")!=null){
					Bamboo bamboo = (Bamboo)params.get("bamboo");
					if(bamboo.getLogin_id()!=null && !bamboo.getLogin_id().equals("")){
						WHERE(" login_id = #{bamboo.login_id} ");
					}
				}		
			}
		}.toString();
		return sql;
	}
	
	//��̬��ҳ��ѯ
	public String selectBamboo(Map<String , Object> params){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM("bamboo");
				if(params.get("bamboo")!=null){
					Bamboo bamboo =(Bamboo)params.get("bamboo");
					if(bamboo.getLogin_id()!=null && !bamboo.getLogin_id().equals("")){
						WHERE(" login_id = #{bamboo.login_id} ");
					}
				}				
			}
		}.toString();
		if(params.get("pageModel")!=null){
			sql += " LIMIT #{pageModel.firstLimitParam} ,#{pageModel.pageSize} " ;
		}
		return sql;
	}
	
	//��̬�޸�������Ϣ
	public String updateBamboo(Bamboo bamboo){
		String sql = new SQL(){
			{
				UPDATE("bamboo");
				if(bamboo.getName()!=null && !bamboo.equals("")){
					SET(" name = #{name} ");
				}
				if(bamboo.getAddress()!=null && !bamboo.equals("")){
					SET(" address = #{address} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
		return sql;
	}
}
