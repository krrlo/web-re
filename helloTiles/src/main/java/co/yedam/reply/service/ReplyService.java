package co.yedam.reply.service;

import java.util.List;
import java.util.Map;

public interface ReplyService {

	public List <ReplyVO> replyList(int boardNo , int page);
	public ReplyVO getReply(int replyNo);
	public boolean addReply (ReplyVO vo);
	public boolean editReply (ReplyVO vo);
	public boolean delReply (int replyNo);
	
	
	//댓글 건수 
	public int getTotalCnt (int boardNo);
	
	//차트데이터

	public List <Map <String , Object>> getReplyCountBywriter();
	
}
