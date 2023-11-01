package co.yedam.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import co.yedam.student.service.StudentService;
import co.yedam.student.service.StudentVO;
import co.yedam.student.serviceImpl.StudentServiceImpl;

public class MainExe {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StudentVO vo = new StudentVO();
		vo.setStudentId("1");
		vo.setStudentName("이주은");
		vo.setStudentPassword("123");
		vo.setStudentDept("국제통상");

		try {
			vo.setStudentBirthday(sdf.parse("1994-09-17"));  //string을 date로
		} catch (ParseException e) {

			e.printStackTrace();
		}

		StudentService svc = new StudentServiceImpl();

		if (svc.editStudent(vo)) {
			System.out.println("수정했슴");
		} else {
			System.out.println("에러발생");
		}

		svc.listStudent().forEach(st -> System.out.println(st));
		/// 리스트 돌려서 뽑아내기

		System.out.println(svc.getStudent(vo.getStudentId()));

	}///
}///