package co.yedam.student.serviceImpl;

import java.util.List;

import co.yedam.student.service.StudentService;
import co.yedam.student.service.StudentVO;

public class StudentServiceImpl implements StudentService {
	StudentDAO dao = new StudentDAO();

	@Override // 추가
	public boolean addStudent(StudentVO vo) {  // (리턴타입:true false 반환하니까 boolean타입) (함수이름) (추가할 객체) 

		return dao.insert(vo) == 1; // 			//vo 객체가 넘어가야하고 함수 실행후 결과가 1이라면 정상처리되어 true 반환     
	}

	@Override // 업데이트
	public boolean editStudent(StudentVO vo) {    //(리턴타입:true false 반환하니까 boolean타입) (함수이름) (수정된 객체) 

		return dao.update(vo) == 1;   			//vo 객체가 넘어가야하고 함수 실행후 결과가 1이라면 정상처리되어 true 반환    
	}

	@Override // 삭제
	public boolean removeStudent(String sid) {  	 //(리턴타입:true false 반환하니까 boolean타입) (함수이름) (삭제할 학생 아이디) 

		return dao.delete(sid) == 1;			// 삭제할 아이디가 넘어가야하고 함수 실행후 결과가 1이라면 정상처리되어 true 반환  
	}

	@Override // 전체조회
	public List<StudentVO> listStudent() {			//(리턴타입:List타입)  (함수이름) (매개값없음)

		return dao.list();							//전체 조회된 리스트 전체를 반환 
	}

	@Override // 선택조회
	public StudentVO getStudent(String sid) {		//(리턴타입:StudentVO 객체를 리턴)  (함수이름) (조회할 학생 아이디 )

		return dao.select(sid);						//조회된 학생 한명객체 1개 반환 
	}

}
