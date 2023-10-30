package org.yedam.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Setter
//@Getter
//@ToString

@Data
@AllArgsConstructor  //생성자 만들어줘 MemberVO(string,str.str.str) 
@NoArgsConstructor  //기본생성자 

public class MemberVO {
       private String mid;    //회원번호
       private String pass;   //패스워드
       private String name;   //이름
       private String phone;  //폰번호
       
       

       
       
       
       
       
}///클래스 
