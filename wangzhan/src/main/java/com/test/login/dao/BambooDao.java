package com.test.login.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.test.login.domain.Bamboo;

public interface BambooDao {

	//动态保存
	@SelectProvider(type=BambooDynaSqlProvider.class , method="saveBamboo")
	void saveBamboo(Bamboo bamboo);
	
	//查询每个用户的数据
	@Select(" select * from bamboo where login_id = #{login_id} ")
	List<Bamboo> seBamboo(@Param("login_id")Integer login_id);
	
	//动态分页查询
	@SelectProvider(type=BambooDynaSqlProvider.class , method="selectBamboo")
	List<Bamboo> selectBamboo(Map<String , Object> params);
	
	//动态统计每个用户总数量
	@SelectProvider(type=BambooDynaSqlProvider.class , method="count")
	Integer selectCount(Map<String , Object> params);
	
	//删除竹子
	@Delete(" delete from bamboo where id = #{id} ")
	void deleteBamboo(Integer id);
	
	//动态修改竹子信息
	@SelectProvider(type=BambooDynaSqlProvider.class , method="updateBamboo")
	void updateBamboo(Bamboo bamboo);
}
