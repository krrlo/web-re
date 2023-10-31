//fetch1.js

import { table } from './ajaxModule.js';
//이거하는이유 데이터 편하게 가져올려고 
//서버에 요청 
fetch('../MemberListServ2')   //넘어온 값을 promise 객체로 만들어줌 //반환 값을 resolve로 넘겨줌 
.then((resolve) =>{
	console.log(resolve);  //이상한 형태로 나옴 
	return resolve.json(); //제이슨을 > 자바타입으로 
})

.then((result)=>{
	console.log(result);    //result = [{…}, {…}, {…}, {…}] 
	let titles = ["회원번호", "비번", "이름", "연락처"];
	
	
	let jsontable =table.makeTable(titles, result);
	document.getElementById('show').innerHTML = jsontable;  
	
})

.catch((err=>{
		console.log('error' , err)
	}))