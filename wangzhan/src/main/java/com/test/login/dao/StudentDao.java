package com.test.login.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

import com.test.login.domain.Student;

public interface StudentDao {
	//��̬����ѧ����Ϣ
	@SelectProvider(type=StudentDynaSqlProvider.class,method="saveStudent")
	void saveSt(Student student);
	
	//ɾ��ѧ����Ϣ
	@Delete(" delete from student where id = #{id} ")
	void del(Integer id);
	
	//��̬�޸�ѧ����Ϣ
	@SelectProvider(type=StudentDynaSqlProvider.class,method="updateStudent")
	void updateSt(Student student);
	
	//��̬��ѯ������
	@SelectProvider(type=StudentDynaSqlProvider.class,method="countStudent")
	Integer countSt(Map<String,Object> params);
	
	//��̬��ҳ��ѯ
	@SelectProvider(type=StudentDynaSqlProvider.class,method="selectStudent")
	List<Student> selectStu(Map<String,Object> params);
	
	 //����ҳ��ѯ����
	@Select(" select * from student where login_id = #{id} ")
	List<Student> selectByidonin(Integer login_id);
	
	//������̬��ҳ��ѯ
	@SelectProvider(type=StudentDynaSqlProvider.class,method="selcStudent")
	@Results({
		@Result(id=true,column="id",property="id")
	})
	List<Student> selectStuin(Map<String,Object> params);
}
