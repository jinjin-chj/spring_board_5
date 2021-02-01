package edu.bit.emp.mapper;

import java.util.List;

import edu.bit.emp.page.Criteria;
import edu.bit.emp.vo.EmpVO;

public interface EmpMapper {
	// 직원 정보 불러오기
	public List<EmpVO> getList();

	// 직급 정보 불러오기
	public List<EmpVO> jobList();

	// 상사 정보 불러오기
	public List<EmpVO> mgrList();

	// 부서 정보 불러오기
	public List<EmpVO> deptList();

	// 위치 정보 불러오기
	public List<EmpVO> locList();

	// 직원 정보 입력하기
	public void insert(EmpVO empVO);

	public List<EmpVO> getListWithPaging(Criteria cri);

	public int getTotalCount(Criteria cri);
}