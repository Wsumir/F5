package com.dlnu.F5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlnu.F5.dao.CarMapper;
import com.dlnu.F5.dao.EmpMapper;
import com.dlnu.F5.pojo.Emp;
import com.dlnu.F5.common.Pager;
import com.dlnu.F5.dao.CarMapper;
import com.dlnu.F5.pojo.Car;

@Service
@Transactional(rollbackFor=Exception.class)
public class CarService {

	@Autowired
	private CarMapper mapper;
	
	//�����³���
	public void addCar(Car car) {
		mapper.insert(car);
	}
	
	/**
	 * ɾ��Ա��
	 * @param emp
	 */
	public void deleteCar(Integer carId) {
		mapper.delete(carId);
	}
	
	/**
	 * �޸�Ա��
	 */
	public void updateCar(Car car) {
		mapper.update(car);
	}
	public void updateCar2(Car car) {
		mapper.update2(car);
	}
	

	/**
	 * ����id���س�������
	 */
	public Car queryCarById(Integer carId) {
		
		return mapper.queryById(carId);
	}
	
	
	/**
	 * ���ݳ��Ʒ��س�������
	 */
	public Car queryCarByBoard(String carBoard) {
		
		return mapper.queryByBoard(carBoard);
	}
	
	/**
	 * ��ó�������
	 */
	public int getCarCount() {
		
		return mapper.getCount();
	}
	
	/**
	 * ��ҳ��ѯ����
	 */
	public List<Car> queryCarByPage(Pager pager) {
		
		return mapper.queryByPage(pager.getStart(), pager.getPageSize());
	}
}