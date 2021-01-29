package edu.bit.emp.service;

import java.util.List;

import edu.bit.emp.vo.EmpVO;

public interface EmpService {

	public List<EmpVO> getList();

	public EmpVO getEmp(int getEmpno);

	public void insertEmp(EmpVO empVO);

}