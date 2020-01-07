package com.dlnu.F5.controller;

import java.util.HashMap;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.quartz.utils.StringKeyDirtyFlagMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlnu.F5.common.Pager;
import com.dlnu.F5.pojo.Work;
import com.dlnu.F5.service.WorkService;

/**
 * ������������
 *
 */
@Controller
public class WorkController {
	
	@Autowired
	private WorkService service;
	
	/**
	 * ���ӹ���
	 */
	@RequestMapping("/work/add")
	public void add(Work work, HttpServletRequest request, HttpServletResponse response){
		service.addWork(work);
	}
	
	/**
	 * �޸Ĳ�����Ϣ
	 */
	@RequestMapping("/work/update")
	public void update(Work work, HttpServletRequest request, HttpServletResponse response){
		service.updataWork(work);
	}
	
	/**
	 * ɾ������
	 */
	@RequestMapping("/work/delete")
	public void delete(Integer workId, HttpServletRequest request, HttpServletResponse response){
		service.deleteWork(workId);
	}
	
	/**
	 * �����������ֲ�ѯ��Ϣ
	 */
	@ResponseBody
	@RequestMapping("/work/queryByToName")
	public List<Work> queryByToName(String workToName, HttpServletRequest request, HttpServletResponse response){

		return service.queryWorkByToName(workToName);
	}
		
	/**
	 * �����������ֲ�ѯ��Ϣ
	 */
	@ResponseBody
	@RequestMapping("/work/queryByFromName")
	public List<Work> queryByFromToName(String workFromName, HttpServletRequest request, HttpServletResponse response){

		return service.queryWorkByFromName(workFromName);
	}
	
	/**
	 * ��id��ѯ��Ϣ
	 */
	@ResponseBody
	@RequestMapping("/work/queryById")
	public Work queryById(Integer workId, HttpServletRequest request, HttpServletResponse response){
		return service.queryWorkById(workId);
	}
	
	/**
	 * ��ѯȫ������
	 */
	@ResponseBody
	@RequestMapping("/work/query")
	public List<Work> query(HttpServletRequest request, HttpServletResponse response){
		return service.query();		
	}
	
	/**
	 * ��ҳ��ѯ����
	 */
	@RequestMapping("/work/queryByPage")
	@ResponseBody
	public HashMap<String, Object> queryByPager(Integer pageNum,Integer pageSize,HttpServletRequest request, HttpServletResponse response) {

		Pager pager = new Pager(service.getWorkCount(), pageSize, pageNum);
		List<Work> list = service.queryWorkByPage(pager);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("list", list);
		
		return map;
	}
}
