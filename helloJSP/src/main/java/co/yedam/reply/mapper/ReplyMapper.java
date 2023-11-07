package co.yedam.reply.mapper;

import java.util.List;

import co.yedam.reply.service.ReplyVO;

public interface ReplyMapper {
	
	//dao mapper에서는 db에서 처리하는 용어로 쓸것 
	public List <ReplyVO> replyList(int boardNo);  //게시글 1개에 대한 댓글을 가져와야하니까
	public ReplyVO selectReply(int replyNo); //단건조회
	public int insertReply(ReplyVO vo); //등록
	public int updateReply(ReplyVO vo);  //수정
	public int deleteReply(int replyNo); //삭제
	
	
	
	
	
	
}

