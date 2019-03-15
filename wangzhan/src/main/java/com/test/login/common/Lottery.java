package com.test.login.common;

public class Lottery {
	//一等奖库存
    private int atotal ;
	//二等奖库存
    private int btotal;
	//二等奖库存
    private int ctotal ;
	//一等奖概率
    private int aratio ;
	//二等奖概率
    private int bratio;
	//三等奖概率
    private int cratio;
	
	public int getAtotal() {
		return atotal;
	}


	public void setAtotal(int atotal) {
		this.atotal = atotal;
	}


	public int getBtotal() {
		return btotal;
	}


	public void setBtotal(int btotal) {
		this.btotal = btotal;
	}


	public int getCtotal() {
		return ctotal;
	}


	public void setCtotal(int ctotal) {
		this.ctotal = ctotal;
	}


	public int getAratio() {
		return aratio;
	}


	public void setAratio(int aratio) {
		this.aratio = aratio;
	}


	public int getBratio() {
		return bratio;
	}


	public void setBratio(int bratio) {
		this.bratio = bratio;
	}


	public int getCratio() {
		return cratio;	
	}

	public void setCratio(int cratio) {
		this.cratio = cratio;
	}


    //抽奖逻辑
	public int prizeLevel(){
		//总概率
		int ratio = this.getAratio()+this.getBratio()+this.getCratio();
		//总库存
		int atotal = this.getAtotal()+this.getBtotal()+this.getCtotal();
		 //奖品等级
	  	int prize_id =0;
		//1-10中奖一等奖，11-30中奖二等奖，31-100中奖三等奖
		int random = (int)(Math.random()*ratio)+1;
	    if(atotal>0){	
	    	//三个奖品都有库存
	    	if(this.getAtotal() >0 && this.getBtotal()>0 && this.getCtotal()>0){
	    		//中一等奖
	    		if(random >0 && random<this.getAratio()){
	    			int prize =1;
	    			prize_id = prize;
	    		}
	    		//中二等奖
	    		if(random>this.getAratio() && random<=this.getBratio() ){
	    			int prize =2;
	    			prize_id = prize;
	    		}
	    		//中三等奖
	    		if(random>this.getBratio() && random<=ratio ){
	    			int prize =3;
	    			prize_id = prize;
	    		}
	    	}
	    	//一等奖奖品没有库存
	    	if(this.getAtotal() ==0 && this.getBtotal()>0 && this.getCtotal()>0){
	    		//中二等奖
	    		if(random>this.getAratio() && random<=this.getBratio() ){
	    			int prize =2;
	    			prize_id = prize;
	    			return prize_id;
	    		}
	    		//中三等奖
	    		if(random>this.getBratio() && random<=ratio || random >0 && random<this.getAratio()){
	    			int prize =3;
	    			prize_id = prize;
	    		}
	    	}
	    	//二等奖奖品没有库存
	    	if(this.getAtotal() >0 && this.getBtotal()==0 && this.getCtotal()>0){
	    		//中一等奖
	    		if(random >0 && random<this.getAratio()){
	    			int prize =1;
	    			prize_id = prize;
	    		}
	    		//中三等奖
	    		if(random>this.getAratio() && random<=ratio ){
	    			int prize =3;
	    			prize_id = prize;
	    		}
	    	}
	    	//三等奖奖品没有库存
	    	if(this.getAtotal() >0 && this.getBtotal()>0 && this.getCtotal()==0){
	    		//中一等奖
	    		if(random >0 && random<this.getAratio()){
	    			int prize =1;
	    			prize_id = prize;
	    		}
	    		//中二等奖
	    		if(random>this.getAratio() && random<=ratio ){
	    			int prize =2;
	    			prize_id = prize;
	    		}
	    	}
	    	//一等奖和二等奖没有库存
	    	if(this.getAtotal() ==0 && this.getBtotal()==0 && this.getCtotal()>0){
	    		//中三等奖
	    		if(random>0 && random<=ratio ){
	    			int prize =3;
	    			prize_id = prize;
	    		}
	    	}
	    	//一等奖和三等奖没有库存
	    	if(this.getAtotal() ==0 && this.getBtotal()>0 && this.getCtotal()==0){
	    		//中二等奖
	    		if(random>0 && random<=ratio ){
	    			int prize =2;
	    			prize_id = prize;
	    		}
	    	}
	    	//二等奖和三等奖没有库存
	    	if(this.getAtotal() >0 && this.getBtotal()==0 && this.getCtotal()==0){
	    		//中一等奖
	    		if(random >0 && random<=ratio){
	    			int prize =1;
	    			prize_id = prize;
	    		}
	    	}
	    }		
		return prize_id;	
	}
}
