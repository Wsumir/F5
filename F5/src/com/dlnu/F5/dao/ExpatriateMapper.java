package com.dlnu.F5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dlnu.F5.pojo.Expatriate;

/**
 * ������Ա��Ϣ
 */
public interface ExpatriateMapper {

	List<Expatriate> query();
			
	void insert(Expatriate expatriate);
		
	Expatriate queryById(Integer expatriateId);
	
	void delete(Integer expatriateid);
	
	void update(Expatriate expatriate);
	
	int getCount();	
	
	//��ҳ��ѯԱ��
	List<Expatriate> queryByPage(@Param("start")int start,@Param("pageSize")int pageSize);
}
