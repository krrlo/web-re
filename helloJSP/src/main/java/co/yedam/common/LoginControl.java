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

		//폼에서 입력받은 아이디 패스워드 조회하기 
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
	
		//requedst는 계속 값이 변하는데  //캐시값을 지우지 않는 한 고유한값을 계속 유지하고있음 
		//세션은 값을 유지한대 ; 로그인 했던 아이디 값을 담아놓는대.. 
		
		
		
		
		BoardService svc = new BoardServiceImpl();
		MemberVO vo = svc.loginCheck(id, pass);
		
		if(vo != null) {   //id, pass가 맞으면 
			
			HttpSession session = req.getSession();  //session 객체 생성 
			session.setAttribute("logId", id);  //로그인한 아이디 담아놓음 
			session.setAttribute("re", vo.getResponsbility()); 
			
			try {
				resp.sendRedirect("boardList.do");     //보드리스트로 이동하게 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				resp.sendRedirect("loginForm.do");     
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}//execute
	
	
}
