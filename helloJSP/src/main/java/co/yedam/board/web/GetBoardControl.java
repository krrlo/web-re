package co.yedam.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;


public class GetBoardControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// boardNo:1 = DB search => jsp.
		String bno = req.getParameter("bno");   //boardList화면에서 받아온 값  "getBoard.do?bno=<%=vo.getBoardNo()%> 
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno)); // db에서 조회

		req.setAttribute("bno", vo); // jsp에 조회된 한건의 vo를 전달 

		// 요청재지정. jsp 페이지로 이동하게끔 
		try {
			req.getRequestDispatcher("WEB-INF/board/getBoard.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//execute함수 

} 
