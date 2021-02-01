package edu.bit.emp.mapper;

import java.util.List;

import edu.bit.emp.page.Criteria;
import edu.bit.emp.vo.EmpVO;

public interface EmpMapper {
	// ���� ���� �ҷ�����
	public List<EmpVO> getList();

	// ���� ���� �ҷ�����
	public List<EmpVO> jobList();

	// ��� ���� �ҷ�����
	public List<EmpVO> mgrList();

	// �μ� ���� �ҷ�����
	public List<EmpVO> deptList();

	// ��ġ ���� �ҷ�����
	public List<EmpVO> locList();

	// ���� ���� �Է��ϱ�
	public void insert(EmpVO empVO);

	public List<EmpVO> getListWithPaging(Criteria cri);

	public int getTotalCount(Criteria cri);
}