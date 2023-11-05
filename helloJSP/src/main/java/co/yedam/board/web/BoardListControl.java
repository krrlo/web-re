package co.yedam.board.web;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class BoardListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 서블릿, jsp (서블릿은 데이터 처리하는 컨트롤 역할 , jsp에서 보여줄거임 )
		
		BoardService svc = new BoardServiceImpl();
		List <BoardVO> list = svc.boardList();
		
		req.setAttribute("list", list);  //목록가져오는 list를 요청정보에 담아서 board/boardList.jsp로 전송 
		
		
		//페이지 요청이 들어오면 boardList.do를 요청했는데  > 요청 재 지정 (board/boardList.jsp) 이 jsp페이지가 보이도록  
		//http://localhost:8080/helloJSP/boardList.do 얘하면 >>jsp가나오게 
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/boardList.jsp"); // 서블릿에서 다른페이지로 이동할 정보를 넘어주고
		try {
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//execute함수 

}//
