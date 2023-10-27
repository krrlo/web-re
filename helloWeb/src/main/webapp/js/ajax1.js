//ajax1.js

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




//비동기방식????????????????????뭐냐고????????????????????????????????????
//이게 뭔데??????????????????????????????????????????????


let newMember = {mid:"M009" , pass: "9999" , name:"민식이" , phone:"010-9999-9999"}
//tr만듣는것처럼 만들어서  테이블이 만들어지면 
//4번째 위치에 얘가 나오게 하래 tbody = "list" 추가 



////////////////////////////////////////
///1)ajax실행 
let xhtp = new XMLHttpRequest();            //xhtp는 객체임 
xhtp.open('get', '../MemberListServ2');  //객체가 oepn이라는 아 먼소리ㅏㅇㄴ머; 아
xhtp.send();   //xhtp가져오겟다고?????????
xhtp.onload = loadJson;   //이벤트가 발생하면... 하 MXL()이 없대.. 

   function loadJson(){          //'../MemberListServ2');이거 2번으로 바꾸래 
	   console.log(xhtp.responseText);
	   let result = JSON.parse(xhtp.responseText);  //제이슨문자열을 자바 오브젝트로 변경해줌 
	   console.log(result);
	   
	   
	   //화면에 출력되게 하래
	     
	   
   }
   
   /////////////////////////////////////////////
   function loadXML() {   //온로드 함수선언 
	//console.log(xhtp)   // >> XMLHttpRequest
	console.log(xhtp.responseXML)  //>>#document
	let doc = xhtp.responseXML;
	let records = doc.getElementsByTagName('record')   //레코드라는 태그내임을 가져오겠습니다
	console.log(records);   //HTMLCollection(4) [record, record, record, record]
	//onload이벤트가 발생하면.. 
	//console.log(records[0].children[0].innerHTML);// >1번을 가져옴 
	let titles = ["회원번호", "비번", "이름", "연락처"];
	let dataAry = [];
	for (let record of records) {
		let obj = {
			mid: record.children[0].textContent,   ///>> id래
			pass: record.children[1].textContent,   ///>> 이름
			name: record.children[2].textContent,  ///>> 비번
			phone: record.children[3].textContent   ///>> 연락처
		}
		
		dataAry.push(obj);
		
	}

		let result = table.makeTable(titles, dataAry);
		console.log(result);
		document.getElementById('show').innerHTML = result;
           
           
         let tr = table.makeTr(newMember)   // 한줄 만듦 
         document.getElementById('list').innerHTML += tr;
  
}//onload


