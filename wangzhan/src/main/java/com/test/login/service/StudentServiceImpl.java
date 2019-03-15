package com.test.login.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.login.common.PageModel;
import com.test.login.dao.LoginDao;
import com.test.login.dao.StudentDao;
import com.test.login.domain.Login;
import com.test.login.domain.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private LoginDao loginDao;

	//动态保存学生信息
	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.saveSt(student);
	}

	//删除学生信息
	@Override
	public void delStudent(Integer id) {
		// TODO Auto-generated method stub
		studentDao.del(id);
	}

	//修改学生信息
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub 
		studentDao.updateSt(student);
	}

	//动态分页查询
	@Override
	public List<Student> selectStudent(Student student, PageModel pageModel) {
		// TODO Auto-generated method stub
		Map<String,Object> params = new HashMap<>();
		params.put("student", student);
		int recordcount = studentDao.countSt(params);
		pageModel.setRecordCount(recordcount);
		if(recordcount>0){
			params.put("pageModel",pageModel);
		}
		List<Student> students = studentDao.selectStu(params);
		return students;
	}

	@Override
	public Login selectByidon(Integer id) {
		// TODO Auto-generated method stub
		return loginDao.selectId(id);
	}
}
