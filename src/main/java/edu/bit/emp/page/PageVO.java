package edu.bit.emp.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PageVO {

	private int startPage, endPage;
	private boolean prev, next;
	private int total;
	private Criteria cri;

	public PageVO(Criteria cri, int total) {

		this.startPage = this.endPage - 9;
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;

		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		if (realEnd <= this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1; // 시작번호가 1보다 큰 경우 존재
		this.next = this.endPage < realEnd;

		this.total = total;
		this.cri = cri;
	}

	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder;
		uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page)
				.queryParam("amount", cri.getAmount()).build();
		return uriComponentsBuilder.toUriString();
	}

}
