package co.yedam.reply.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.reply.service.ReplyVO;

public interface ReplyMapper {
	
	//dao mapper에서는 db에서 처리하는 용어로 쓸것 
	public List <ReplyVO> replyList(@Param ("boardNo") int boardNo , @Param("page") int page);  //EX) 1번 게시글의 1페이지 데이터 가져오기 
	public ReplyVO selectReply(int replyNo); //단건조회
	public int insertReply(ReplyVO vo); //등록
	public int updateReply(ReplyVO vo);  //수정
	public int deleteReply(int replyNo); //삭제
	
	public int getTotalCnt (int boardNo); // 게시글에 달린 댓글 갯수 
	
	
	public List <Map <String , Object>> getReplyCountBywriter();
	
	
	
	
}

