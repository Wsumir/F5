package com.dlnu.F5.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlnu.F5.dao.ThingsMapper;
import com.dlnu.F5.pojo.Things;

/**
 * �ʲ�ҵ��
 * @author Administrator
 *
 */
@Service
public class ThingsService {

	@Autowired
	private ThingsMapper mapper;
	
	public void addThings(Things things){
		mapper.insert(things);
	}
	
	public void updataThings(Things things){
		mapper.update(things);
	}
	
	public void deleteThings(Integer thingsId){
		mapper.delete(thingsId);
	}
	
	/**
	 * �����ʲ�ʹ������
	 */
	public void updataNumberThings(Things things){
		mapper.updateNumber(things);
	}
	
	/**
	 * �����ʲ�id��ѯ�ʲ�(�б�)
	 */
	@Transactional(readOnly=true)
	public List<Things> queryById1(Integer thingsId){
		return mapper.queryById1(thingsId);
	}
	
	/**
	 * �����ʲ�id��ѯ�ʲ�
	 */
	@Transactional(readOnly=true)
	public Things queryById(Integer thingsId){
		return mapper.queryById(thingsId);
	}
	
	/**
	 * �����ʲ����ֲ�ѯ�ʲ�
	 */
	@Transactional(readOnly=true)
	public List<Things> queryByName(String thingsName){
		return mapper.queryByName(thingsName);
	}
	
	/**
	 * �����ʲ����Ͳ�ѯ�ʲ�
	 */
	@Transactional(readOnly=true)
	public List<Things> queryByType(String thingsType){
		return mapper.queryByType(thingsType);
	}
	
	/**
	 * ��ѯ�����ʲ���Ϣ
	 */
	@Transactional(readOnly=true)
	public List<Things> query() {		 
		return mapper.query();
	}
	

}
