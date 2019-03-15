package com.test.login.common;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	//code状态码 200成功，100失败
	private int state;
	//msg信息返回
	private String msg;
	//验证码
	private String code;
	//浏览器返回的信息
	private Map<String,Object> information = new HashMap<>();
	
	//注册信息
	public static Msg successRegister(){
		Msg result =new Msg();
		result.setState(200);
		result.setMsg("注册成功");
		return result;
	}
	public static Msg failRegister(){
		Msg result =new Msg();
		result.setState(100);
		result.setMsg("用户名或密码不能为空");
		return result;
	}
	public static Msg failname(){
		Msg result =new Msg();
		result.setState(100);
		result.setMsg("用户名已存在");
		return result;
	}
	
	//处理字段的json返回
	public Msg add(String key,Object value){
		this.getInformation().put(key, value);
		return this;
	}
	
	//竹子
	public static Msg bamboo(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("新增竹子成功");
		return result;
	}
	public static Msg ssbamboo(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("查询竹子成功");
		return result;
	}
	public static Msg delbamboo(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("删除竹子成功");
		return result;
	}
	public static Msg upbamboo(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("修改竹子成功");
		return result;
	}
	
	//添加奖品成功
	public static Msg prizeAll(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("添加奖品成功");
		return result;
	}
	public static Msg prizeId(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("该奖品等级已存在，不能添加");
		return result;
	}
	public static Msg prizeupdate(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("修改奖品成功");
		return result;
	}
	public static Msg prizess(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("奖品已发放完毕");
		return result;
	}
	public static Msg level(){
		Msg result = new Msg();
		result.setMsg("恭喜你，中奖了");
		return result;
	}
	public static Msg time(){
		Msg result = new Msg();
		result.setMsg("没有抽奖次数");
		return result;
	}

	
	//分页查询
	public static Msg page(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("分页查询成功");
		return result;
	}
	
	//首页
	public static Msg successPage(){
		Msg result = new Msg();
		Random  code = new Random();
		String codes = code.getCode();
		result.setState(200);
		result.setCode(codes);
		return result;
	}
	
	//登录信息
	public static Msg successLogin(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("登录成功");
		return result;
	}
	public static Msg failLogin(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("账号或密码错误");
		return result;
	}
	
	//新增学生信息
	public static Msg successStudent(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("新增学生信息成功");
		return result;
	}
	//删除学生信息
	public static Msg delStudent(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("删除学生信息成功");
		return result;
	}
	
	//删除学生信息
	public static Msg delStudent1(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("删除学生信息成功");
		return result;
	}
	
	//修改学生信息
	public static Msg updateStudent(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("修改学生信息成功");
		return result;
	}
	
	//未登陆返回先登录
	public static Msg failSign(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("未登陆，请先登录账号");
		return result;
	}
	
	//上传成功
	public static Msg down(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("上传成功");
		return result;
	}
	
	//查询成功
	public static Msg selectDocument(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("查询成功");
		return result;
	}
	
	//下载成功
	public static Msg downloadDocument(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("下载成功");
		return result;
	}
	
	//查询成功
	public static Msg company(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("查询成功");
		return result;
	}
	
	//查询成功
	public static Msg person(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("查询成功");
		return result;
	}
	
	//查询成功
	public static Msg teacher(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("查询成功");
		return result;
	}
	
	//查询成功
	public static Msg order(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("查询成功");
		return result;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Map<String, Object> getInformation() {
		return information;
	}
	public void setInformation(Map<String, Object> information) {
		this.information = information;
	}
}
