package com.dlnu.F5.controller;


import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlnu.F5.common.Pager;
import com.dlnu.F5.pojo.Emp;
import com.dlnu.F5.service.EmpService1;

/**
 * ְԱ������
 * @author Administrator
 *
 */
@Controller
public class EmpController1 {
	@Autowired
	private EmpService1 service;
	
	
	@ResponseBody
	@RequestMapping("/emp1/login")
	public int login(Emp emp,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("/emp1/login");
		int result=service.cherkLogin(emp.getEmpLoginName(), emp.getEmpPwd());
		System.out.println(result);
		//��¼�ɹ�����¼��¼״̬
		if(result==3){
			HttpSession session = request.getSession();
			session.setAttribute("empLoginName", emp.getEmpLoginName());	
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/emp1/queryById")
	public Emp queryById(Integer empId,HttpServletRequest request,HttpServletResponse response)
	{
		Emp emp=service.queryById(empId);
		
		return emp;
	}
	
	@ResponseBody
	@RequestMapping("/emp1/queryByName")
	public Emp queryByName(String empLoginName,HttpServletRequest request,HttpServletResponse response)
	{
//		String loginName = (String)request.getSession().getAttribute("empLoginName");
		System.out.println("/emp/queryByName");
		Emp emp=service.queryByName(empLoginName);
		return emp;
	}
	
	@ResponseBody
	@RequestMapping("/emp1/queryName")
	public Emp queryName(HttpServletRequest request,HttpServletResponse response)
	{
		String loginName = (String)request.getSession().getAttribute("empLoginName");
		
		Emp emp=service.queryByName(loginName);
		return emp;
	}
	
	@ResponseBody
	@RequestMapping("/emp1/checkEmail")
	public Integer checkEmail(HttpServletRequest request,HttpServletResponse response) throws AddressException, MessagingException, InterruptedException
	{
		
		String loginName = (String)request.getSession().getAttribute("empLoginName");
		Emp emp = service.queryByName(loginName);
		
		Integer empId=emp.getEmpId();
		
		Integer random = service.checkEmail(empId);
			
		return random;
	}
	
	
	
	
	
}
