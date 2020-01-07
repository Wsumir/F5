package com.dlnu.F5.dao;

import java.util.List;

import com.dlnu.F5.pojo.Meeting;

/**
 * ����dao
 * 
 * @author Administrator
 *
 */
public interface MeetingMapper {
	
	//��ѯ���л���ԤԼ���
	List<Meeting> query();

	//��������ѯ�μӵĻ���
	List<Meeting> queryByName(String empLoginName);
	
	//ɾ������
	void delete(Integer meetingId);
	
	//���ӻ���
	void insert(Meeting meeting );
	
	//�޸�ʱ��
	void update(Integer meetingId);
}
