package co.yedam.reply.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Command;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyVO;
import co.yedam.reply.serviceImpl.ReplyServiceImpl;

public class AddReplyControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//내가 댓글 등록한 페이지의 bno와, 작성자, 댓글내용을 가져옴 
		
		String bno = req.getParameter("bno");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");
		
		ReplyService svc = new ReplyServiceImpl();
		
		ReplyVO vo = new ReplyVO();
		
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setReply(reply);
		vo.setReplyer(replyer);
		vo.setReplyDate(new Date());
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		Map<String, Object> map = new HashMap<>();
		
		if(svc.addReply(vo)) {
			map.put("code", "ok");
			map.put("vo" , vo);
		}else {
			map.put("code", "ng");
		}

		resp.setContentType("text/json;charset=utf-8");
		
		try {
			resp.getWriter().print(gson.toJson(map));  //얘가 출력되는거 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//http://localhost:8080/helloJSP/addReply.do?bno=23&replyer=user01&reply=%ED%85%8C%EC%8A%A4%ED%8A%B8%EC%A4%91%EC%9E%85%EB%8B%88%EB%8B%A4
		
	}//execute

}
