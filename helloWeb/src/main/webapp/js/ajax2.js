//ajax2 1030

import { table } from './ajaxModule.js';

//onclick이벤트 등록 . <button id ="addBtn" onclick="addMember()">
//member = {name: "hong" , age : 20} member.name

document.getElementById('addBtn').onclick = addMember;   //한줄추가 
document.getElementById('modBtn').onclick = modMember;   //수정하려고 
//modbtn이 눌리면  modMember함수가 실행되게 


//클릭 이벤트가 발생하면 함수 실행 
function addMember(e) {    //e 는 이벤트 유형이 넘어옴 
	let mid = document.getElementById('mid').value;
	let pass = document.getElementById('pass').value;
	let name = document.getElementById('name').value;
	let phone = document.getElementById('phone').value;

	//여기 변수 값을 넘김 


	const xhtp = new XMLHttpRequest();   //경로 맞추는거 모르게ㅒㅆ음 
	xhtp.open('get', '../AddMemberServ.html?mid=' + mid +
		'&pass=' + pass + '&name=' + name + '&phone=' + phone);
	xhtp.send(); //요청을 서버에 전달 

	xhtp.onload = function() {
		console.log(xhtp.responseText)    // out.print 내용이 나옴 ..
		//{"code":"ok","vo":{"mid":"dd","pass":"dd","name":"dd","phone":"dd"}}
		//제이슨문자열을 java 객체로 
		let java = JSON.parse(xhtp.responseText);
		console.log(java);     //java = {code: 'ok', vo: {…}}

		//문자열을 객체로 바꾼다음   
		//사용자 입력값 retcode = ok = > {vo: mid, pass,name, phone"}
		//tr생성해서 td만들어서..list의 마지막에 추가되도록  
		//retcode==ng = > alert 9'c처리중 에러 메세지 뜨게 

		if (java.code == 'ok') {
			let neww = table.makeTr(java.vo);
			document.getElementById('list').innerHTML += neww;
		} else {
			alert('처리중에러' + java.vo + '에러남')
		}



	}//onload
}//addMember


function modMember(e) {

	//console.log("출려ㅑ되나요!!!!!!!!!!!!!")

	let mid = document.getElementById('mid').value;
	let pass = document.getElementById('pass').value;
	let name = document.getElementById('name').value;
	let phone = document.getElementById('phone').value;
	//4개의 값을 입력받아오고 

	const xhtp = new XMLHttpRequest();   //아작스 호출 
	xhtp.open('get', '../ModMemberServ.html?mid=' + mid +
		'&pass=' + pass + '&name=' + name + '&phone=' + phone);
	xhtp.send(); //ajax실행 

	xhtp.onload = function() {

		let java = JSON.parse(xhtp.responseText);
		console.log(java)
		//retcod :ok,ng vo:
		//데이터 영역 tr
		console.log(document.querySelectorAll('#list tr'));  //tbody하위에있는 tr가져오기
		document.querySelectorAll('#list tr').forEach(tr => {
			//console.log(tr.children)
			if(tr.children[0].innerHTML == java.vo.mid){ //아이디 값이 같을경우에 
			tr.children[1].innerHTML=java.vo.pass;
			tr.children[2].innerHTML=java.vo.name;
			tr.children[3].innerHTML=java.vo.phone;
			}  
		})

	}//onload

}//modmember













//const xhtp = new XMLHttpRequest();   //경로 맞추는거 모르게ㅒㅆ음
//xhtp.open('get', '../AddMemberServ.html?mid=M008&pass=9999&name=Kim&phone=010-9876-0987');
//xhtp.send(); //요청을 서버에 전달
//xhtp.onload = function() {
//	console.log(xhtp.responseText)  // out.print 내용이 나옴 ..   ok
	//{"mid":"M009","pass":"9999","name":"Kim","phone":"010-9876-0987"}
//}