package com.dlnu.F5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlnu.F5.common.Pager;
import com.dlnu.F5.dao.ExpatriateMapper;
import com.dlnu.F5.pojo.Expatriate;

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
	
	/**
	 * ��ҳ��ѯ������Ϣ
	 */
	public List<Expatriate> queryExpatriateByPage(Pager pager) {
		
		return mapper.queryByPage(pager.getStart(), pager.getPageSize());
	}
	
	public int getExpatriateCount() {
		
		return mapper.getCount();
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
	
	public void updateExpatriate(Expatriate expatriate){
		mapper.update(expatriate);
	}
	
	
}
