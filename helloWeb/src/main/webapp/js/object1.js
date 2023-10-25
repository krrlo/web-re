//object1.js
//object.js 꺼를 사용가능
//멤버라는 클래스에 혈액형 속성 추가 하기 
//prototype이라는 속성에 지정..?하 
Member.prototype.setBloodType = function(bloodType){
	this.bloodType = bloodType;
}
Member.prototype.getBloodType = function(){
	return this.bloodType;
}


const mem2 = new Member('홍길동',22,123.4);
mem2.setBloodType('ab');
console.log(mem2.getBloodType());

console.log ('gkgkgkgk' , mem2.bloodType);

//문자열을 가지고와서 5글자만 남기고 자르는 기능 
//이미 존재하는 String클래스임 js클래스 추가 가능..????????????
String.prototype.truncate = function(){
	console.log(this);
	return this.substring(0,5)   //this는 String 문자열 값을뜻함
}

let result = "heeeeeeeee".truncate();
console.log(result);