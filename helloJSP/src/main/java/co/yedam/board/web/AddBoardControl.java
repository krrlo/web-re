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

public class AddBoardControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		BoardVO vo = new BoardVO();

		if (req.getMethod().equals("GET")) {

			String title = req.getParameter("title"); // 등록화면에서 입력받은 input태그들의 값이 변수에저장되어있음
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");

			vo = new BoardVO(); // 입력받은 값으로 1건의 정보 객체 생성
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);

			// 얘는 등록추가하면 보여지는 페이지가 boardList거나 boardForm이 나오도록

		} else if (req.getMethod().equals("POST")) { // 이미지 파일 업로드
			String saveDir = req.getServletContext().getRealPath("images");
			int size = 5 * 1024 * 1024;
			// MultipartRequest mr;
			try {
				MultipartRequest mr = new MultipartRequest(req, // 요청정보
						saveDir, // 저장경로
						size, // 최대 업로드 크기
						"UTF-8", // 인코딩방식
						new DefaultFileRenamePolicy()// 리네임정책
				);
				String title = mr.getParameter("title");      //boardForm에서 보낸 값들을 읽어옴 
				String writer = mr.getParameter("writer");
				String content = mr.getParameter("content");
				String img = mr.getFilesystemName("img");

				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);
				vo.setImage(img);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}//else if 

		BoardService svc = new BoardServiceImpl();
		if (svc.addBoard(vo)) { // 잘 추가됐으면
			try {
				resp.sendRedirect("boardList.do"); // 글 저장후 목룍페이지로 이동하는경우, 특정처리후 지정한 페이지로 이동하고싶을때 사용하는
			} catch (IOException e) { // resp.sendRedirectresp , boardList.do가 실행되어 추가된 정보까지 나옴
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect("boardForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

			
		
	}// execute

}
