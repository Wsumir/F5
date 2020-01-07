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
import com.dlnu.F5.pojo.Meeting;
import com.dlnu.F5.service.MeetingService;

/**
 * ���������
 * 
 * @author Administrator
 *
 */
@Controller
public class MeetingController {
	
	@Autowired
	private MeetingService service;
	
	/**
	 * ��ѯ����
	 */
	@RequestMapping("/meeting/query")
	@ResponseBody
	public List<Meeting> query(HttpServletRequest request, HttpServletResponse response) {

		List<Meeting> list = service.query();
		
		return list;
	}
	
	/**
	 * ��������ѯ����
	 */
	@RequestMapping("/meeting/queryByName")
	@ResponseBody
	public List<Meeting> queryByName(Meeting meeting ,HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		List<Meeting> list = service.queryByName(empLoginName);
		
		return list;
	}
	
	/**
	 * ��idɾ������
	 */
	@RequestMapping("/meeting/delete")
	public void delete(Integer meetingId , HttpServletRequest request, HttpServletResponse response){
		service.deleteMeeting(meetingId);
	}
	
	/**
	 * ���ӻ���
	 */
	@RequestMapping("/meeting/add")
	public void add(Meeting meeting, HttpServletRequest request, HttpServletResponse response) {
		
		service.addMeeting(meeting);
	}
	
	/**
	 *�޸�ʱ��
	 */
	@RequestMapping("/meeting/update")
	public void update(Integer meetingId , HttpServletRequest request, HttpServletResponse response) {
		
		service.updateMeeting(meetingId);
	}

}
