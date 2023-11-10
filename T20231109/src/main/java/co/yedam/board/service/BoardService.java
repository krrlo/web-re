package co.yedam.board.service;

import java.util.List;

public interface BoardService {
	
	//전체조회 , 한건조회 , 등록, 수정, 삭제 
	
	
	public List<BoardVO> boardList();   
	public BoardVO getBoard(String prodCode);

	
	

}
