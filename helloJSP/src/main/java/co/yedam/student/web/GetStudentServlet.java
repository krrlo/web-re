package co.yedam.student.web;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/getStudent.do")

public class GetStudentServlet  extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentVO vo;
		String sid =req.getParameter("id"); 
		
		System.out.println(sid);
		
		resp.setCharacterEncoding("utf-8");  
		resp.setContentType("text/json;charset=utf-8");
		
		StudentService svc = new StudentServiceImpl();
		
		vo = svc.getStudent(sid);   //vo를 다시 리턴받음 
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json =gson.toJson(vo);  //제이슨 타입으로 변경 
		
		
		PrintWriter out = resp.getWriter();   //resp에 응답정보가 있음 
		out.print(json);  //json을  html로 보냄 
			
	}
	
}
