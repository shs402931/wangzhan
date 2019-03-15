package com.test.login.common;

public class Lottery {
	//һ�Ƚ����
    private int atotal ;
	//���Ƚ����
    private int btotal;
	//���Ƚ����
    private int ctotal ;
	//һ�Ƚ�����
    private int aratio ;
	//���Ƚ�����
    private int bratio;
	//���Ƚ�����
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


    //�齱�߼�
	public int prizeLevel(){
		//�ܸ���
		int ratio = this.getAratio()+this.getBratio()+this.getCratio();
		//�ܿ��
		int atotal = this.getAtotal()+this.getBtotal()+this.getCtotal();
		 //��Ʒ�ȼ�
	  	int prize_id =0;
		//1-10�н�һ�Ƚ���11-30�н����Ƚ���31-100�н����Ƚ�
		int random = (int)(Math.random()*ratio)+1;
	    if(atotal>0){	
	    	//������Ʒ���п��
	    	if(this.getAtotal() >0 && this.getBtotal()>0 && this.getCtotal()>0){
	    		//��һ�Ƚ�
	    		if(random >0 && random<this.getAratio()){
	    			int prize =1;
	    			prize_id = prize;
	    		}
	    		//�ж��Ƚ�
	    		if(random>this.getAratio() && random<=this.getBratio() ){
	    			int prize =2;
	    			prize_id = prize;
	    		}
	    		//�����Ƚ�
	    		if(random>this.getBratio() && random<=ratio ){
	    			int prize =3;
	    			prize_id = prize;
	    		}
	    	}
	    	//һ�Ƚ���Ʒû�п��
	    	if(this.getAtotal() ==0 && this.getBtotal()>0 && this.getCtotal()>0){
	    		//�ж��Ƚ�
	    		if(random>this.getAratio() && random<=this.getBratio() ){
	    			int prize =2;
	    			prize_id = prize;
	    			return prize_id;
	    		}
	    		//�����Ƚ�
	    		if(random>this.getBratio() && random<=ratio || random >0 && random<this.getAratio()){
	    			int prize =3;
	    			prize_id = prize;
	    		}
	    	}
	    	//���Ƚ���Ʒû�п��
	    	if(this.getAtotal() >0 && this.getBtotal()==0 && this.getCtotal()>0){
	    		//��һ�Ƚ�
	    		if(random >0 && random<this.getAratio()){
	    			int prize =1;
	    			prize_id = prize;
	    		}
	    		//�����Ƚ�
	    		if(random>this.getAratio() && random<=ratio ){
	    			int prize =3;
	    			prize_id = prize;
	    		}
	    	}
	    	//���Ƚ���Ʒû�п��
	    	if(this.getAtotal() >0 && this.getBtotal()>0 && this.getCtotal()==0){
	    		//��һ�Ƚ�
	    		if(random >0 && random<this.getAratio()){
	    			int prize =1;
	    			prize_id = prize;
	    		}
	    		//�ж��Ƚ�
	    		if(random>this.getAratio() && random<=ratio ){
	    			int prize =2;
	    			prize_id = prize;
	    		}
	    	}
	    	//һ�Ƚ��Ͷ��Ƚ�û�п��
	    	if(this.getAtotal() ==0 && this.getBtotal()==0 && this.getCtotal()>0){
	    		//�����Ƚ�
	    		if(random>0 && random<=ratio ){
	    			int prize =3;
	    			prize_id = prize;
	    		}
	    	}
	    	//һ�Ƚ������Ƚ�û�п��
	    	if(this.getAtotal() ==0 && this.getBtotal()>0 && this.getCtotal()==0){
	    		//�ж��Ƚ�
	    		if(random>0 && random<=ratio ){
	    			int prize =2;
	    			prize_id = prize;
	    		}
	    	}
	    	//���Ƚ������Ƚ�û�п��
	    	if(this.getAtotal() >0 && this.getBtotal()==0 && this.getCtotal()==0){
	    		//��һ�Ƚ�
	    		if(random >0 && random<=ratio){
	    			int prize =1;
	    			prize_id = prize;
	    		}
	    	}
	    }		
		return prize_id;	
	}
}
