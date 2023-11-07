package co.yedam.reply.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Command;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyVO;
import co.yedam.reply.serviceImpl.ReplyServiceImpl;

public class ReplyListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//23번 게시글에 달린 댓글 가져오기 
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		List <ReplyVO> list = svc.replyList(Integer.parseInt(bno));  //보드 넘버가 23인 애들의 댓글 목록 가져옴 
		
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		String json = gson.toJson(list);
		resp.setContentType("text/json;charset=utf-8");
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
