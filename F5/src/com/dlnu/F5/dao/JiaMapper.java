package com.dlnu.F5.dao;

import java.util.List;

import com.dlnu.F5.pojo.Jia;


public interface JiaMapper {
	
	//��������ѯ���
		List<Jia> queryByName(String empLoginName);
		
		//����
		void insert(Jia jia );

}
