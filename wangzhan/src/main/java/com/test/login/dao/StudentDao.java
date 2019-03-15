package com.test.login.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import com.test.login.domain.Student;

public interface StudentDao {
	//动态保存学生信息
	@SelectProvider(type=StudentDynaSqlProvider.class,method="saveStudent")
	void saveSt(Student student);
	
	//删除学生信息
	@Delete(" delete from student where id = #{id} ")
	void del(Integer id);
	
	//动态修改学生信息
	@SelectProvider(type=StudentDynaSqlProvider.class,method="updateStudent")
	void updateSt(Student student);
	
	//动态查询总数量
	@SelectProvider(type=StudentDynaSqlProvider.class,method="countStudent")
	Integer countSt(Map<String,Object> params);
	
	//动态分页查询
	@SelectProvider(type=StudentDynaSqlProvider.class,method="selectStudent")
	List<Student> selectStu(Map<String,Object> params);
	
	 //不分页查询所有
	@Select(" select * from student where login_id = #{id} ")
	List<Student> selectByidonin(Integer login_id);
	
	//关联动态分页查询
	@SelectProvider(type=StudentDynaSqlProvider.class,method="selcStudent")
	@Results({
		@Result(id=true,column="id",property="id")
	})
	List<Student> selectStuin(Map<String,Object> params);
}
