package co.yedam.board.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class ModifyBoardControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		BoardVO vo ;
		//실제 수정 이루어지는 
		//modifyfrom에서 가져온 수정된 값으로 vo객체 만들기 
		String bno = req.getParameter("bno");
		//System.out.println("dddd" + bno);
		String title = req.getParameter("title"); 
		String content = req.getParameter("content");

		vo = new BoardVO(); 
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setTitle(title);
		vo.setContent(content);

	
		BoardService svc = new BoardServiceImpl();
		if (svc.edietBoard(vo)) { // 수정된애로 업데이트 
			try {
				resp.sendRedirect("boardList.do");   //수정추가 완료되면 boardlist.do 보이게 
			} catch (IOException e) { 
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect("modifyForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// execute

}
