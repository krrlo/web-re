package org.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yedam.service.MemberService;
import org.yedam.service.MemberVO;
import org.yedam.service.serviceImpl.MemberServiceImpl;


@WebServlet("/MemberListServ2")
public class MemberListServ2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemberListServ2() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	MemberService svc = new MemberServiceImpl();
	List <MemberVO> list = svc.memberList();
	System.out.println("JSON데이터 입니다");
	
	response.setContentType("text/json;charset=utf-8");  //json형식으로 
	
	PrintWriter out = response.getWriter();
	//[{"mid" : value, "pass" :value, "name" :value, "phone" :value},{},{}]
	//가지고온 list를 제이슨 형식으로 바꾸기 
	 
	String str = "[";
	int cnt = 0;
	for(MemberVO vo : list) {
		str += "{";
		str += "\"mid\":\"" + vo.getMid() + "\",";
		str += "\"pass\":\"" + vo.getPass() + "\",";
		str += "\"name\":\"" + vo.getName() + "\",";
		str += "\"phone\":\"" + vo.getPhone() + "\"";
		str += "}";
		if(++cnt != list.size()) {   //마지막이면 
			str +="," ;
		}
	}
	str += "]";
	out.print(str);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
