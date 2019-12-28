package com.icss.oa.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.oa.emp.pojo.Emp;
import com.icss.oa.emp.service.EmpService;

/**
 * Ա��������
 * @author Administrator
 *
 */
@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	/**
	 * ��¼����
	 * @return
	 */
	@RequestMapping("/emp/login")
	@ResponseBody
	public int login(Emp emp,HttpServletRequest request,HttpServletResponse response) {
		
		int result = service.checkLogin(emp.getEmpLoginName(), emp.getEmpPwd());
		
		//��¼�ɹ�����¼��¼״̬
		if (result == 3) {
			HttpSession session = request.getSession();
			session.setAttribute("empLoginName", emp.getEmpLoginName());
		}
		
		return result;		
	}
	
	/**
	 * ����Ա��
	 */
	@RequestMapping("/emp/add")
	public void add(Emp emp,HttpServletRequest request,HttpServletResponse response) {
		service.addEmp(emp);
	}
	
	/**
	 * ���ݵ�¼������Ա������
	 */
	@RequestMapping("/emp/queryByName")
	@ResponseBody
	public Emp queryByName(String empLoginName,HttpServletRequest request,HttpServletResponse response) {
		
		return service.queryEmpByName(empLoginName);
	}
	
}