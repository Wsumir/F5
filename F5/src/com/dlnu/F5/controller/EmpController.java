package com.dlnu.F5.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlnu.F5.pojo.Emp;
import com.dlnu.F5.pojo.Expatriate;
import com.dlnu.F5.service.EmpService;

/**
 * ְԱ������
 * @author Administrator
 *
 */
@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	
	
	@ResponseBody
	@RequestMapping("/emp/login")
	public int login(Emp emp,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("/emp/login");
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
	@RequestMapping("/emp/queryById")
	public Emp queryById(Integer empId,HttpServletRequest request,HttpServletResponse response)
	{
		Emp emp=service.queryById(empId);
		
		return emp;
	}
	
	
	
	
}
