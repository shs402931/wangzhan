package com.test.login.common;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	//code״̬�� 200�ɹ���100ʧ��
	private int state;
	//msg��Ϣ����
	private String msg;
	//��֤��
	private String code;
	//��������ص���Ϣ
	private Map<String,Object> information = new HashMap<>();
	
	//ע����Ϣ
	public static Msg successRegister(){
		Msg result =new Msg();
		result.setState(200);
		result.setMsg("ע��ɹ�");
		return result;
	}
	public static Msg failRegister(){
		Msg result =new Msg();
		result.setState(100);
		result.setMsg("�û��������벻��Ϊ��");
		return result;
	}
	public static Msg failname(){
		Msg result =new Msg();
		result.setState(100);
		result.setMsg("�û����Ѵ���");
		return result;
	}
	
	//�����ֶε�json����
	public Msg add(String key,Object value){
		this.getInformation().put(key, value);
		return this;
	}
	
	//����
	public static Msg bamboo(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("�������ӳɹ�");
		return result;
	}
	public static Msg ssbamboo(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("��ѯ���ӳɹ�");
		return result;
	}
	public static Msg delbamboo(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("ɾ�����ӳɹ�");
		return result;
	}
	public static Msg upbamboo(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("�޸����ӳɹ�");
		return result;
	}
	
	//��ӽ�Ʒ�ɹ�
	public static Msg prizeAll(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("��ӽ�Ʒ�ɹ�");
		return result;
	}
	public static Msg prizeId(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("�ý�Ʒ�ȼ��Ѵ��ڣ��������");
		return result;
	}
	public static Msg prizeupdate(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("�޸Ľ�Ʒ�ɹ�");
		return result;
	}
	public static Msg prizess(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("��Ʒ�ѷ������");
		return result;
	}
	public static Msg level(){
		Msg result = new Msg();
		result.setMsg("��ϲ�㣬�н���");
		return result;
	}
	public static Msg time(){
		Msg result = new Msg();
		result.setMsg("û�г齱����");
		return result;
	}

	
	//��ҳ��ѯ
	public static Msg page(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("��ҳ��ѯ�ɹ�");
		return result;
	}
	
	//��ҳ
	public static Msg successPage(){
		Msg result = new Msg();
		Random  code = new Random();
		String codes = code.getCode();
		result.setState(200);
		result.setCode(codes);
		return result;
	}
	
	//��¼��Ϣ
	public static Msg successLogin(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("��¼�ɹ�");
		return result;
	}
	public static Msg failLogin(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("�˺Ż��������");
		return result;
	}
	
	//����ѧ����Ϣ
	public static Msg successStudent(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("����ѧ����Ϣ�ɹ�");
		return result;
	}
	//ɾ��ѧ����Ϣ
	public static Msg delStudent(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("ɾ��ѧ����Ϣ�ɹ�");
		return result;
	}
	
	//ɾ��ѧ����Ϣ
	public static Msg delStudent1(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("ɾ��ѧ����Ϣ�ɹ�");
		return result;
	}
	
	//�޸�ѧ����Ϣ
	public static Msg updateStudent(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("�޸�ѧ����Ϣ�ɹ�");
		return result;
	}
	
	//δ��½�����ȵ�¼
	public static Msg failSign(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("δ��½�����ȵ�¼�˺�");
		return result;
	}
	
	//�ϴ��ɹ�
	public static Msg down(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("�ϴ��ɹ�");
		return result;
	}
	
	//��ѯ�ɹ�
	public static Msg selectDocument(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("��ѯ�ɹ�");
		return result;
	}
	
	//���سɹ�
	public static Msg downloadDocument(){
		Msg result = new Msg();
		result.setState(100);
		result.setMsg("���سɹ�");
		return result;
	}
	
	//��ѯ�ɹ�
	public static Msg company(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("��ѯ�ɹ�");
		return result;
	}
	
	//��ѯ�ɹ�
	public static Msg person(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("��ѯ�ɹ�");
		return result;
	}
	
	//��ѯ�ɹ�
	public static Msg teacher(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("��ѯ�ɹ�");
		return result;
	}
	
	//��ѯ�ɹ�
	public static Msg order(){
		Msg result = new Msg();
		result.setState(200);
		result.setMsg("��ѯ�ɹ�");
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
