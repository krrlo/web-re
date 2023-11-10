package co.yedam.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.board.service.BoardVO;


public interface BoardMapper {
	
	public List <BoardVO> selectList();
	public BoardVO select (String prodCode);
	
	
}

