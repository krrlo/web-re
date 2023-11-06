package co.yedam.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class RemoveFormControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//조회화면에서 삭제버튼 누르면  삭제할 bno가 넘어옴 
		String bno = req.getParameter("bno");
		
		BoardService svc = new 	BoardServiceImpl();
		BoardVO vo =  svc.getBoard(Integer.parseInt(bno));  //삭제할 bno을 넣어주면  vo 객체 하나 데려옴 
		req.setAttribute("vo", vo); 						//삭제대상 vo를 넘겨주고 
		try {
			req.getRequestDispatcher("WEB-INF/board/removeForm.jsp")
			.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
		

	}


