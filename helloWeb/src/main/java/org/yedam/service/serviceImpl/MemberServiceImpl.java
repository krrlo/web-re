package org.yedam.service.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yedam.common.DataSource;
import org.yedam.service.MemberService;
import org.yedam.service.MemberVO;

public class MemberServiceImpl implements MemberService {

	private DataSource dao = DataSource.getInstance();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	@Override // 멤버 전체 조회 메소드
	public List<MemberVO> memberList() {

		List<MemberVO> list = new ArrayList<>();
		MemberVO vo;
		String sql = "SELECT *FROM MEMBER";

		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				vo.setMid(rs.getString("mid"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
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

	
	
	@Override // 멤버추가메소드
	public boolean addMember(MemberVO vo) {
		String sql = "insert into member values(? , ? , ? , ?)";
		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getPhone());
			int r = psmt.executeUpdate(); // 데이터가 처리된 건수를 반환함
			if (r == 1) {
				return true; // 정상처리됐으면 true
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return false;
	}
//////////
	private void close() {

		try {
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
////////

    //멤버 수정 메소드 
	@Override
	public boolean modifyMember(MemberVO vo) {
		
		String sql = "UPDATE MEMBER SET PASS = ?,"
				+ "NAME = ? , PHONE = ? "
				+ "WHERE MID = ?";
		
		conn = dao.getConnection();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(4, vo.getMid());
			psmt.setString(1, vo.getPass());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPhone());
			int r = psmt.executeUpdate(); // 데이터가 처리된 건수를 반환함
			if (r == 1) {
				return true; // 정상처리됐으면 true
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return false;
	}
		

	
	
	
	
}// end
