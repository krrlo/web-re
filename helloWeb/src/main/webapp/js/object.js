//object.js
console.log('ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ')

let obj1={                       //객체생성 
	name:'hong',
	age:20
}



///////////주소 참조하는 형태 ////
let obj2 = obj1;    //obj의 주소값을 obj2가 가지고있게 되는것 
console.log(obj1);

obj2.age=22;   //obj2를 바꿧지만 obj1이 바뀌게됨 
console.log(obj1);   // obj1 age = 22 




///////////복사하는 형태 ////
let obj3 = {...obj1};   //obj1 속성 펼쳐서 새로운 obj3를 만들겠다.. //주소값 참조랑 복사는 다른거임

obj3.age=24;   //obj3 나이 24 바꿈 
console.log(obj1);  //여전히 obj1 age는 22나옴   // obj3랑 관련없음 


///클래스 사용해서 객체 생성...........................

class Member{
	
	
	constructor(name, age, height){
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	setWeight(weight){
		this.weight = weight;            //필드선언한거 
	}
	
	getWeight(weight){
		return this.weight
	}
	
	
	showInfo(){
		return `이름은 ${this.name} 나이는 ${this.age} 세 입니다`;
	}
	
	
	
	///학생의 정보: 학생번호, 이름, 영어, 수학, 
	
	
	makeTr(student={sno, sname, engScore, mathScore}){
		let html = '';                   
		html += '<tr>';
		html += '<td>' + student.sno + '</td>'
		html += '<td>' + student.sname + '</td>'
		html += '<td>' + student.engScore + '</td>'
		html += '<td>' + student.mathScore + '</td>'
		html += '</tr>';
		return html;		

	}
	
	
	
	
	makeHtml(studAry=[]){               //이거전체 html              
		//배열 들어오면 html만들어주는 기능  this.makeTr사용 
		
		let str = '';
		str += '<table border = 1>';
	//	let obj = this; //라고 해줘야한대....?  //this접근해도 멀쩡함  > 멤버 객체를 가르킴  
		/*studAry.forEach(function(item){
			str += this.makeTr(item)
		})*/
		
		studAry.forEach(obj => str += this.makeTr(obj));
		//화살표일경우에는 THIS가 객체를 가르키기 때문에 오류안남 
		
		str += '</table>';

		return str;
	}//
	
	
	
	showPage(dom,str){
		
		dom.innerHTML += str;
		
	}
	
	
	
}//class Member




const mem1 = new Member('홍길동', 30, 156.7)   //새로운 인스턴스 객체 생성 
console.log(mem1.showInfo());
mem1.setWeight(62.5);
console.log('몸무게는' , mem1.getWeight());
console.log('ddd' , mem1.weight);
