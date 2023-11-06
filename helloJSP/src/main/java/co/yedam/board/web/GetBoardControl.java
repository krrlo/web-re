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
		//제목  눌러서 게시글  조회하는 기능  
		
		String bno = req.getParameter("bno");   //boardList화면에서 제목클릭해서 받아온 값  "getBoard.do?bno=<%=vo.getBoardNo()%> 
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno)); // db에서 bno조회해서 객체 한줄 가져옴 

		req.setAttribute("bno", vo); // jsp에 조회된 한건의 vo를 전달 

		// 요청재지정. jsp 페이지로 이동하게끔 
		try {
			req.getRequestDispatcher("WEB-INF/board/getBoard.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//execute함수 

} 
