package co.yedam.common;

import java.nio.file.FileSystemAlreadyExistsException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.reply.mapper.ReplyMapper;
import co.yedam.reply.service.ReplyVO;

public class MainExe {

	public static void main(String[] args) {
		

		SqlSession session = 
				DataSourceMybatis.getInstance().openSession(true);
		
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		 //1번 글에 대한 댓글 목록 가져오기 
		
		List <ReplyVO> list = mapper.replyList(1); //게시글 1인애들 리스트
		
		list.forEach(vo -> System.out.println(vo));
		
		
		mapper.deleteReply(2);  //댓글 번호가 2번인 애 지우기 
		System.out.println(mapper.replyList(1));
		
		
		System.out.println(mapper.selectReply(6));
		//댓글번호가 6번인애 조회하기 
		
		
		

	}///
}///