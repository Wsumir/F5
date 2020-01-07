package com.dlnu.F5.dao;

import java.util.List;

import com.dlnu.F5.pojo.Things;

public interface ThingsMapper {
	
	//�����ʲ�
    int insert(Things things);
    
    //�����ʲ�
    int update(Things things);
    
    //�����ʲ�����
    int updateNumber(Things things);
    
    //ɾ���ʲ�
  	void delete(Integer thingsId);
  	
  	Things queryById(Integer thingsId);
  	
  	//�����ʲ�id��ѯ�ʲ�(�б�)
  	List<Things> queryById1(Integer thingsId);
  	
  	//��ѯ�����ʲ�
  	List<Things> query();
  	
  	//�����ʲ����ֲ�ѯ�ʲ�
  	List<Things> queryByName(String thingsName);
  	
  	//�����ʲ����Ͳ�ѯ����
  	List<Things> queryByType(String thingstype);
}