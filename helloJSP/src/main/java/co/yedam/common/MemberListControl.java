package co.yedam.common;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.MemberVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;

public class MemberListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
	
		BoardService svc = new BoardServiceImpl();
		List <MemberVO> list =  svc.memberList(); //리스트가져옴 
		
		req.setAttribute("list", list);   //리스트 담기 
		
		
		// 열어줄 jsp지정 
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/memberList.jsp"); 
		try {
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
				
		

	}

}
