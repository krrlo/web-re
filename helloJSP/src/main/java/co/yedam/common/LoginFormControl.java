package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFormControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
	
		
		
		String path = "WEB-INF/main/loginForm.jsp";
		//loginform.jsp 로그인 할수있는 페이지 열리도록 경로 재지정 
		
		
		try {    //loginform.jsp 열어라 
			req.getRequestDispatcher(path).forward(req,resp);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
	}

}
