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
		
		
		String path = "board/getBoard.tiles";
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = svc.getBoard(bno);
	
		System.out.println(vo);
		req.setAttribute("bno", vo); 
		
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		}  catch (Exception e) {
			
			e.printStackTrace();
		}

		
	}//

}
