package com.dlnu.F5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlnu.F5.dao.ExpatriateMapper;
import com.dlnu.F5.pojo.Expatriate;
import com.sun.jndi.cosnaming.ExceptionMapper;

import oracle.net.aso.e;

/**
 * ����ģ�����ҵ��
 */

@Service
@Transactional(rollbackFor=Exception.class)
public class ExpatriateService {

	@Autowired
	private ExpatriateMapper mapper;
	
	/**
	 *��ѯ����������Ϣ
	 */
	@Transactional(readOnly=true)
	public List<Expatriate> query(){
		return mapper.query();
	}
	
	public void AddExpatriate(Expatriate expatriate)
	{
		mapper.insert(expatriate);
	}
	
	public Expatriate queryById(Integer expatriateId){
		Expatriate expatriate = mapper.queryById(expatriateId);
		return expatriate;
	}
	
	public void deleteExpatriate(Integer expatriateId){
		mapper.delete(expatriateId);
	}
	
	
	
	
}
