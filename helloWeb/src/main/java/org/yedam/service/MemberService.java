package org.yedam.service;

import java.util.List;

public interface MemberService {   //인터페이스 
          
	         
	public List <MemberVO> memberList();   //회원목록 불러오기 
	public boolean addMember(MemberVO vo);  //회원추가
	public boolean modifyMember(MemberVO vo); //회원삭제  >>impl에도 추가 
}
