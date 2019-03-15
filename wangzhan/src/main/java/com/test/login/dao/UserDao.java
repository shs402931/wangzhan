package com.test.login.dao;

import org.apache.ibatis.annotations.Select;

import com.test.login.domain.User;

public interface UserDao {

	@Select(" select * from tb_user where id = #{id} ")
	User selectById(Integer id);
}
