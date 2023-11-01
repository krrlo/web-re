package co.yedam.student.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.student.service.StudentService;
import co.yedam.student.service.StudentVO;
import co.yedam.student.serviceImpl.StudentServiceImpl;

@WebServlet("/studentList.do")

public class StudentListServlet extends HttpServlet{

	//생명주기 init -> service - > destroy 
	
	public StudentListServlet() {   //생성자 
		 System.out.println("생성자 콜");
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	  System.out.println("init call");
		
	}
	
					
	@Override           ///클라이언트 요청 정보가 req에 저장이됨    // resp 객체를 클라이언트에게 전송 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> enumer = req.getHeaderNames();
		while(enumer.hasMoreElements()) {
			String header = enumer.nextElement();
			String val = req.getHeader(header);        //헤더 정보를 넘긴데 대체 뭔소린지 진짜 ㅅ4ㅂ삳ㅈ ;ㅂㄹ시발 조니 ㄹ
			System.out.println(header +':' +val);
		}
		
		//studnetList.do?name=Hong&age=20 이라고 하면 .... 
		String name = req.getParameter("name");   //name에있는 파라메터 값을 ==클라이언트가 입력한 정보를 읽어서 저장 
		String age = req.getParameter("age");
		System.out.println(name);
		System.out.println(age);
		
		//응답정보의 컨텐트 타입, 인코딩처리 지정 
		resp.setCharacterEncoding("utf-8");  //응답정보에 한글이 포함되어있으면 
		resp.setContentType("text/json;charset=utf-8");  //한글파일 깨지니까 지정 / 제이슨포맷이고 /utf-8입니다..
		
		
		//학생정보 자바객체로 가져옴 
		StudentService svc = new StudentServiceImpl();
		List<StudentVO> list = svc.listStudent();
		
		
		//자바객체를 json 문자열로 바꿀래 
		Gson gson = new GsonBuilder().create();
		String json =gson.toJson(list);
		
		PrintWriter out = resp.getWriter();   //resp에 응답정보가 있음 
		out.println(json);
		
	}////
	
	
	@Override
	public void destroy() {
		System.out.println("destroy");
		
	}
	
}
