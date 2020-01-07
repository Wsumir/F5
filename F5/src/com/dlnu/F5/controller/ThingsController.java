package com.dlnu.F5.controller;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dlnu.F5.pojo.Things;
import com.dlnu.F5.service.ThingsService;

/**
 * �ʲ���������
 *
 */
@Controller
public class ThingsController {
	
	@Autowired
	private ThingsService service;
	
	/**
	 * �����ʲ�
	 */
	@RequestMapping("/things/add")
	public void add(Things things, HttpServletRequest request, HttpServletResponse response){
		service.addThings(things);
	}
	
	/**
	 * �޸��ʲ���Ϣ
	 */
	@RequestMapping("/things/update")
	public void update(Things things, HttpServletRequest request, HttpServletResponse response){
		service.updataThings(things);
	}
	
	/**
	 * �޸��ʲ�������Ϣ
	 */
	@RequestMapping("/things/updateNumber")
	public void updateNumber(Things things, HttpServletRequest request, HttpServletResponse response){
		service.updataNumberThings(things);
	}
	
	/**
	 * ɾ���ʲ�
	 */
	@RequestMapping("/things/delete")
	public void delete(Integer thingsId, HttpServletRequest request, HttpServletResponse response){
		service.deleteThings(thingsId);
	}
	
	
	
	/**
	 * ���ʲ�id��ѯ��Ϣ(�б�
	 */
	@ResponseBody
	@RequestMapping("/things/queryById1")
	public List<Things> queryById1(Integer thingsId, HttpServletRequest request, HttpServletResponse response){
		return service.queryById1(thingsId);
	}
	
	/**
	 * ���ʲ�id��ѯ��Ϣ
	 */
	@ResponseBody
	@RequestMapping("/things/queryById")
	public Things queryById(Integer thingsId, HttpServletRequest request, HttpServletResponse response){
		return service.queryById(thingsId);
	}
	
	/**
	 * ���ʲ����ֲ�ѯ��Ϣ
	 */
	@ResponseBody
	@RequestMapping("/things/queryByName")
	public List<Things> queryByName(String thingsName, HttpServletRequest request, HttpServletResponse response){
		return service.queryByName(thingsName);
	}
	
	/**
	 * ���ʲ����Ͳ�ѯ��Ϣ
	 */
	@ResponseBody
	@RequestMapping("/things/queryByType")
	public List<Things> queryByType(String thingsType, HttpServletRequest request, HttpServletResponse response){
		return service.queryByType(thingsType);
	}
	
	/**
	 * ��ѯȫ���ʲ�
	 */
	@ResponseBody
	@RequestMapping("/things/query")
	public List<Things> query(HttpServletRequest request, HttpServletResponse response){
		return service.query();	
	}
	
}
