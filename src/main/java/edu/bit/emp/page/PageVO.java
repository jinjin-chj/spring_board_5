package edu.bit.emp.page;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter

public class PageVO {
	// 페이징 처리 할 때 필요한 정보들
	private int startPage; // 화면에 보여지는 페이지 시작번호 (1...10)
	private int endPage; // 화면에 보여지는 페이지 끝번호
	private boolean prev, next; // 이전, 다음으로 이동가능한 링크 표시
	// private int displayPageCount = 10; // 이거 선언하면 아래 엔드페이지에서 대체 가능

	private int total; // 전체 글(데이터) 수
	private Criteria cri;

	public PageVO(Criteria cri, int total) {
		this.total = total;
		this.cri = cri;

		this.endPage = (int) (Math.ceil(cri.getPageNum() / 5.0)) * 5;
		// this.endPage = (int) (Math.ceil(cri.getPageNum() / displayPageCount)) * 10;

		this.startPage = this.endPage - 4;

		// Total을 통한 endPage의 재계산
		// 즉, 10개씩 보여주는 경우 전체 데이터 수가 80개라고 가정하면 끝번호는 10이 아닌 8이 됨
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		if (realEnd <= this.endPage) {
			this.endPage = realEnd;
		}

		// 시작번호가 1보다 큰 경우 존재
		this.prev = this.startPage > 1;
		// realEnd 가 끝번호(endPage)보다 큰 경우에만 존재
		this.next = this.endPage < realEnd;
	}

	public String makeQuery(int page) {
		UriComponents uriComponentsBuilder;
		uriComponentsBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page) 
				// pageNum = 3
				.queryParam("amount", cri.getAmount()) // pageNum=3&amount=10
				.build(); // ?pageNum=3&amount=10
		return uriComponentsBuilder.toUriString(); // ?pageNum=3&amount=10 리턴
	}

}
