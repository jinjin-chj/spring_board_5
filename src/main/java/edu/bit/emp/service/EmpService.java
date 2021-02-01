package edu.bit.emp.service;

import java.util.List;

import edu.bit.emp.page.Criteria;
import edu.bit.emp.vo.EmpVO;

public interface EmpService {
	// �������� ����Ʈ
	public List<EmpVO> getList();

	// ���� ���� �ҷ�����
	public List<EmpVO> jobList();

	// ��� ���� �ҷ�����
	public List<EmpVO> mgrList();

	// �μ� ���� �ҷ�����
	public List<EmpVO> deptList();

	// ���� ���� �ۼ��ϱ�
	public void write(EmpVO empVO);

	public List<EmpVO> getList(Criteria cri);

	public int getTotal(Criteria cri);
}