package com.test.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.login.common.Msg;
import com.test.login.common.PageModel;
import com.test.login.domain.Login;
import com.test.login.domain.Student;
import com.test.login.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	@Qualifier("studentService")
	private StudentService studentService;
	
	//����ѧ����Ϣ
	@RequestMapping("/login/student")
	@ResponseBody
	public Msg student(@ModelAttribute Student student,Integer login_id){
		//�ڲ�ִ�а�id�浽�����ı���
        this.genericAssociation(login_id, student);
		studentService.saveStudent(student);
		return Msg.successStudent();
	}	
	//����login_id��student��ʽ����ӳ���ϵ������ֱ�ӽ��ղ�������Ҫ����login����
	public void genericAssociation(Integer login_id ,Student student){
		if(login_id !=null){
			Login login =new Login();
			login.setId(login_id);
			student.setLogin(login);
		}
	}
	
	//ɾ��ѧ����Ϣ
	@RequestMapping("/login/delStudent")
	@ResponseBody 
	public Msg delStudent(@ModelAttribute Student student,String ids){
		String[] idArray = ids.split(",");
		for(String id : idArray ){
			studentService.delStudent(Integer.parseInt(id));
		}
		return Msg.delStudent();
	}
	
	//�޸�ѧ����Ϣ
	@RequestMapping("/login/updateStudent")
	@ResponseBody  
	public Msg updateStudent(@ModelAttribute Student student,Integer login_id){
		this.genericAssociation(login_id, student);
		studentService.updateStudent(student);
		return Msg.updateStudent();
	}
	
	//��ҳ��ѯ
	@RequestMapping("/login/selectStudent")
	@ResponseBody  
	public Msg selectStudent(Student student,PageModel pageModel,@RequestParam("pageIndex")Integer pageIndex,HttpServletRequest request){
		Login user = (Login)request.getSession().getAttribute("user");
		if(user !=null){
			if(pageIndex!=null){
				 pageModel.setPageIndex(pageIndex);
			}
			List<Student> students = studentService.selectStudent(student, pageModel);
			return Msg.selectDocument().add("students", students);
		}else{
			return Msg.failSign();
		}
		
	}
}
