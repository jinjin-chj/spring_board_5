package edu.bit.board.mapper;

import java.util.List;

import edu.bit.board.vo.BoardVO;

public interface BoardMapper { // dao�κ� - ���۷� ��� (�ż���. ���� ���̹�Ƽ�� ��)
	// dao mapper�κ��� �ٽ��̴�.

	public List<BoardVO> getList();

	public void insertBoard(BoardVO boardVO);

	public BoardVO id(int getbId);


}