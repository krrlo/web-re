package co.yedam.student.service;

import java.util.List;

public interface StudentService {
		
	
	public boolean addStudent(StudentVO vo);      //등록
	public boolean editStudent(StudentVO vo);     //수정
	public boolean removeStudent(String sid);     //한건삭제
	public List <StudentVO> listStudent();  	//전체조회
	public StudentVO getStudent(String sid); 	//한건조회
	
	
}
