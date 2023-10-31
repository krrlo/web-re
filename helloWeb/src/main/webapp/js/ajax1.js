//ajax1.js  //1027

//비동기vs동기 
//
//동기>>위에서부터 순차적으로 진행되는거 
//작업이 끝나는 순서대로 정해짐   2000의 마지막 시간까지...
import { table } from './ajaxModule.js';

let friends = [];

setTimeout(function() {                     //첫번째 매개값 = 함수 ,  두번째 매개값 = 몇초있다가 함수를 실행할건지 
	friends.push('홍');
}, 1000);    //실행할 함수, 1000초 있다가 함수 실행하겠습니당..?하 



setTimeout(function() {
	friends.push('최');
}, 500);   //1111111




setTimeout(function() {
	friends.push('김');
}, 2000);


console.log('비동기', friends);




//이거 왜이래????????????출력이상해............



//friends.push('홍');
//friends.push('최');
//friends.push('김');
//console.log(friends);    //3) ['홍', '최', '김']  //동기방식으로 처리한것 순차적으로 







////////////////////////////////////////
///1)ajax실행 
let xhtp = new XMLHttpRequest();            //xhtp는 객체임   //서버와 상호작용을 위해..? 
xhtp.open('get', '../MemberListServ2');   //(서버와 통신하여 수행할 get post...값설정  , 통신 요청을 처리할 주소 값)
xhtp.send();   //위의 요청을 서버에 전달 
xhtp.onload = loadJson;   //함수부를때 ()이 없음 



let newMember = { mid: "M009", pass: "8888", name: "두웅이", phone: "010-9999-9999" }
//마지막 위치에 얘 추가하기 




/////////////////////////////////////////////

function loadJson() {         //가지고온 데이터로 페이지를 그려주는게 목적임    
//	console.log(xhtp.responseText);    //json문자 형태로 data가 들어가있음 
	let json = JSON.parse(xhtp.responseText);  //제이슨문자열을 자바 오브젝트로 변경해줌 
	console.log(json);   // json 배열 생성 [{객체} {객체}]  배열 형태로 만들어짐 

    let titles = ["회원번호", "비번", "이름", "연락처"];
    
    let jsontable =table.makeTable(titles, json);  //만들어진 배열로 json테이블만들기
//    console.log(jsontable);
    
    document.getElementById('show').innerHTML = jsontable;  
    
    //마지막 위치에 새로운  한 행 넣기 
    let newjson=table.makeTr(newMember);
     document.getElementById('list').innerHTML += newjson;  
     
}  //loadJson


//let dataAry[];/
//json.forEach(memeber =>){
//	dataAry.push({
//		mid : member.mid, pass: member.pass,
//		name: member.name, phone : member.phone
//	})
//})



/////////////////////////////////////////////
function loadXML() {   //온로드 함수선언 
	//console.log(xhtp)   // >> XMLHttpRequest
	console.log(xhtp.responseXML)  //>>#document 열면 <dataset> <record> xml문서가 나옴 
	let doc = xhtp.responseXML;  //doc이란 변수에 xml문서 저장 
	let records = doc.getElementsByTagName('record')   //레코드라는 태그내임을 가져오겠습니다
	console.log(records);  
	 //HTMLCollection(4) [record, record, record, record]  //배열 형식으로 가져옴  배열처럼 보이지만 실제 배열은 아님 
	//console.log(records[0].children[0].innerHTML);// >1번을 가져옴 
	
	let titles = ["회원번호", "비번", "이름", "연락처"];
	let dataAry = [];
	
																	//		children
	//records 배열 돌려서 값 빼내기 												0:mid	
	for (let record of records) {									//	    1:pass				
		let obj = {                     //객체하나생성 						2:name
			mid: record.children[0].textContent,   ///>> id래				3:phone
			pass: record.children[1].textContent,   ///>> 이름
			name: record.children[2].textContent,  ///>> 비번
			phone: record.children[3].textContent   ///>> 연락처
		}

		dataAry.push(obj); //만든 객체를 dataAry배열에 하나씩 넣기 

	}//포 
	
	console.log(dataAry);   
	//[{…}, {…}, {…}, {…}]
	// 0 : {mid: 'M001', pass: '1111', name: '홍길동', phone: '010-1234-4567'}	
	// 1 : {mid: 'M002', pass: '2222', name: '서영희', phone: '010-4567-8762'}

	let result = table.makeTable(titles, dataAry);    //table객체의 makeTable이라는 함수 사용해서 가져온 데이터들로 테이블 만들기
	console.log(result);       //titles, dataAry배열을 매개값으로 넘기기 
	document.getElementById('show').innerHTML = result;              //div id show에 만든 테이블 넣기 

//let newMember = { mid: "M009", pass: "9999", name: "민식이", phone: "010-9999-9999" }
	let tr = table.makeTr(newMember)   // 위에 데이터 1줄 추가하려면 
	document.getElementById('list').innerHTML += tr;

}//onload함수 끝 






