package com.icss.oa.emp.dao;

import com.icss.oa.emp.pojo.Emp;

/**
 * Ա��dao
 * 
 * @author Administrator
 *
 */
public interface EmpMapper {

	//���ݵ�¼����ѯԱ������
	Emp queryByName(String empLoginName);
	
	void insert(Emp emp);

}