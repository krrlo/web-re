package co.yedam.student.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.student.service.StudentService;
import co.yedam.student.service.StudentVO;
import co.yedam.student.serviceImpl.StudentServiceImpl;

@WebServlet("/addStudent.do")

public class AddStudentServlet extends HttpServlet{
		//생명주기 init -> service - > destroy 
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//html에서 가져온 값으로 vo 만들기 
		
		//한글처리
		req.setCharacterEncoding("utf-8");  //요청정보에 한글이 포함되어있다면   //post방식에서 한글 처리 할때 
		
		String sid =req.getParameter("id");       
		String sname =req.getParameter("name");
		String pw =req.getParameter("password");
		String sdept =req.getParameter("dept");
		String birth =req.getParameter("birthday");
		
		
		StudentVO vo = new StudentVO();
		
		//System.out.println(birth);오류나서 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		vo.setStudentId(sid);
		vo.setStudentName(sname);
		vo.setStudentPassword(pw);
		vo.setStudentDept(sdept);
		try {
			vo.setStudentBirthday(sdf.parse(birth));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		StudentService svc = new StudentServiceImpl();
		
		if(svc.addStudent(vo)) {
			resp.getWriter().print("{\"retCode\" : \"OK\"}");  
		} else {                      
			resp.getWriter().print("{\"retCode\" : \"NG\"}"); 
		}
		
		
	}
}
