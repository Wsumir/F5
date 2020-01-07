package com.dlnu.F5.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlnu.F5.common.Pager;
import com.dlnu.F5.dao.EmpMapper1;
import com.dlnu.F5.pojo.Emp;
import com.dlnu.F5.pojo.Expatriate;
import com.dlnu.F5.util.SendEmail;
import com.sun.mail.handlers.message_rfc822;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Ա��ģ�����ҵ��
 * @author Administrator
 *
 */

@Service
@Transactional(rollbackFor=Exception.class)
public class EmpService1 {

	@Autowired
	private EmpMapper1 mapper;
	
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
	
	public Emp queryByName(String empLoginName)
	{
		Emp emp = mapper.queryByName(empLoginName);
		return emp;
	}
	
	
	public Emp queryById(Integer empId){
		Emp emp = mapper.queryById(empId);
		return emp;
	}
	
	public Integer checkEmail(Integer empId) throws AddressException, MessagingException, InterruptedException
	{
		Emp emp= mapper.queryById(empId);
		
		String email = emp.getEmpEmail();
		
		System.out.println(email);
		
		int max=1000000,min=100000;
		int random = (int) (Math.random()*(max-min)+min); 
		System.out.println(random);
		
		String message = "��OAϵͳ��,��֤��"+random+"�����ڽ���������֤����Ǳ��˲���������Ա���Ϣ";
		SendEmail.send(email,message);
		
		return random;
	}
	
	



	
	
}
