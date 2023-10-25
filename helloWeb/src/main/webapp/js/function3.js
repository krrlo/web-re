//function3.js

//객체 만드는 방식  2

function Member(name, age, height) {  //생성자 함수
	console.log(this);  //최상위 윈도우 객체를 뜻함 
	this.name = name;
	this.age = age;
	this.height = height;
	this.showInfo = function() {
		return `이름은 ${this.name}, 나이는 ${this.age} 입니다.....`; //this꼭 쓰기
	}
}
var myName = 'Hong';

const member = new Member('홍길동', 20, 123.4);  //new로해서 만들면 
console.log(member.showInfo());

//window.alert('dd')


//new로해서 객체 만들면 this는 윈도우가 아니라 만들어진 객체를 지칭함 
//new 키워드로 객체 생성 하면 생성자 함수처럼 사용가능


const members = [    //배열생성 
	new Member('홍길동', 20, 123.3),       //showInfO기능도 가지고있는 객체 
	new Member('고길동', 20, 130.3),
	new Member('박길동', 20, 140.3)
]


//함수 :  테이블 생성 

function makeTable(memberAry = []) {  //배열을 받는다고 매개변수 선언 
	let str = '';
	str += '<table border = 1>';
	str += '<tbody>';
	memberAry.forEach(function(item) {
		str += makeTr(item)  //tr 만들어 주는 기능 
	})
	str += '</tbody>';
	str += '</table>';

	document.getElementById('show').innerHTML = str;  //목적


	function makeTr(member) {        //테이블만드는 함수 생성  함수로 오는 매개변수의 타입이 오브젝트타입으로 할거다 
		let html = '';                    //makeTable 메소드 안에서만 사용 가능 밖에서 사용 불가 
		html += '<tr>';
		html += '<td>' + member.name + '</td>'
		html += '<td>' + member.age + '</td>'
		html += '<td>' + member.height + '</td>'
		html += '<td>' + member.showInfo() + '</td>'
		html += '</tr>';
		return html;
	}//maketr
}  // maketable


makeTable(members);//함수 실행 
