  package org.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yedam.service.MemberService;
import org.yedam.service.MemberVO;
import org.yedam.service.serviceImpl.MemberServiceImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/AddMemberServ.html")
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddMemberServ() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//?mid=M009&pass=9999$name=Kim&phone=010-9876-0987 너무너무 중요하대.. 웹페이지에 값을 넘기고 싶으면 이런 방식으로 넘기래 
		String mid = request.getParameter("mid");//넘긴 파라메타 담는 변수..? mid파라메타에 맵핑되어있는 값 M009 
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");    //얘로 db 한줄 생성함 
		//(mid,pass,name,phone)
		//인스턴스를 만들기위한 용도로 
		response.setCharacterEncoding("UTF-8");   //얘 추가
		response.setContentType("text/json charset=UTF-8");  //얘추가하면 네임 나옴 
		
		MemberVO vo = new MemberVO(mid, pass, name, phone);
		//위 데이터로 vo객체 하나 만듦 
		PrintWriter out = response.getWriter();  
		
		//리턴코드랑 vo 둘다 보내고 싶으면
		Map<String, Object> map = new HashMap<>();
		//key value 형식으로 보내려고 
		
		Gson gson = new GsonBuilder().create();
		//Java Object를 Json 문자열로 변환할 수 있고, Json 문자열을 Java Object로 변환할 수 있게
		String json = gson.toJson(vo);  
		//자바 객체 vo를 json형태로 변환해서 보냄 
		MemberService svc = new MemberServiceImpl();
		
		if(svc.addMember(vo)) {
			//{"retCode" : "ok"}    //정상적으로 처리되면 ok반환
			//out.print("ok");
			//out.print(json);
			map.put("code", "ok");
			map.put("vo" , vo);
		}else {
			//{"retCode" : "ng"}
			//out.print(json);
			map.put("code", "ng");     //입력한 값대로 추가가 안된다면 
			map.put("vo" , vo.getMid());  //이게콘솔에 출력되는데 responsText에 이 값이들어감?
		} 
		
		json = gson.toJson(map); //string json에  //json으로 문자열 출력하겠습니당 
		out.print(json); //map 내용을 ajax.html로 보냄 
		

	}//doget end

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
