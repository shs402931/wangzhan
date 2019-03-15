package com.test.login.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


import com.test.login.domain.Login;

public interface LoginDao {
	//��̬ע���û�
	@SelectProvider(type=LoginDynaSqlProvider.class,method="loginRegister")
	void register(Login login);
	
	//�����û����������¼
	@Select("select id from login where name=#{name} and pass=#{pass} ")
	Login select(@Param("name")String name,@Param("pass")String pass);
	
	//����name��ѯ�ظ����û���
	@Select(" select name from login where name= #{name} ")
	Login selectin(@Param("name")String name); 
	
	//����id��ѯ���� 
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
