package co.yedam.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;

public class BoardFormCntrol implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			try {
				req.getRequestDispatcher("WEB-INF/board/boardForm.jsp").forward(req, resp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ServletException e) {

			e.printStackTrace();

		}

	}
}