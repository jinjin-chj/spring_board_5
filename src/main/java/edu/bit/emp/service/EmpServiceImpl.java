package edu.bit.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.emp.mapper.EmpMapper;
import edu.bit.emp.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class EmpServiceImpl implements EmpService { 

	private EmpMapper mapper;

	@Override
	public List<EmpVO> getList() {
		return mapper.getList();
	}

	@Override
	public EmpVO getEmp(int getEmpno) {
		log.info("read");
		return mapper.read(getEmpno);
	}

	@Override
	public void insertEmp(EmpVO empVO) {
		log.info("insert");
		mapper.insertEmp(empVO);
	}

}