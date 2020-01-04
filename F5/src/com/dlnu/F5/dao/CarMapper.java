package com.dlnu.F5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dlnu.F5.pojo.Car;
import com.dlnu.F5.pojo.Emp;

/**
 * Ա��dao
 * 
 * @author Administrator
 *
 */
public interface CarMapper {
	
	// ����܇�v
	void insert(Car car);

	// ɾ��܇�v
	void delete(int carId);

	// �޸�܇�v
	void update(Car car);
	void update2(Car car);

	// ����id��ѯ܇�v����
	Car queryById(Integer carId);
	
	// ���ݳ��Ʋ�ѯ܇�v����
	Car queryByBoard(String carBoard);

	// ����ܼ�¼��
	int getCount();

	// ��ҳ��ѯ����
	List<Car> queryByPage(@Param("start") int start, @Param("pageSize") int pageSize);

}