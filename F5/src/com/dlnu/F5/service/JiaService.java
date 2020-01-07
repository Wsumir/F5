package com.dlnu.F5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlnu.F5.dao.JiaMapper;
import com.dlnu.F5.pojo.Jia;

@Service
@Transactional(rollbackFor=Exception.class)
public class JiaService {
	
	@Autowired
	private JiaMapper mapper;
	
	/**
	 * ��������ѯ
	 */
	@Transactional(readOnly=true)
	public List<Jia> queryByName(String empLoginName) {
		
		return mapper.queryByName(empLoginName);
	}
	
	/**
	 * ����
	 */
	@Transactional
	public void addJia(Jia jia) {
		mapper.insert(jia);
	}

}
