package edu.bit.emp.mapper;

import java.util.List;

import edu.bit.emp.vo.EmpVO;

public interface EmpMapper {

	public List<EmpVO> getList();

	public EmpVO read(int getEmpno);

	public void insertEmp(EmpVO empVO);

}