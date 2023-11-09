package co.yedam.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.board.mapper.BoardMapper;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.service.MemberVO;
import co.yedam.common.DataSourceMybatis;

public class BoardServiceImpl implements BoardService{

	
	//SqlSessionFactory factory = DataSourceMybatis.getInstance();  //반환해주는 
	
	SqlSession sqlSession = DataSourceMybatis.getInstance().openSession(true);  //true하면 자동 커밋하겠다는 말 
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	//인터페이스  mapper =  boardMapper.xml 
	
	
	@Override  //전체 조회
	public List<BoardVO> boardList() {    
		
		//return dao.selectList();
		return mapper.selectList();
	}
	

	@Override  //한건 조회 
	public BoardVO getBoard(int boardNo) {
		//dao.updateCnt(boardNo);   //조회수도 하나 올려주고 
		//return dao.select(boardNo);  //걔 보여라 
		
		mapper.updateCnt(boardNo);
		return mapper.select(boardNo);
	}

	@Override  //추가
	public boolean addBoard(BoardVO vo) {
		
	   return mapper.insert(vo) == 1;
	}

	@Override //수정 
	public boolean edietBoard(BoardVO vo) {
		
		return mapper.update(vo) == 1;
	}

	@Override //삭제
	public boolean removeBoard(int boardNo) {
		
		return mapper.delete(boardNo) == 1; 
	}

	@Override  //로그인체크
	public MemberVO loginCheck(String id, String pw) {
		
		return mapper.getUser(id, pw);
	}

	@Override  //전체멤버조회
	public List <MemberVO> memberList() {
		
		return mapper.memberList();
	}

	
	
	
	 
	
}
