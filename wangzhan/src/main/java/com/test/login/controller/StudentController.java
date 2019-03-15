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
	
	//保存学生信息
	@RequestMapping("/login/student")
	@ResponseBody
	public Msg student(@ModelAttribute Student student,Integer login_id){
		//内部执行把id存到关联的表上
        this.genericAssociation(login_id, student);
		studentService.saveStudent(student);
		return Msg.successStudent();
	}	
	//由于login_id在student中式关联映射关系，不能直接接收参数，需要创建login对象
	public void genericAssociation(Integer login_id ,Student student){
		if(login_id !=null){
			Login login =new Login();
			login.setId(login_id);
			student.setLogin(login);
		}
	}
	
	//删除学生信息
	@RequestMapping("/login/delStudent")
	@ResponseBody 
	public Msg delStudent(@ModelAttribute Student student,String ids){
		String[] idArray = ids.split(",");
		for(String id : idArray ){
			studentService.delStudent(Integer.parseInt(id));
		}
		return Msg.delStudent();
	}
	
	//修改学生信息
	@RequestMapping("/login/updateStudent")
	@ResponseBody  
	public Msg updateStudent(@ModelAttribute Student student,Integer login_id){
		this.genericAssociation(login_id, student);
		studentService.updateStudent(student);
		return Msg.updateStudent();
	}
	
	//分页查询
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
