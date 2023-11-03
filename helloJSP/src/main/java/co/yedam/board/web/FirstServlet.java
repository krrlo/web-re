package co.yedam.board.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/FirstServlet.do")
public class FirstServlet extends HttpServlet {
	
	//init > service > destroy   //최초일때만 init이 실행되도록 톰캣이 지정해놓음   //  서비스 있으면 서비스가 실행됨 
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		super();

	}
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서비스실행");   //서비스가 있으면 밑에 doget이 실행되지않고 service만 실행됨 
		doGet(req, resp);  //doget을 실행하겠습니다 
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8"); // 응답정보에 한글이 포함되어있으면

		String name = "홍길동";
		int age = 20;
		for (int i = 1; i < 5; i++) {
			response.getWriter().print("<p>" + i + "번째 이름은 " + name + "나이는" + age); // p태그 써서 여기서 html을 바로 써서 화면에 출력 가능
																					// 불편해 ㅠ
		}

	}//

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}//

}
