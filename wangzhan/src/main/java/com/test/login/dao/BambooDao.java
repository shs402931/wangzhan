package com.test.login.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.test.login.domain.Bamboo;

public interface BambooDao {

	//��̬����
	@SelectProvider(type=BambooDynaSqlProvider.class , method="saveBamboo")
	void saveBamboo(Bamboo bamboo);
	
	//��ѯÿ���û�������
	@Select(" select * from bamboo where login_id = #{login_id} ")
	List<Bamboo> seBamboo(@Param("login_id")Integer login_id);
	
	//��̬��ҳ��ѯ
	@SelectProvider(type=BambooDynaSqlProvider.class , method="selectBamboo")
	List<Bamboo> selectBamboo(Map<String , Object> params);
	
	//��̬ͳ��ÿ���û�������
	@SelectProvider(type=BambooDynaSqlProvider.class , method="count")
	Integer selectCount(Map<String , Object> params);
	
	//ɾ������
	@Delete(" delete from bamboo where id = #{id} ")
	void deleteBamboo(Integer id);
	
	//��̬�޸�������Ϣ
	@SelectProvider(type=BambooDynaSqlProvider.class , method="updateBamboo")
	void updateBamboo(Bamboo bamboo);
}
