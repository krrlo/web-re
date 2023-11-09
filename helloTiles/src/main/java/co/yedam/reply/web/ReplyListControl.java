package co.yedam.reply.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Command;
import co.yedam.common.pageDTO;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyVO;
import co.yedam.reply.serviceImpl.ReplyServiceImpl;

public class ReplyListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//23번 게시글에 달린 댓글 가져오기 
		
		
		String bno = req.getParameter("bno");  //게시글 번호 
		String page = req.getParameter("page");  //몇번째 페이지 댓글 
		
		
		
		ReplyService svc = new ReplyServiceImpl();
		page = page == null ? "1" : page;  //page값이 안넘어오면 1페이지 보여주게 
		
		//페이지 계산해서 버튼을 그려주는 역할 
		//게시글 번호 / 댓글 건수 / 현재페이지
		pageDTO dto = new pageDTO(Integer.parseInt(bno),svc.getTotalCnt(Integer.parseInt(bno)),Integer.parseInt(page)); 
		//{"total":55,"currentPage":1,"next":true,"prev":false,"startPage":1,"endPage":10,"boardNo":1}}
		
		
		 //게시판번호/ 몇페이지 나오게할지
		List <ReplyVO> list = svc.replyList(Integer.parseInt(bno),Integer.parseInt(page));  
		
		
		//list, dto  getboard jsp로 둘다 넘기기 
		
		Map<String , Object> map = new HashMap<>();
		map.put("list" , list); //댓글리스트 넘기고 
		map.put("dto", dto);  //페이지 정보담긴 애도 보냄 
		
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		String json = gson.toJson(map);  //맵을 넘김 
		
		resp.setContentType("text/json;charset=utf-8");
		
		try {
			resp.getWriter().print(json);  //result에 값이 보내짐 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
