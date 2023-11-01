package co.yedam.student.serviceImpl;

import java.util.List;

import co.yedam.student.service.StudentService;
import co.yedam.student.service.StudentVO;

public class StudentServiceImpl implements StudentService {
	StudentDAO dao = new StudentDAO();

	@Override // 추가
	public boolean addStudent(StudentVO vo) {

		return dao.insert(vo) == 1; // true라는 말 
	}

	@Override // 업데이트
	public boolean editStudent(StudentVO vo) {

		return dao.update(vo) == 1;
	}

	@Override // 삭제
	public boolean removeStudent(String sid) {

		return dao.delete(sid) == 1;
	}

	@Override // 전체조회
	public List<StudentVO> listStudent() {

		return dao.list();
	}

	@Override // 선택조회
	public StudentVO getStudent(String sid) {

		return dao.select(sid);
	}

}
