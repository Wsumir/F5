package com.icss.oa.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.emp.dao.EmpMapper;
import com.icss.oa.emp.pojo.Emp;

/**
 * Ա��ģ�����ҵ��
 * @author Administrator
 *
 */

@Service
@Transactional(rollbackFor=Exception.class)
public class EmpService {

	@Autowired
	private EmpMapper mapper;
	
	/**
	 * ��¼��֤
	 * ����1 �û���������
	 * ����2 �������
	 * ����3 ��¼�ɹ�
	 */
	@Transactional(readOnly=true)
	public int cherkLogin(String empLoginName,String empPwd){
		
		Emp emp = mapper.queryByName(empLoginName);
		if(emp==null){
			return 1;
		}else if(!empPwd.equals(emp.getEmpPwd())){
			return 2;
		}else {
			return 3;
		}
		
	}
	
	
	
	
	
	
	
	
}
