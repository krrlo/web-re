package co.yedam.board.web;

import java.util.List;

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
		BoardVO vo = svc.getBoard(bno);  //해당
		List <BoardVO> rlist = svc.relatedList();  //관련
		
		
		
		req.setAttribute("rlist", rlist); 
		req.setAttribute("bno", vo); 
		
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		}  catch (Exception e) {
			
			e.printStackTrace();
		}

		
	}//

}
