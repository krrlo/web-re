package co.yedam.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class ModifyFormControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//수정폼오픈 
		String bno = req.getParameter("bno");  //getBoard.jsp 조회화면 에서 받아온 bno 값
		//System.out.println("나와라나와라" + bno);  
		BoardService svc = new 	BoardServiceImpl();
		BoardVO vo =  svc.getBoard(Integer.parseInt(bno));  // 조회된 수정대상 객체를 가져옴 
		
		req.setAttribute("vo", vo);    //수정 대상 객체 vo를 jsp로 넘김 
		try {
			req.getRequestDispatcher("WEB-INF/board/modifyForm.jsp")
			.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	
		}
	}
}

