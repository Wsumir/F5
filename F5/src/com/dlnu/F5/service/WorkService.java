package com.dlnu.F5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlnu.F5.common.Pager;
import com.dlnu.F5.dao.WorkMapper;
import com.dlnu.F5.pojo.Work;

/**
 * ������ҵ��
 * @author Administrator
 *
 */
@Service
public class WorkService {

	@Autowired
	private WorkMapper mapper;
	
	public void addWork(Work work){
		mapper.insert(work);
	}
	
	public void updataWork(Work work){
		mapper.update(work);
	}
	
	public void deleteWork(Integer workId){
		mapper.delete(workId);
	}
	
	/**
	 *���ݽ����˲�ѯ����
	 */
	@Transactional(readOnly=true)
	public List<Work> queryWorkByToName(String workToName){
		return mapper.queryByToName(workToName);
	}
	
	/**
	 * ���ݷ����˲�ѯ����
	 */
	@Transactional(readOnly=true)
	public List<Work> queryWorkByFromName(String workFromName){
		return mapper.queryByFromName(workFromName);
	}
	
	/**
	 * ���ݹ���id��ѯ����
	 */
	@Transactional(readOnly=true)
	public Work queryWorkById(Integer workId){
		return mapper.queryById(workId);
	}
	
	/**
	 * ��ѯ���й���ϸ��Ϣ
	 */
	@Transactional(readOnly=true)
	public List<Work> query() {		 
		return mapper.query();
	}
	
	
	/**
	 * ��ù�������
	 */
	public int getWorkCount() {
		
		return mapper.getCount();
	}
	
	
	/**
	 * ��ҳ��ѯ����
	 */
	public List<Work> queryWorkByPage(Pager pager) {
		
		return mapper.queryByPage(pager.getStart(), pager.getPageSize());
	}
	
}
