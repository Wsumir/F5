package com.dlnu.F5.dao;

import com.dlnu.F5.pojo.Emp;
import com.dlnu.F5.pojo.Expatriate;

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
	
	Emp queryById(Integer empId);
	

}