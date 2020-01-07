package com.dlnu.F5.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlnu.F5.pojo.Car;
import com.dlnu.F5.service.CarService;
import com.dlnu.F5.pojo.Emp;
import com.dlnu.F5.common.Pager;
import com.dlnu.F5.pojo.Car;

/**
 * ���ſ�����
 */
@Controller
public class CarController {
	
	@Autowired
	private CarService service;
	
	/**
	 * ���ӳ���
	 */
	@RequestMapping("/car/add")
	public void add(Car car , HttpServletRequest request, HttpServletResponse response){
		
		service.addCar(car);
	}
	
	
	
	/**
	 * ɾ������
	 */
	@RequestMapping("/car/delete")
	public void delete(Integer carId, HttpServletRequest request, HttpServletResponse response) {
		service.deleteCar(carId);
	}
	
	/**
	 * �޸ĳ���
	 */
	@RequestMapping("/car/update")
	public void update(Car car, HttpServletRequest request, HttpServletResponse response) {
		service.updateCar(car);
	}
	@RequestMapping("/car/update2")
	public void update2(Car car, HttpServletRequest request, HttpServletResponse response) {
		service.updateCar2(car);
	}
	
	
	/**
	 * ���ݵ�¼������Ա������
	 */
	@RequestMapping("/car/queryByBoard")
	@ResponseBody
	public Car queryByBoard(String carBoard, HttpServletRequest request, HttpServletResponse response) {

		return service.queryCarByBoard(carBoard);
	}
	
	/**
	 * ����id���س�������
	 */
	@RequestMapping("/car/queryById")
	@ResponseBody
	public Car queryById(Integer carId, HttpServletRequest request, HttpServletResponse response) {

		return service.queryCarById(carId);
	}
	/**
	 * ��ҳ��ѯ����
	 */
	@RequestMapping("/car/queryByPage")
	@ResponseBody
	public HashMap<String, Object> queryByName(Integer pageNum,Integer pageSize,HttpServletRequest request, HttpServletResponse response) {

		Pager pager = new Pager(service.getCarCount(), pageSize, pageNum);		
		List<Car> list = service.queryCarByPage(pager);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("list", list);
		
		return map;
	}
    
	
	
	
}
