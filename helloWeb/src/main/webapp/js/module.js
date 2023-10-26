//module.js
///
import { friend ,friendInfo } from './friend.js'; 
import {cal} from '../todo/calendarobj.js';
///프렌드js에 있는 함수를 사용할수있음. 
//동일한 전역에 있으므로.. 


//const friend = {
//	 name : "kkkk",
//	 phone: " 010-111-111",
//	 address : "대구중구 11" ,
//	 showInfo : function(){
//		 return `이름  ${this.name} 연락처 ${this.phone}`;
//	 }
//}




console.log(friend.showInfo()); //friend객체의 showInfo를 호출 
console.log(friendInfo(friend));    //함수호출 ㅎㅎㅎ 
cal.showCalendar();  //cal 객체로 cal.show메소드 호출 가능 

//이거 임포트하면 html에서 friend.js파일 지워도됨 
//html<script type ="module" src ="module.js"></script> 
//로 선언해 줘야함 

//cal.show >>달력 부르기 