package com.test.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.login.common.Msg;
import com.test.login.common.PageModel;
import com.test.login.domain.Bamboo;
import com.test.login.service.BambooService;

@Controller
public class BambooController {

	@Autowired
	@Qualifier("bambooService")
	private BambooService bambooService;
	
	//动态保存
	@RequestMapping("/saveBamboo")
	@ResponseBody
	public Msg saveBamboo(@ModelAttribute Bamboo bamboo){
		bambooService.saveBambooOn(bamboo);
		return Msg.bamboo() ;
	}
	
	//查询每个用户的数据
	@RequestMapping("/selectBamboo")
	@ResponseBody
	public Msg selectBamboo(@ModelAttribute Bamboo bamboo){
		List<Bamboo> bamboos = bambooService.seBambooOn(bamboo.getLogin_id());
		return Msg.ssbamboo().add("bamboos", bamboos);
	}
	
	//动态分页查询
	@RequestMapping("/seBamboo")
	@ResponseBody
	public Msg seBamboo(PageModel pageModel,@RequestParam("pageIndex")Integer pageIndex,@ModelAttribute Bamboo bamboo){
		if(pageIndex!=null){
			pageModel.setPageIndex(pageIndex);
		}
		List<Bamboo> bamboos = bambooService.selectBambooOn(bamboo, pageModel);
		return Msg.ssbamboo().add("bamboos", bamboos);
	}
	
	//删除竹子
	@RequestMapping("/deleteBamboo")
	@ResponseBody
	public Msg deleteBamboo(@RequestParam("id")String ids){
		String[] idArray = ids.split(",");
		for(String id : idArray){
			bambooService.deleteBambooOn(Integer.parseInt(id));
		}
		return Msg.delbamboo();
	}
	
	//修改竹子信息
	@RequestMapping("/updateBamboo")
	@ResponseBody
	public Msg updateBamboo(@ModelAttribute Bamboo bamboo){
		bambooService.updateBambooOn(bamboo);
		return Msg.upbamboo();
	}
}
