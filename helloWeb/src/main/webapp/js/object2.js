//objetc2.js

const students = [
	{sno:'001' , sname:"최해주", engScore:80 , mathScore:85},
	{sno:'002' , sname:"김채민", engScore:82 , mathScore:83},
	{sno:'003' , sname:"최다예", engScore:84 , mathScore:88},
]



const member = new Member('홍길동',22,123.4); //객체 쓸라고 만든거 
//member.makeHTML(students); makeTr  //호출 
//member.showPage(document.getElementByid ('SHOW)


let str = member.makeHtml(students);
member.showPage(document.getElementById('show'),str)