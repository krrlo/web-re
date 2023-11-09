package co.yedam.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.reply.mapper.ReplyMapper;
import co.yedam.reply.service.ReplyVO;

public class MainExe {

	public static void main(String[] args) {
		

		SqlSession session = 
				DataSourceMybatis.getInstance().openSession(true);
		
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		
		List <ReplyVO> list = mapper.replyList(23,1); //게시글 번호 , 페이지 숫자 
		
		//list.forEach(vo -> System.out.println(vo));
		
		
		List<Map <String, Object>> map = mapper.getReplyCountBywriter();
		System.out.println(map);
		
		

	}///
}///