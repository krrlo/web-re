package co.yedam.board.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class AddBoardControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String title = req.getParameter("title");  //등록화면에서 입력받은 input태그들의 값이 변수에저장되어있음
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");

		BoardVO vo = new BoardVO();               		//입력받은 값으로 1건의 정보 객체 생성 
		vo.setTitle(title);                   
		vo.setContent(content);
		vo.setWriter(writer);

		
		//얘는 등록추가하면 보여지는 페이지가 boardList거나 boardForm이 나오도록 
		BoardService svc = new BoardServiceImpl();
		if (svc.addBoard(vo)) {   //잘 추가됐으면 
			try {
				resp.sendRedirect("boardList.do"); //글 저장후 목룍페이지로 이동하는경우, 특정처리후 지정한 페이지로 이동하고싶을때 사용하는 
			} catch (IOException e) {				// resp.sendRedirectresp , boardList.do가 실행되어 추가된 정보까지 나옴 
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect("boardForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}//execute

}
