package co.yedam.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Command;

public class BoardFormControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		// 로그인 안했으면 등록화면 못가게 , 로그인 정보가 없으면 로그인 화면으로 가게하고
		if (session.getAttribute("logId") == null) {
			try {
				resp.sendRedirect("loginForm.do");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try { //// jsp가 보여질수있도록 요청 재지정 //로그인했으면 등록화면 넘어가게
				req.getRequestDispatcher("WEB-INF/board/boardForm.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//execute
}
