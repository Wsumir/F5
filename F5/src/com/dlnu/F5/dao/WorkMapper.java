package com.dlnu.F5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dlnu.F5.pojo.Emp;
import com.dlnu.F5.pojo.Work;

public interface WorkMapper {
	
	//��������
	void insert(Work work);
	
	//���¹���
	void update(Work work);
	
	//ɾ������
	void delete(Integer workId);
	
	//���ݽ����˲�ѯ������Ϣ
	List<Work> queryByToName(String workToName);
	
	//���ݷ����˲�ѯ������Ϣ
	List<Work> queryByFromName(String workFromName);
	
	//���ݹ���id��ѯ����
	Work queryById(Integer workId);
	
	//��ѯ���й���
	List<Work> query();
	
	//����ܼ�¼��
	int getCount();	
		
	//��ҳ��ѯ����
	List<Work> queryByPage(@Param("start")int start,@Param("pageSize")int pageSize);

}