package co.yedam.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DataSource;
import co.yedam.student.service.StudentVO;

public class StudentDAO {

	DataSource ds = DataSource.getInstance(); // (공통)디비연결
	Connection conn; /// (공통)자바와 db연결 길 생성
	PreparedStatement psmt; // (공통)sql문 날려서 데이터를 전송
	ResultSet rs; // (select 문) ResultSet반환

	void close() { // (공통)
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close

	// 추가
	public int insert(StudentVO vo) { // (리턴타입 int) (함수이름) (추가할 객체)

		String sql = "insert into student(student_id, student_name,"
				+ "student_password, student_dept, student_birthday) " + "values (?,?,?,?,?)";
		conn = ds.getConnection(); // db연결길
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// System.out.println(sdf.format(vo.getStudentBirthday()));

		try {
			psmt = conn.prepareStatement(sql); // sql 날려서 데이터 전송 준비
			psmt.setString(1, vo.getStudentId()); // 물음표 세팅
			psmt.setString(2, vo.getStudentName());
			psmt.setString(3, vo.getStudentPassword());
			psmt.setString(4, vo.getStudentDept());
			psmt.setString(5, sdf.format(vo.getStudentBirthday())); // vo의 값을 문자열로 변환 // date > string :sdf.format()
			int r = psmt.executeUpdate(); // 성공했으면 1을 반환함
			return r; // return 1
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리된 건수가 없음 : 에러 났다는 뜻
	}

	// 업데이트
	public int update(StudentVO vo) { // (리턴타입 int) (함수이름) (수정할 객체)
		
		String sql = "update student set student_name = ?,"
				+ "student_password = ?, student_dept = nvl(?, student_dept), student_birthday = ?"
				+ "where student_id = ?";
		conn = ds.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(5, vo.getStudentId());
			psmt.setString(1, vo.getStudentName());
			psmt.setString(2, vo.getStudentPassword());
			psmt.setString(3, vo.getStudentDept());
			psmt.setString(4, sdf.format(vo.getStudentBirthday())); // vo의 값을 문자열로 변환
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리된 건수가 없음 : 에러 났다는 뜻
	}

	// 삭제 : delete
	public int delete(String sid) {// (리턴타입 int) (함수이름) (삭제할 아이디)
		
		String sql = "delete from student where student_id = ?";
		conn = ds.getConnection();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sid);
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리된 건수가 없음 : 에러 났다는 뜻
	}

	// 전체목록 :list

	public List<StudentVO> list() {	//(리턴타입 : list) (함수이름) (매개값 없음)
	
		String sql = "select *from student";
		conn = ds.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<StudentVO> list = new ArrayList<>();
		StudentVO vo;
				
		
		try {
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new StudentVO();
				vo.setStudentId(rs.getString("student_id"));
				vo.setStudentName(rs.getString("student_name"));
				vo.setStudentPassword(rs.getString("student_password"));
				vo.setStudentDept(rs.getString("student_dept"));
				vo.setStudentBirthday(rs.getDate("student_birthday"));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 조회 :select 한건조회

	public StudentVO select(String sid) {

		String sql = "select *from student where student_id=? ";
		conn = ds.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		StudentVO vo = null; // 초기화 해줘야함
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sid);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				vo = new StudentVO();
				vo.setStudentId(rs.getString("student_id"));
				vo.setStudentName(rs.getString("student_name"));
				vo.setStudentPassword(rs.getString("student_password"));
				vo.setStudentDept(rs.getString("student_dept"));
				vo.setStudentBirthday(rs.getDate("student_birthday"));
			}
			rs.close();   //이거안써도 되나..?
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

}// 클래스
