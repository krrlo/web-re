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

@WebServlet("/MemberListServ")
public class MemberListServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
    public MemberListServ() {
        super();
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//웹에 출력하기 위해서 HttpServletRequest = 입력 도구   HttpServletResponse = 출력 도구
	
	MemberService svc = new MemberServiceImpl();   //인터페이스
	List <MemberVO> list = svc.memberList();  //멤버 리스트 불러옴 
	System.out.println(list);  //가져온 데이터 콘솔에 출력 
	
	response.setContentType("text/xml;charset=utf-8");  //xml이 utf-8형식이라는 것을 서버가 브라우저에게 알리는것 
	
	PrintWriter out = response.getWriter(); //출력 도구용 출력스트림에 텍스트 보낼거임  아래는 보낼 내용 
	
	String str = "<dataset>";
	for(MemberVO vo : list) {           //db로 가져온 데이터를 xml형식으로 바꿈   
		str += "<record>";
		str += "<mid>" + vo.getMid() + "</mid>";
		str += "<pass>" + vo.getPass() + "</pass>";
		str += "<name>" + vo.getName() + "</name>";
		str += "<phone>" + vo.getPhone() + "</phone>";
		str += "</record>";
	}//포 
	str += "</dataset>";
	out.print(str);   //출력스트림에 (str변수에 담긴 내용 보냄) 
	}  //doGet
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}///end
