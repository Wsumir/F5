package com.dlnu.F5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlnu.F5.dao.MeetingMapper;
import com.dlnu.F5.pojo.Meeting;

/**
 * ����ģ�����ҵ��
 * @author Administrator
 *
 */

@Service
@Transactional(rollbackFor=Exception.class)
public class MeetingService {
	
	@Autowired
	private MeetingMapper mapper;
	
	/**
	 * ��ѯ����
	 */
	@Transactional(readOnly=true)
	public List<Meeting> query() {
		
		return mapper.query();
	}
	
	/**
	 * ��������ѯ����
	 */
	@Transactional(readOnly=true)
	public List<Meeting> queryByName(String empLoginName) {
		
		return mapper.queryByName(empLoginName);
	}
	
	/**
	 * ��idɾ������
	 */
	public void deleteMeeting(Integer meetingId){
		mapper.delete(meetingId);
	}
	
	/**
	 * ���ӻ���
	 */
	@Transactional
	public void addMeeting(Meeting meeting) {
		mapper.insert(meeting);
	}
	
	/**
	 * �޸�ʱ��
	 */
	@Transactional
	public void updateMeeting(Integer meetingId) {
		mapper.update(meetingId);
	}

}
