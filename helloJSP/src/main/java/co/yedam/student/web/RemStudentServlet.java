package co.yedam.student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.student.service.StudentService;
import co.yedam.student.serviceImpl.StudentServiceImpl;

@WebServlet({"/RemStudentServlet.do","/delStudent.do"})  //두가지 방버으로 주소 쳐도된대..하 ㅅ
public class RemStudentServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid =req.getParameter("sid");  //html에서 받아온아이디값으로 삭제함
		StudentService svc = new StudentServiceImpl();
		if(svc.removeStudent(sid)) {
			resp.getWriter().print("{\"retCode\" : \"OK\"}");  //정상적으로 삭제가되면.. do?sid=hong
		} else {                         //제이슨타입 으로 html로 보냄 
			resp.getWriter().print("{\"retCode\" : \"NG\"}");  //아니면..
		}
		 
		
	}

}
