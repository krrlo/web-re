package co.yedam.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.MemberVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;

public class LoginControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 실제로그인이 이루어지는곳
		// 로그인창에시 입력받은 아이디 패스워드 받아오기
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		// requedst는 계속 값이 변하는데 //캐시값을 지우지 않는 한 고유한값을 계속 유지하고있음
		// 세션은 값을 유지한대 ; 로그인 했던 아이디 값을 담아놓는대..

		BoardService svc = new BoardServiceImpl();
		MemberVO vo = svc.loginCheck(id, pass); // 그 아이디 패스워드를 가지고있는 vo하나 받아옴

		if (vo != null) { // id, pass가 맞으면 게시판 목록이나오게 하기

			HttpSession session = req.getSession(); // session 객체 생성
			session.setAttribute("logId", id); // 로그인한 아이디 담아놓음
			session.setAttribute("re", vo.getResponsbility()); // 권한 담아놓기

			try {
				resp.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else { // 로그인 아이디 패스워드 안맞으면 다시 로그인 폼 보이게
			try {
				resp.sendRedirect("loginForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// execute

}
