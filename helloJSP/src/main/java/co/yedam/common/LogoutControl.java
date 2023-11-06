package co.yedam.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
	
		
		req.getSession().invalidate(); //세션 정보를 지워주는 메소드
		
		//세션삭제후 (로그아웃후) 메인페이지로 이동하게 재 설정  세션 삭제하면 기존 어트리뷰트 다 삭제된대 ㅎㅎ 루그인한때 담아둔 정보가 삭제된대
		try {
			resp.sendRedirect("main.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
