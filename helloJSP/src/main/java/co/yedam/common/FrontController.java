package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.web.BoardFormControl;
import co.yedam.board.web.BoardListControl;
import co.yedam.board.web.GetBoardControl;
import co.yedam.board.web.ModifyBoardControl;
import co.yedam.board.web.ModifyFormControl;
import co.yedam.board.web.RemoveBoardControl;
import co.yedam.board.web.RemoveFormControl;
import co.yedam.reply.web.AddReplyControl;
import co.yedam.reply.web.DelReplyControl;
import co.yedam.reply.web.ReplyListControl;
import co.yedam.board.web.AddBoardControl;

public class FrontController extends HttpServlet {
	
	
	//init - service -
	Map <String , Command> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//메인페이지.
		map.put("/main.do", new MainControl());
		//전체 게시판 목록 보여주기 
		map.put("/boardList.do", new BoardListControl());  //들어오는 url에 따라서 다른 기능이 실현되게 하려고 //얘는 목록을 보여주는 기능 
		 													// command = 인터페이스를 구현하는 구현클래스를 커맨드의 값으로 넣겠다    //  
		
		//로그인
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		//로그아웃
		map.put("/logout.do", new LogoutControl());
		
		
		//게시글 한건조회
		map.put("/getBoard.do" , new GetBoardControl());  
		
		 // 등록양식 켜기 
		map.put("/boardForm.do", new BoardFormControl()); 
		//실제 등록하기 
		map.put("/addBoard.do", new AddBoardControl());   
		
		
		 //수정양식켜기 
		map.put("/modifyForm.do", new ModifyFormControl());  
		//실제 수정하기 
		map.put("/modifyBoard.do", new ModifyBoardControl());   
		
		
		//삭제 양식 켜기
		map.put("/removeForm.do", new RemoveFormControl());  
		 //실제 삭제하기 
		map.put("/removeBoard.do", new RemoveBoardControl());  
		
		//멤버리스트 전체조회
		map.put("/memberList.do" , new MemberListControl());
		
		
		//댓글목록.
		map.put("/replyList.do", new ReplyListControl());
		//댓글등록
		map.put("/addReply.do", new AddReplyControl());
		//댓글삭제 
		map.put("/delReply.do" , new DelReplyControl());
		
		//차트그리기 
		map.put("/chartForm.do" , new ChartFormControl());  //chart.jsp로 경로재지정 //차트가 나오는 곳  
		map.put("/drawChart.do" , new DrawChartControl());   //db에서 데이터를 가져옴 
		}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {    //실제 실행됟는 서비스는 얘 
		
		//요청정보의 한글 인코딩방식. 
		req.setCharacterEncoding("UTF-8");
		
		System.out.println();
		System.out.println("frontcontroller가 실행됩니당");
		String uri = req.getRequestURI(); // 사용자가 어떤 페이지를 요청했는지  
		//>>/helloJSP/boardList.do
		String context = req.getServletContext().getContextPath();
		//>>/helloJSP
		String page = uri.substring(context.length());  //uri주소값에서 
		System.out.println("실행된주소는 "+ page);  // /boardList.do 가 들어있음 
		Command controller = map.get(page);	//ex) page에 boardList.do가 들어가있으면 new BoardListControl()가 실행되어 목록이 나오게됨 
		//Command controller = new BoardListControl(); 
		//인터페이스에 = 구현객체를 대입  구현객체에는 execute함수가 정의되어있음  
		controller.execute(req,resp);
		

	}

}
