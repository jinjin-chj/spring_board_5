package edu.bit.emp.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class Criteria {
	
	// ����¡ ó���� ���ؼ��� ������ ��ȣ��, 
	// �� �������� ��� �����͸� ������ ������ �����Ǿ�� ��.
	private int pageNum;	// ������ ��ȣ
	private int amount;		// �� ������ �� ��� �����͸� ������ ���ΰ�.
	
	public Criteria() {
		this(1,5);	// �⺻�� 1������ 5���� ���� // this�Լ��� ������ ȣ��
			
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
		
}
