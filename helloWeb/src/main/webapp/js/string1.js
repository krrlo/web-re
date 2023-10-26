//string1.js

let str1 = "hello";   //기본데이터타입
let str2 = new String("hello"); //객체 타입

console.log(typeof str1, typeof str2);   //string , object
console.log(str1 ==str2); //값만비교   true  
console.log(str1 ===str2); //값과 변수의 유형 비교  false    하나는 스트링 하나는 오브젝트 




console.log(str1.toUpperCase());        //스트링타입이고 객체가 아님에도 불구하고 대문자 메소드 사용 가능 ...  
						// HELLO		//타입 구분 없이 문자열 메소드 쓰면됨
										//스트링 객체가 기본적으로 가지고 있는 메서드 
							
	
		
							
//trim()	
//공백제거 					
let res = '   공백 제거 합니다.  ' .trim();
console.log(res , res.length)	  //공백 제거 합니다. 10




//replace()
//다른문자로 대체 
result = "hello, world , nice , world" . replace(',','.');  //첫번째 , 를 . 으로 바꿔 
console.log(result);	


result = "hello, world , nice , world" . replace(/,/g,'.');  //콤마 찾아서 점 으로 문장 중에서 콤마 다 바꾸기  정규표현식 사용해서 ................
console.log(result);	

result = "hello, world , nice , world" . replace(/\s/g,'');   //공백 제거 
console.log(result);




//trimStart() 
//문자열 앞쪽의 공백 제거 




//trimEnd()
//문자열 뒤쪽의 공백제거 



//slice()  
//10~15의 값만 추출해서 가져옴  
result = 'this is the only one story'.slice(10,15);
console.log(result);  //결과 >> e onl



//substring()
//slice와 같은 특징
//(10 , -8)




//split()
//let jj = strr.split(' '); //공백을 기준으로 잘라서 배열로 저장 
//console.log(jj);


// substr()  
//8번째 인덱스부터 11개의 문자를 가져옴 
result = 'this is the only one story'.substr(8,11); 
console.log(result);  //결과 >> the only on




//toString()  
//숫자를 문자열로 변경
 let num = 123;
  console.log(num.toString());  //결과 >> 123



//indexOf()   
//찾은 문자열의 시작위치를 가리키는 정수 숫자를 반환함    
result='안녕하세요 이주은입니다 자바스크립트 하는중 '.indexOf('이주은')
console.log(result);  //>> 결과 6  



//lastIndexOf() 
result='안녕하세요 이주은입니다 자바스크립트 하는중 이주은 '.lastIndexOf('이주은')
console.log(result); //>> 결과 24 //문자열 뒤에서부터 찾기 



//charAt()  
//특정위치의 문자 1개를 얻기 

result='안녕하세요 이주은입니다 자바스크립트 하는중 '.charAt(8);
console.log(result); //>>결과 '은' 


//includes()   
result='안녕하세요 이주은입니다 자바스크립트 하는중 '.includes('은');
console.log(result);   //>>은이라는 글자가 문자안에 있으면 true 반환 


//concat()
//st1 + str2 랑 글자 합쳐줌 
const st1 = '이주은';
const st2 = '최다예';
console.log(st1.concat(st2));