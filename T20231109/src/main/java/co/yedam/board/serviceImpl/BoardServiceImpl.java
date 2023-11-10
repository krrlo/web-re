package co.yedam.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.board.mapper.BoardMapper;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;

import co.yedam.common.DataSourceMybatis;

public class BoardServiceImpl implements BoardService{

	
	//SqlSessionFactory factory = DataSourceMybatis.getInstance();  //반환해주는 
	
	SqlSession sqlSession = DataSourceMybatis.getInstance().openSession(true);  //true하면 자동 커밋하겠다는 말 
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	//인터페이스  mapper =  boardMapper.xml 
	
	
	@Override  //전체 조회
	public List<BoardVO> boardList() {    
		
		return mapper.selectList();
	}
	

	@Override  //한건 조회 
	public BoardVO getBoard(String prodCode) {
		
		return mapper.select(prodCode);
	}

	
	 
	
}
