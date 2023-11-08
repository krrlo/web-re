package co.yedam.reply.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Command;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.serviceImpl.ReplyServiceImpl;

public class DelReplyControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
//	
//		//맵 객체 사용하면 제이슨 타입으로 안하고 보낼수있음 
//		//Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		
//		//Map<String, Object> map = new HashMap<>();
//		
//		//if(svc.delReply(vo)) {
//			map.put("code", "ok");
//			map.put("vo" , vo);
//		}else {
//			map.put("code", "ng");
//		}
//
//		resp.setContentType("text/json;charset=utf-8");
//		
//		try {
//			resp.getWriter().print(gson.toJson(map));  //얘가 출력되는거 
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
//		
		
			
		
		if(svc.delReply(Integer.parseInt(rno))) {
			try {
				resp.getWriter().print("{\"retCode\" : \"OK\"}");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {
			try {
				resp.getWriter().print("{\"retCode\" : \"NG\"}");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
			
	}//execute

}
