package com.test.login.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.login.common.Lottery;
import com.test.login.common.Msg;
import com.test.login.domain.Activity;
import com.test.login.domain.Prize;
import com.test.login.service.ActivityService;
import com.test.login.service.PrizeService;

@Controller
public class PrizeController {

	@Autowired
	@Qualifier("prizeService")
	private PrizeService  prizeService;
	
	@Autowired
	@Qualifier("activityService")
	private ActivityService activityService;
	
	//���ý�Ʒ
	@RequestMapping("/savePrize")
	@ResponseBody
	public Msg savePrize(@ModelAttribute Prize prize){
		Prize prizes  = prizeService.selectPrizeOn(prize.getPrize_id());
		if(prizes !=null){
			return Msg.prizeId();
		}else{
			prizeService.savePrizeOn(prize);
			return Msg.prizeAll();
		}
	}
	
	//�޸Ľ�Ʒ
	@RequestMapping("/updatePrize")
	@ResponseBody
	public Msg updatePrize(@ModelAttribute Prize prize){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String update_time = df.format(date);
		prize.setUpdate_time(update_time);
		prizeService.updatePrizeOn(prize);
		return Msg.prizeupdate();
	}
	
	//�齱
	@RequestMapping("/awardPrize")
	@ResponseBody
	public Msg awardP(@RequestParam("login_id")Integer login_id){
		Lottery lottery = new Lottery();
		//��ѯ����
		int times = activityService.selectTimesOn();
		//һ�Ƚ����
		int atotal = prizeService.ATotalOn();
		lottery.setAtotal(atotal);
		//���Ƚ����
		int btotal = prizeService.BTotalOn();
		lottery.setBtotal(btotal);
		//���Ƚ����
		int ctotal = prizeService.CTotalOn();
		lottery.setCtotal(ctotal);
		//һ�Ƚ�����
		int aratio = prizeService.ARatioOn();
		lottery.setAratio(aratio);
		//���Ƚ�����
		int bratio = prizeService.BRatioOn();
		lottery.setBratio(bratio);
		//���Ƚ�����
		int cratio = prizeService.CRatioOn();
		lottery.setCratio(cratio);
		int prize_id = lottery.prizeLevel();
		List<Prize> prizes = prizeService.LevelOn(prize_id);
		if(times>0){
			//��һ�Ƚ����
			if(prize_id == 1){
				int stockA = atotal-1;
				prizeService.updateAStockOn(stockA,prize_id);
				//����
				int time = times -1;
				activityService.updateActivityOn(time, login_id);
			}
			//�����Ƚ����
			if(prize_id == 2){
				int stockB = btotal-1;
				prizeService.updateAStockOn(stockB,prize_id);
				//����
				int time = times -1;
				activityService.updateActivityOn(time, login_id);
			}
			//�����Ƚ����
			if(prize_id == 3){
				int stockC = ctotal-1;
				prizeService.updateAStockOn(stockC,prize_id);
				//����
				int time = times -1;
				activityService.updateActivityOn(time, login_id);
			}
		}else{
			return Msg.time();
		}
	//û�п��
		if(prize_id ==0){
			return Msg.prizess();
		}
		return Msg.level().add("prizes", prizes);
	}
}
