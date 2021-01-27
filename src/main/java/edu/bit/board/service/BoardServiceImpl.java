package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService { // 자손이 구현

	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList(); 
	}
	
	@Override
	public void writeBoard(BoardVO boardVO) {
	
		mapper.insertBoard(boardVO); 
	}

	@Override
	public BoardVO get(int getbId) {
	
		return mapper.id(getbId);
	}

}