package co.yedam.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.service.BoardVO;
import co.yedam.board.service.MemberVO;
import co.yedam.common.DataSource;

public class BoardDAO {

	// 전체조회 , 한건조회 , 등록, 수정, 삭제

	DataSource ds = DataSource.getInstance();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

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

	// 전체조회
	public List<BoardVO> selectList() {

		sql = "select *from board";
		conn = ds.getConnection();

		List<BoardVO> list = new ArrayList<>();
		BoardVO vo;

		try {
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getDate("writer_Date"));
				vo.setViewCnt(rs.getInt("view_cnt"));
				vo.setImage(rs.getString("image"));
				vo.setLastUpdate(rs.getDate("last_update"));
				list.add(vo);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 한건조회
	public BoardVO select(int boardNo) {

		String sql = "select *from board where board_no= ?";
		conn = ds.getConnection();

		BoardVO vo = null; // 초기화 해줘야함

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getDate("writer_Date"));
				vo.setViewCnt(rs.getInt("view_cnt"));
				vo.setImage(rs.getString("image"));
				vo.setLastUpdate(rs.getDate("last_update"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	// 추가
	public int insert(BoardVO vo) {

		String sql = "insert into board (board_no,title,content,writer, image)" + "values(seq_board.nextval,?,?,?,?)";
		conn = ds.getConnection(); // 연결

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getImage());
			int r = psmt.executeUpdate();
			return r; // 성공했으면 1을 반환함
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return 0;
	}

	// 수정
	public int update(BoardVO vo) {

		String sql = "update board set title = ?, content= ?, " + "image=nvl(?,image), last_update=sysdate "
				+ "where board_no = ?";

		conn = ds.getConnection();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getImage());
			psmt.setInt(4, vo.getBoardNo());
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리된 건수가 없음 : 에러 났다는 뜻

	}

	// 삭제
	public int delete(int boardNo) {

		String sql = "delete from board where board_no = ?";
		conn = ds.getConnection();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return 0;
	}

	// 조회수 증가
	public int updateCnt(int boardNo) {

		sql = "update board set view_cnt = view_cnt +1 where board_no = ?";
		conn = ds.getConnection();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	// 로그인 메소드 //아이디 비번 받아서 값이 있는지 없는지 체크 하래 
	public MemberVO getUser(String id, String pw) {

		sql = "select *from member where mid =? and pass =?";
		conn = ds.getConnection();

		MemberVO vo = null; // 초기화 해줘야함

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				vo = new MemberVO();
				vo.setMid(rs.getString("mid"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setResponsbility(rs.getString("responsbility"));
				return vo;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return null;
	}
	

	
	
	public List <MemberVO> memberList() {

		sql = "select *from member";
		conn = ds.getConnection();

		List <MemberVO> list = new ArrayList<>();
		MemberVO vo;

		try {
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				
				vo.setMid(rs.getString("mid"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setResponsbility(rs.getString("responsbility"));
				list.add(vo);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	

	
		

	
	
	
	
	

}///
