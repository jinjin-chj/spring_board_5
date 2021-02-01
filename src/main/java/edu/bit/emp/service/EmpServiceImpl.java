package edu.bit.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.emp.mapper.EmpMapper;
import edu.bit.emp.page.Criteria;
import edu.bit.emp.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class EmpServiceImpl implements EmpService {
	private EmpMapper mapper;

	// 직원 정보 리스트
	@Override
	public List<EmpVO> getList() {
		log.info("getList()");
		return mapper.getList();
	}

	// 직급 정보 불러오기
	@Override
	public List<EmpVO> jobList() {
		log.info("jobList()");
		return mapper.jobList();
	}

	// 상사 정보 불러오기
	@Override
	public List<EmpVO> mgrList() {
		log.info("mgrList()");
		return mapper.mgrList();
	}

	// 부서 정보 불러오기
	@Override
	public List<EmpVO> deptList() {
		log.info("deptList()");
		return mapper.deptList();
	}

	// 직원 정보 작성
	@Override
	public void write(EmpVO empVO) {
		mapper.insert(empVO);
		log.info("write()");
	}

	@Override
	public List<EmpVO> getList(Criteria cri) {
		log.info("get List with criteria" + cri);	
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");	
		return mapper.getTotalCount(cri);
	}
}