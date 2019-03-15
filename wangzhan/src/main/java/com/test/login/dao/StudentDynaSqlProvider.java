package com.test.login.dao;

import org.apache.ibatis.jdbc.SQL;

import com.test.login.domain.Student;

import java.util.Map;

public class StudentDynaSqlProvider {
	//��̬����ѧ����Ϣ
	public String saveStudent(Student student){
		String sql = new SQL(){
			{
				INSERT_INTO("student");
				if(student.getName()!=null&&!student.getName().equals("")){
					VALUES("name","#{name}");
				}
				if(student.getAge()!=null && !student.getAge().equals("")){
					VALUES("age","#{age}");
				}
				if(student.getPosition()!=null && !student.getPosition().equals("")){
					VALUES("position","#{position}");
				}
				if(student.getLogin()!=null && !student.getLogin().equals("")){
					VALUES("login_id","#{login.id}");
				}
			}
		}.toString();
		return sql;
	}
	
	//��̬�޸�ѧ����Ϣ
	public String updateStudent(Student student){
		String sql = new SQL(){
			{
				UPDATE("student");
				if(student.getName()!=null&&!student.getName().equals("")){
					SET(" name = #{name} ");
				}
				if(student.getAge()!=null && !student.getAge().equals("")){
					SET(" age = #{age} ");
				}
				if(student.getPosition()!=null && !student.getPosition().equals("")){
					SET(" position = #{position} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
		return sql;
	}
	
	//��̬��ѯ������
	public String countStudent(Map<String,Object> params){
		String sql = new SQL(){
			{
				SELECT("count(*)");
				FROM("student");
				if(params.get("student")!=null){
					Student student = (Student)params.get("student");
					if(student.getName()!=null && !student.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{student.name},'%') ");
					}
				}
			}
		}.toString();
		return sql;
	}
	
	//��̬��ҳ��ѯ
	public String selectStudent(Map<String,Object> params){
		String  sql = new SQL(){
			{
				SELECT("*");
				FROM("student");
				if(params.get("student")!=null){
					Student student = (Student)params.get("student");
					if(student.getName()!=null && !student.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{student.name},'%') ");
					}

				}
			}
		}.toString();
		if(params.get("pageModel")!=null){
			sql += " limit #{pageModel.firstLimitParam},#{pageModel.pageSize} ";
		}
		return sql;
	}
}
