//function4.js


//생성자 함수 function Member().



function Member(name, age, height) {

	this.name = name;
	this.age = age;
	this.height = height;
	this.showInfo = function() {
		return `이름은 ${this.name}, 나이는 ${this.age} 입니다.....`; 
	}

} 


document.getElementById('saveBtn').onclick = function(e) {
	//console.log(e.target)
	let name = document.getElementById('name').value           //id가 name인 값을 읽어오겠다.. 
	let age = document.getElementById('age').value
	let height = document.getElementById('height').value

	const mem = new Member(name, age, height);  //새 객체 만듦 생성자 함수 이용해서 ///저장 받은애로 
	let str = makeTr(mem);

	if (
		document.getElementById('name').value == ""
		
			) {
		alert('값넣어라');
	}

	function makeTr(member) {
		let html = '';
		html += '<tr>';
		html += '<td>' + member.name + '</td>';
		html += '<td>' + member.age + '</td>';
		html += '<td>' + member.height + '</td>';
		html += '<td>' + member.showInfo() + '</td>';
		html += '<td>' + '<button id="dBtn">삭제</button>' + '</td>';
		html += '</tr>';
		return html;
		
	
	}//maketr
	

	document.getElementById('list').innerHTML += str;  //id 가 list인 애한테 만든거 넣어라 //누적 +=
	
	document.getElementById('name').value   ="";       //입력된값 지울라고 
	document.getElementById('age').value =""  ;
	document.getElementById('height').value ="" ;  
	
	
	document.getElementById('name').focus();    //한번 저장하고 포커스 

	
	
	
}///




//버튼을누르면 함수 실행 //function e매개값을 무조건 받게되있이 ㅁ
//onclick은 dom요소(getele..) 누구한테나 사용 가능 ()