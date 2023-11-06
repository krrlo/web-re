package co.yedam.board.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class RemoveBoardControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//리무브 폼에서 받아온 bno로 실제 삭제 진행 
		String bno = req.getParameter("bno");
		BoardService svc = new 	BoardServiceImpl();
		
		if (svc.removeBoard(Integer.parseInt(bno))) { // 삭제진행 
			try {
				resp.sendRedirect("boardList.do"); // 글 삭제가 잘 됐으면 리스트 보여라 
			} catch (IOException e) { // boardList.do가 실행되어  삭제완료된 결과를 보여줌 
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect("removeForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		

	}

}
