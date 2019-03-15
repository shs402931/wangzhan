package com.test.login.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


import com.test.login.domain.Login;

public interface LoginDao {
	//动态注册用户
	@SelectProvider(type=LoginDynaSqlProvider.class,method="loginRegister")
	void register(Login login);
	
	//根据用户名和密码登录
	@Select("select id from login where name=#{name} and pass=#{pass} ")
	Login select(@Param("name")String name,@Param("pass")String pass);
	
	//根据name查询重复的用户名
	@Select(" select name from login where name= #{name} ")
	Login selectin(@Param("name")String name); 
	
	//根据id查询所有 
	@Select("select * from login where id = #{id} ")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="pass",property="pass"),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="phone",property="phone"),
		@Result(column="id",property="students",
		many=@Many(select="com.test.login.dao.StudentDao.selectByidonin"))
	})
	Login selectId(Integer id);
	
}
