package com.test.login.service;

import java.util.List;

import com.test.login.common.PageModel;
import com.test.login.domain.Login;
import com.test.login.domain.Student;

public interface StudentService {
	//��̬����ѧ����Ϣ
	void saveStudent(Student student);
	
	//ɾ��ѧ����Ϣ
	void delStudent(Integer id);
	
	//�޸�ѧ����Ϣ
	void updateStudent(Student student);
	
	//��̬��ҳ��ѯ
	List<Student> selectStudent(Student student,PageModel pageModel);
	
	//����id��ѯ���� 
	Login selectByidon(Integer id);
}
