package com.test.login.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.login.common.Msg;
import com.test.login.domain.Login;
import com.test.login.service.LoginService;

@Controller
public class LoginController {
	@InitBinder
    public void initBinder(WebDataBinder binder){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 严格限制日期转换 ,true:允许输入空值，false:不能为空值 
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;
	
	//注册
	@RequestMapping("/register")
	@ResponseBody
	public Msg register(@ModelAttribute Login login){
	     String name = login.getName();
	     Login logins = loginService.selectinon(name);
		if(login.getName()!=null && !login.getName().equals("") && login.getPass()!=null && !login.getPass().equals("")){
			if(logins ==null){
				loginService.registeron(login);	
				return Msg.successRegister();
			}
			return Msg.failname();
		}else{
			return Msg.failRegister();
		}
	}
	
	//登录 
	@RequestMapping("/login")
	@ResponseBody
	public Msg login(@RequestParam("name")String name,@RequestParam("pass")String pass,HttpSession session ){
		Login logins = loginService.selecton(name, pass);
		if(logins!=null){
			session.setAttribute("user", logins);
			return Msg.successLogin().add("logins", logins);
		}else{
			return Msg.failLogin();
		}
		
	}
	
	//首页
	@RequestMapping("/page")
	@ResponseBody
	public Msg page(){
		return Msg.successPage();
	}
}
