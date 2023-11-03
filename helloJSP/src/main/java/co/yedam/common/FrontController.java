package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.web.BoardFormCntrol;
import co.yedam.board.web.GetBoardControl;
import co.yedam.board.web.addBoardControl;

public class FrontController extends HttpServlet {
	
	
	//init - service -
	Map <String , Command> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());  //들어오는 url에 따라서 다른 기능이 실현되게 하려고 //얘는 목록을 보여주는 기능 
		//map.put("/FirstServlet.do" , new FirstControl()); // command = 인터페이스를 구현하는 구현클래스를 커맨드의 값으로 넣겠다    //  
		//map.put("/second.do" , new SecondControl());   //
		map.put("/getBoard.do" , new GetBoardControl());
		map.put("/boardForm.do", new BoardFormCntrol());
		map.put("/addBoard.do", new addBoardControl());
		}
	
	//http://localhost:8080/helloJSP/boardList.do 이거 여기서 쳐야 나온대 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {    //실제 실행됟는 서비스는 얘 
		System.out.println("front");
		String uri = req.getRequestURI(); // 사용자가 어떤 페이지를 요청했는지 //http://localhost:800/helloJSP/??.do //helloJSP/??.do 가
											// uri값임 ??의 값을 지금 가져와야함 페이지열려면
		String context = req.getServletContext().getContextPath(); // contxtx 에는 helloJSP
		String page = uri.substring(context.length());
		System.out.println(page);  // second.do 
		
		Command controller =map.get(page);	//page 는 키 값 
		controller.execute(req,resp);
		
		
		
//		if(page.equals("/second.do")) {
//		
//		}else if(page.equals("FirstServlet.do")) {
//			
//		}
	}

}
