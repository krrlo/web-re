package org.yedam.service;

public class MemberVO {
       private String mid;    //회원번호
       private String pass;   //패스워드
       private String name;   //이름
       private String phone;  //폰번호
       
       
       
 
  
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", pass=" + pass + ", name=" + name + ", phone=" + phone + "]";
	}
       
       
       
       


       
       
       
       
       
}///클래스 
