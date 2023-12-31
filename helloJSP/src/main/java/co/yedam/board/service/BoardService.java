package co.yedam.board.service;

import java.util.List;

public interface BoardService {
	
	//전체조회 , 한건조회 , 등록, 수정, 삭제 
	
	
	public List<BoardVO> boardList();   
	public BoardVO getBoard(int boardNo);
	public boolean addBoard(BoardVO vo);
	public boolean edietBoard(BoardVO vo);
	public boolean removeBoard(int boardNo);
	
	
	//로그인처리
	public MemberVO loginCheck(String id, String pw);
	
	//전체 멤버 조회 
	public List <MemberVO> memberList();


}
