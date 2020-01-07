package com.dlnu.F5.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dlnu.F5.pojo.Emp;

/**
 * Ա��dao
 * 
 * @author Administrator
 *
 */
public interface EmpMapper {

	//���ݵ�¼����ѯԱ������
	Emp queryByNameZsh(String empLoginName);
	
	//����ܼ�¼��
	int getCountZsh();	
		
	//��ҳ��ѯԱ��
	List<Emp> queryByPageZsh(@Param("start")int start,@Param("pageSize")int pageSize);
	
	//lyl

	// ���ݵ�¼����ѯԱ������
	Emp queryByName(String empLoginName);

	void insert(Emp emp);

	void updatePwdByName(Emp emp);

	////�޸�Ա��
	void update(Emp emp);

	// �����û�ͷ��
	void updatePic(@Param("empLoginName") String empLoginName, @Param("empPic") String empPic);

	// ����ܼ�¼��
	int getCount();

	// ��ҳ��ѯԱ��
	List<Emp> queryByPage(@Param("start") int start, @Param("pageSize") int pageSize);
	
	/*zgz*/
	// ��ҳ��ѯԱ��
			List<Emp> queryByPagezgz(@Param("start") int start, @Param("pageSize") int pageSize);
			
			//����id��ѯԱ������
			List<Emp> queryByIdzgz(Integer empId);
			
			//����deptid��ѯԱ������
			List<Emp> queryByDeptIdzgz(Integer deptId);
					
			//����jobid��ѯԱ������
			List<Emp> queryByJobIdzgz(Integer jobId);
}