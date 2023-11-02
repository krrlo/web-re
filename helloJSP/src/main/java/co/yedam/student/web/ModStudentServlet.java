package co.yedam.student.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

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

@WebServlet("/editStudent.do")

public class ModStudentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 사용자 요청정보에 한글이 포함되어있다면
		resp.setContentType("utf-8"); //  응답정보에 한글이 포함되어있으면
		resp.setCharacterEncoding("utf-8");  
		
		String sid = req.getParameter("id"); // 서블릿에서 불러와서 변수에 저장
		String pw = req.getParameter("password");
		String sname = req.getParameter("name");
		String birth = req.getParameter("birthday");

		StudentVO vo = new StudentVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		vo.setStudentId(sid); // 받은 값으로 객체 만들어서
		vo.setStudentName(sname);
		vo.setStudentPassword(pw);
		try {
			vo.setStudentBirthday(sdf.parse(birth));
		} catch (ParseException e) {

			e.printStackTrace();
		}

		// System.out.println("ddd"+ sid);
		// System.out.println(pw);
		// System.out.println(sname);
		// System.out.println(birth);

		PrintWriter out = resp.getWriter(); // resp에 응답정보가 있음

		StudentService svc = new StudentServiceImpl();

		Map<String, Object> map = new HashMap<>();

		if (svc.editStudent(vo)) {
			map.put("retCode", "OK");
			map.put("vo", vo);

		} else {
			map.put("retCode", "NG");
			map.put("vo", vo);

		}

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json = gson.toJson(map); // 자바 맵을 제이슨 타입으로 바꿈
		out.print(json); // 제이슨에는 retcode랑 수정된vo객체가 들어가있음

	}

}
