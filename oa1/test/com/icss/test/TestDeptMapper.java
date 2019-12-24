package com.icss.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.dept.dao.DeptMapper;
import com.icss.oa.dept.pojo.Dept;

public class TestDeptMapper {
	
	//������������
	private ApplicationContext context =
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//���Bean
	private DeptMapper mapper = context.getBean(DeptMapper.class);
	
	
	@Test
	public void testInsert() {		
		Dept dept = new Dept("���²�", "����԰��");
		mapper.insert(dept);		
	}
	@Test
	public void testUpdate(){
		Dept dept = new Dept(3,"���²�1", "����1");
		mapper.update(dept);
	}
	
	@Test
	public void testDelete(){
		mapper.delete(6);
	}
	
	@Test
	public void testQueryById(){
		Dept dept = mapper.queryById(2);
		System.out.println(dept);
	}
	
	@Test
	public void testQuery(){
		List<Dept> list = mapper.query();
		for(Dept dept : list){
			System.out.println(dept);
		}
	}

}