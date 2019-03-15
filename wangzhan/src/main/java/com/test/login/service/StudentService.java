package com.test.login.service;

import java.util.List;

import com.test.login.common.PageModel;
import com.test.login.domain.Login;
import com.test.login.domain.Student;

public interface StudentService {
	//动态保存学生信息
	void saveStudent(Student student);
	
	//删除学生信息
	void delStudent(Integer id);
	
	//修改学生信息
	void updateStudent(Student student);
	
	//动态分页查询
	List<Student> selectStudent(Student student,PageModel pageModel);
	
	//根据id查询所有 
	Login selectByidon(Integer id);
}
