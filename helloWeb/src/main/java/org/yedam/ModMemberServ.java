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


@WebServlet("/ModMemberServ.html")
public class ModMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ModMemberServ() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값을 ajax2.js에서 가져옴 
		String mid = request.getParameter("mid");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");     
	
		response.setCharacterEncoding("UTF-8");   
		response.setContentType("text/json charset=UTF-8"); 
		
		MemberVO vo = new MemberVO(mid, pass, name, phone);
		
		PrintWriter out = response.getWriter();  

		Map<String, Object> map = new HashMap<>();
	
		Gson gson = new GsonBuilder().create();
		
		String json = gson.toJson(vo);  
		
		MemberService svc = new MemberServiceImpl();
		if(svc.modifyMember(vo)) {
			
			map.put("code", "ok");
			map.put("vo" , vo);
		}else {
			
			map.put("code", "ng");
			map.put("vo" , vo.getMid());
		} 
		
		json = gson.toJson(map); 
		out.print(json);
		
	}//do get 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
