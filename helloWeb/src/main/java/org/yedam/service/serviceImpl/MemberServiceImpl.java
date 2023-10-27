package org.yedam.service.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.yedam.common.DataSource;
import org.yedam.service.MemberService;
import org.yedam.service.MemberVO;


public class MemberServiceImpl implements MemberService{

	
	private DataSource dao = DataSource.getInstance();
	Connection conn;  
	PreparedStatement psmt;   
	ResultSet rs;
	
	
	
	@Override  //멤버 전체 조회 메소드 
	public List<MemberVO> memberList() {
		
		List <MemberVO> list = new ArrayList<>();
		MemberVO vo;
		String sql = "SELECT *FROM MEMBER";  
			
		
    	try {
			conn =dao.getConnection();
			psmt =conn.prepareStatement(sql);  
			ResultSet rs = psmt.executeQuery();    
			
			while(rs.next()) {                                            
				vo = new MemberVO(); 
				vo.setMid(rs.getString("mid"));   
			    vo.setPass(rs.getString("pass"));
			    vo.setName(rs.getString("name"));
			    vo.setPhone(rs.getString("phone"));
			    list.add(vo);
			}
			rs.close();   
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
			
	}
	
	
	

	private void close() {
			
		try {
			if(psmt != null) psmt.close();   
			if(conn != null) conn.close();     
  		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}//
