package edu.bit.emp.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class Criteria {

	private int pageNum, amount;

	public Criteria() {
		this(1,10);
		
	}
	public Criteria(int pageNum, int amount) {
		
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
