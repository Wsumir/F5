package com.dlnu.F5.controller;


import java.util.HashMap;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlnu.F5.common.Pager;
import com.dlnu.F5.pojo.Emp;
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
	
	/**
	 * ���ݵ�¼������Ա������
	 */
	@RequestMapping("/emp/queryByNameZsh")
	@ResponseBody
	public Emp queryByNameZsh(HttpServletRequest request, HttpServletResponse response) {

		//��session�л�ȡ�û���
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		return service.queryEmpByNameZsh(empLoginName);
	}
	
	/**
	 * ��ҳ��ѯԱ��
	 */
	@RequestMapping("/emp/queryByPageZsh")
	@ResponseBody
	public HashMap<String, Object> queryByNameZsh(Integer pageNum,Integer pageSize,HttpServletRequest request, HttpServletResponse response) {

		Pager pager = new Pager(service.getEmpCountZsh(), pageSize, pageNum);		
		List<Emp> list = service.queryEmpByPageZsh(pager);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("list", list);
		
		return map;
	}
	
	/**
	 * lyl
	 */
	
	@ResponseBody
	@RequestMapping("/emp/queryByName")
	public Emp queryByName(Emp emp, HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		Emp e = service.TestQueryByName(empLoginName);
		return e;
	}
	
	@RequestMapping("/emp/updatePwd")
	public void updatePwd(Emp emp, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String empLoginName=(String) session.getAttribute("empLoginName");
		
		emp.setEmpLoginName(empLoginName);
						
		service.UpdatePwdByName(emp);
	}
	
	/**
	 * �޸�Ա��
	 */
	@RequestMapping("/emp/update")
	public void update(Emp emp, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
        String empLoginName=(String) session.getAttribute("empLoginName");
		
		emp.setEmpLoginName(empLoginName);
		
		service.updateEmp(emp);
	}
	
	/**
	 * �޸��û�ͷ��
	 */
	@RequestMapping("/emp/updatePic")
	@ResponseBody
	public void updatePic(String empPic,HttpServletRequest request, HttpServletResponse response) {
		
		//��session��ȡ���û���
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		service.updateEmpPic(empLoginName, empPic);
	}
	
	
	
	/**
	 * ��ҳ��ѯԱ��
	 */
	@RequestMapping("/emp/queryByPage")
	@ResponseBody
	public HashMap<String, Object> queryByName(Integer pageNum,Integer pageSize,HttpServletRequest request, HttpServletResponse response) {

		Pager pager = new Pager(service.getEmpCount(), pageSize, pageNum);		
		List<Emp> list = service.queryEmpByPage(pager);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("list", list);
		
		return map;
	}
	
	/**
	 * ���ݵ�¼������Ա��ͷ������
	 */
	@RequestMapping("/emp/queryHead")
	@ResponseBody
	public String queryByName(HttpServletRequest request, HttpServletResponse response) {

		// ��session��ȡ���û���
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");

		return service.TestQueryByName(empLoginName).getEmpPic();
	}
	
	/**
	 * zgz
	 */
	/**
	 * ��ҳ��ѯԱ��
	 */
	@RequestMapping("/emp/queryByPagezgz")
	@ResponseBody
	public HashMap<String, Object> queryByNamezgz(Integer pageNum,Integer pageSize,HttpServletRequest request, HttpServletResponse response) {

		Pager pager = new Pager(service.getEmpCount(), pageSize, pageNum);		
		List<Emp> list = service.queryEmpByPagezgz(pager);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("list", list);
		
		return map;
	}
	
	/**
	 * ����id����Ա������
	 */
	@RequestMapping("/emp/queryByIdzgz")
	@ResponseBody
	public List<Emp> queryByIdzgz(Integer empId, HttpServletRequest request, HttpServletResponse response) {

		return service.queryEmpByIdzgz(empId);
	}
	
	/**
	 * ����deptid����Ա������
	 */
	@RequestMapping("/emp/queryByDeptIdzgz")
	@ResponseBody
	public List<Emp> queryByDeptIdzgz(Integer deptId, HttpServletRequest request, HttpServletResponse response) {

		return service.queryEmpByDeptIdzgz(deptId);
	}
	
	/**
	 * ����jobid����Ա������
	 */
	@RequestMapping("/emp/queryByJobIdzgz")
	@ResponseBody
	public List<Emp> queryByJobIdzgz(Integer jobId, HttpServletRequest request, HttpServletResponse response) {

		return service.queryEmpByJobIdzgz(jobId);
	}
	
	
}
