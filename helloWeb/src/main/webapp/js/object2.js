//objetc2.js

const students = [  //배열선언 
	{sno:'001' , sname:"최해주", engScore:80 , mathScore:85},
	{sno:'002' , sname:"김채민", engScore:82 , mathScore:83},
	{sno:'003' , sname:"최다예", engScore:84 , mathScore:88},
]



const member = new Member('홍길동',22,123.4); //객체 쓸라고 만든거 


let str = member.makeHtml(students);
member.showPage(document.getElementById('show'),str)
//member.showPage(document.getElementById('show'));