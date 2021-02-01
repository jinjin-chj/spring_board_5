package edu.bit.emp.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter

public class PageVO {
	// ����¡ ó�� �� �� �ʿ��� ������
	private int startPage; // ȭ�鿡 �������� ������ ���۹�ȣ (1...10)
	private int endPage; // ȭ�鿡 �������� ������ ����ȣ
	private boolean prev, next; // ����, �������� �̵������� ��ũ ǥ��
	// private int displayPageCount = 10; // �̰� �����ϸ� �Ʒ� �������������� ��ü ����

	private int total; // ��ü ��(������) ��
	private Criteria cri;

	public PageVO(Criteria cri, int total) {
		this.total = total;
		this.cri = cri;

		this.endPage = (int) (Math.ceil(cri.getPageNum() / 5.0)) * 5;
		// this.endPage = (int) (Math.ceil(cri.getPageNum() / displayPageCount)) * 10;

		this.startPage = this.endPage - 4;

		// Total�� ���� endPage�� ����
		// ��, 10���� �����ִ� ��� ��ü ������ ���� 80����� �����ϸ� ����ȣ�� 10�� �ƴ� 8�� ��
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		if (realEnd <= this.endPage) {
			this.endPage = realEnd;
		}

		// ���۹�ȣ�� 1���� ū ��� ����
		this.prev = this.startPage > 1;
		// realEnd �� ����ȣ(endPage)���� ū ��쿡�� ����
		this.next = this.endPage < realEnd;
	}

	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder;
		uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) 
				// pageNum = 3
				.queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
				.build(); // ?pageNum=3&amount=10
		return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 ����
	}

}
