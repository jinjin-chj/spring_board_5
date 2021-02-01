package edu.bit.emp.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class Criteria {
	
	// 페이징 처리를 위해서는 페이지 번호와, 
	// 한 페이지에 몇개의 데이터를 보여줄 것인지 결정되어야 함.
	private int pageNum;	// 페이지 번호
	private int amount;		// 한 페이지 당 몇개의 데이터를 보여줄 것인가.
	
	public Criteria() {
		this(1,5);	// 기본값 1페이지 5개로 지정 // this함수는 생성자 호출
			
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
		
}
