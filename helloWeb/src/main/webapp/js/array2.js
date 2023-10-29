//array1.js  //mock 파일의 데이터 활용   1027 
//members 배열안에 객체가 들어있음 
const json = `[{"id":1,"first_name":"Marleah","email":"mcritchlow0@tiny.cc"},
{"id":2,"first_name":"Barrie","email":"bquinlan1@artisteer.com"},    
{"id":3,"first_name":"Gram","email":"ghambrick2@google.com.br"},
{"id":4,"first_name":"Truman","email":"tmcmains3@dmoz.org"},
{"id":5,"first_name":"Abby","email":"asimenon4@geocities.jp"},
{"id":6,"first_name":"Maegan","email":"meynald5@cnbc.com"},
{"id":7,"first_name":"Lenora","email":"lofallon6@wiley.com"},
{"id":8,"first_name":"Colman","email":"ccarus7@etsy.com"},
{"id":9,"first_name":"Gertrudis","email":"gsweet8@sphinn.com"},
{"id":10,"first_name":"Travus","email":"tchallener9@discuz.net"}]`; //json -> object. 
//문자열을 자바스크립트의 객체로 바꾸는 함수  JSON.parse() 사용 
//숫자를 제외한 모든문자는 ""로 
//위의 형식대로 안하면 json.parse 사용하면 에러남..

let members = JSON.parse(json);    //문자열 json을 자바스크립트 members라는 변수에 넣어서 객체로 만듦
console.log(members);   //members 배열을 만듬  배열안엔 객체가 들어있음 
// [{…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}]



//객체의 속성에 접근할때   yourinfo.name    
//                    yourinfo.email

//members.push(yourinfo);
//배열의 마지막에 추가 



//members.forEach(function(m,d){   //배열전용  // 이름이 abby인 애 지움  members배열의 객체m이 하나씩 들어옴 
//	if(m.first_name == del){
//		members.splice(d,1);       이름이 del인 얘의 인덱스 번호로 삭제 
//	}
//})

let del = "Abby";   //얘를 지우고싶어 
let yourinfo = { name : "Hong" , email :"hong@e.com"}  //객체 추가하기 

members.forEach(function(m,idx){       //members 배열 객체 하나씩 돌리는데   
	if(m.first_name == del){    //m== 들어온 객체 하나 
		members.splice(idx,1, {id : m.id, first_name : yourinfo.name, email:yourinfo.email});
	}      //del 의 인덱스번호 , del 지우고  ㅌ   {id는 m.id를 쓰고 } 객체 추가  
})



console.log(members);


//배열 돌리는데 객체의 아이디가 3인 애의 이름을 빼내라 
for(let val of members){
	if(val.id =="3"){
	   console.log(val.first_name)
	}
}


//for(let val of members){    //배열의 값을 하나씩 빼내서 출력 
//	console.log("val" , val)
//}

//{id: 1, first_name: 'Marleah', email: 'mcritchlow0@tiny.cc'}
//{id: 2, first_name: 'Barrie', email: 'bquinlan1@artisteer.com'}


//아이디/이름/이메일 
//얘를 배열의 젤 마지막에 위치하게 
let input = prompt("이름과 이메일 입력하세요  예 ) 홍길동, hong @naver.com")
console.log(input);

let namemail = input.split(',');    //이름과 메일이 나눠진 배열
console.log(namemail);  //['이주웅', 'krrlo@naver.com']

let id =members[members.length-1].id + 1;
//members[9] 번의 id 값 = 10 +1   = 11 을 id값으로 해라 

members.push({id : id , first_name : namemail[0] , email : namemail[1].trim()});
//members.splice(members.length,0,newMember);  //삭제 없이그냥 배열의 맨 뒤에 요소 추가 

console.log(members);   //배열 출력  


const dary =[['프로도' , 3] ,['라이언' ,5] , ['어피치' , 4]];
console.log(dary);
console.table(dary);   //콘솔 창에 테이블 형태로 나오게됨 









