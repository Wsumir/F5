package com.dlnu.F5.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlnu.F5.common.Pager;
import com.dlnu.F5.dao.EmpMapper;
import com.dlnu.F5.pojo.Emp;
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
		
		Emp emp = mapper.queryByNameZsh(empLoginName);
		if(emp==null){
			return 1;
		}else if(!empPwd.equals(emp.getEmpPwd())){
			return 2;
		}else {
			return 3;
		}
		
	}
	
	/**
	 * ���ݵ�¼������Ա������
	 */
	public Emp queryEmpByNameZsh(String empLoginName) {
		
		return mapper.queryByNameZsh(empLoginName);
	}
	
	/**
	 * ���Ա������
	 */
	public int getEmpCountZsh() {
		
		return mapper.getCountZsh();
	}
	
	/**
	 * ��ҳ��ѯԱ��
	 */
	public List<Emp> queryEmpByPageZsh(Pager pager) {
		
		return mapper.queryByPageZsh(pager.getStart(), pager.getPageSize());
	}
	
	
	/**
	 * lyl
	 */
	
	@Transactional(readOnly=true)
	public Emp TestQueryByName(String empLoginName) {
		Emp emp = mapper.queryByName(empLoginName);		
		System.out.println(emp);
		return emp;
	}
	
	@Transactional
	public void UpdatePwdByName(Emp emp){
		mapper.updatePwdByName(emp);
	}
	
	@Transactional
	/**
	 * �޸�Ա��
	 */
	public void updateEmp(Emp emp) {
		mapper.update(emp);
	}
	
	/**
	 * �޸��û�ͷ��
	 */
	public void updateEmpPic(String empLoginName,String empPic) {
		mapper.updatePic(empLoginName, empPic);
	}
	
	/**
	 * ���Ա������
	 */
	public int getEmpCount() {
		
		return mapper.getCount();
	}
	
	
	/**
	 * ��ҳ��ѯԱ��
	 */
	@Transactional(readOnly=true)
	public List<Emp> queryEmpByPage(Pager pager) {
		
		return mapper.queryByPage(pager.getStart(), pager.getPageSize());
	}
	
	/**
	 * zgz
	 */
	/**
	 * ��ҳ��ѯԱ��
	 */
	public List<Emp> queryEmpByPagezgz(Pager pager) {
		
		return mapper.queryByPagezgz(pager.getStart(), pager.getPageSize());
	}
	
	/**
	 * ����id����Ա������
	 */
	public List<Emp> queryEmpByIdzgz(Integer empId) {
		
		return mapper.queryByIdzgz(empId);
	}
	
	/**
	 * ����deptid����Ա������
	 */
	public List<Emp> queryEmpByDeptIdzgz(Integer deptId) {
		
		return mapper.queryByDeptIdzgz(deptId);
	}
	
	/**
	 * ����jobid����Ա������
	 */
	public List<Emp> queryEmpByJobIdzgz(Integer jobId) {
		
		return mapper.queryByJobIdzgz(jobId);
	}
}


