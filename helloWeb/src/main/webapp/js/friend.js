/**
 * friend.js
 * 
 * 
 
 */

 
 //export지우면 .. module에서 불러 올수 없음 
  	const friend = {
	 name : "hong",
	 phone: " 010-111-111",
	 address : "대구중구 11" ,
	 showInfo : function(){
		 return `이름  ${this.name} 연락처 ${this.phone}`
	 }
 }
 
 
 	function friendInfo(friend){         //객체를 넣어주면 
	 return `${friend.name},${friend.phone},${friend.address} `
	 
 }
 
 
 
 export {friend,friendInfo}
 //export 한 애만 외부로 노출될수있게 
 //friend 객체와 friendInfo 함수를 export