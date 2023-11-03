package co.yedam.board.serviceImpl;

import java.util.List;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;

public class BoardServiceImpl implements BoardService{

	BoardDAO dao = new BoardDAO ();
	
	
	@Override
	public List<BoardVO> boardList() {
		
		return dao.selectList();
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		dao.updateCnt(boardNo);   //조회수도 하나 올려주고 
		return dao.select(boardNo);  //걔 보여라 
	}

	@Override
	public boolean addBoard(BoardVO vo) {
		
	   return dao.insert(vo) == 1;
	}

	@Override
	public boolean edietBoard(BoardVO vo) {
		
		return dao.update(vo) ==1;
	}

	@Override
	public boolean removeBoard(int boardNo) {
		
		return dao.delete(boardNo) ==1; 
	}

}
