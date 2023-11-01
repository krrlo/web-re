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

	DataSource ds = DataSource.getInstance();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	void close() {
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
	}

	
	// 추가
	public int insert(StudentVO vo) {
		String sql = "insert into student(student_id ,student_name,"
				+ "student_password,student_dept,student_birthday) " + "values (?,?,?,?,?)";
		
		conn = ds.getConnection(); //연결 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//System.out.println(sdf.format(vo.getStudentBirthday()));
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			psmt.setString(2, vo.getStudentName());
			psmt.setString(3, vo.getStudentPassword());
			psmt.setString(4, vo.getStudentDept());
			psmt.setString(5, sdf.format(vo.getStudentBirthday())); // vo의 값을 문자열로 변환   // date > string :sdf.format()
			int r = psmt.executeUpdate();  //성공했으면 1을 반환함 
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리된 건수가 없음 : 에러 났다는 뜻
	}

	// 업데이트
	public int update(StudentVO vo) {
		String sql = "update student set student_name = ?,"
				+ "student_password =? , student_dept =? ,student_birthday=?" + "where student_id = ?";

		conn = ds.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		System.err.println(sdf.format(vo.getStudentBirthday()));
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
	public int delete(String sid) {
		String sql = "DELETE FROM student WHERE student_id = ?";

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

	public List<StudentVO> list() {
		List<StudentVO> list = new ArrayList<>();
		StudentVO vo;
		String sql = "SELECT *FROM student";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		conn = ds.getConnection();
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

		StudentVO vo = null; // 초기화 해줘야함 
		String sql = "SELECT *FROM student where student_id=? ";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		conn = ds.getConnection();
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
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

}// 클래스
