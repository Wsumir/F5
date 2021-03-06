package com.dlnu.F5.controller;

import com.dlnu.F5.common.Pager;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlnu.F5.pojo.Emp;
import com.dlnu.F5.pojo.Expatriate;
import com.dlnu.F5.service.ExpatriateService;

/**
 * 外派控制器
 * @author Administrator
 *
 */
@Controller
public class ExpatriateController {
	@Autowired
	private ExpatriateService service;
	
	
	@ResponseBody
	@RequestMapping("/expatriate/query")
	public List<Expatriate> query(HttpServletRequest request,HttpServletResponse response)
	{
		List<Expatriate> list = service.query();
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/expatriate/add")
	public void add(Expatriate expatriate,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("/expatriate/add");
		service.AddExpatriate(expatriate);
	}
	
	@ResponseBody
	@RequestMapping("/expatriate/queryById")
	public Expatriate queryById(Integer expatriateId,HttpServletRequest request,HttpServletResponse response)
	{
		Expatriate expatriate=service.queryById(expatriateId);
		
		return expatriate;
	}
	
	
	@ResponseBody
	@RequestMapping("/expatriate/delete")
	public void delete(Integer expatriateId,HttpServletRequest request,HttpServletResponse response)
	{
		service.deleteExpatriate(expatriateId);;
		System.out.println("/expatriate/delete");
	}
	
	@ResponseBody
	@RequestMapping("/expatriate/update")
	public void update(Expatriate expatriate,HttpServletRequest request,HttpServletResponse response)
	{
		service.updateExpatriate(expatriate);
		System.out.println("/expatriate/update");
	}
	
	/**
	 * 分页查询员工
	 */
	@RequestMapping("/expatriate/queryByPage")
	@ResponseBody
	public HashMap<String, Object> queryByName(Integer pageNum,Integer pageSize,HttpServletRequest request, HttpServletResponse response) {

		Pager pager = new Pager(service.getExpatriateCount(), pageSize, pageNum);		
		List<Expatriate> list = service.queryExpatriateByPage(pager);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("list", list);
		
		return map;
	}
	
	
}





