//dom2.js

//
//show>table>tbody>(tr>td:사과+td:1000)+(tr>td:반복+td:1000)

const fruits = [
	
	{name : "사과" , price :1000, farmer: '홍길동'},   
	{name : "복숭아" , price :1500 ,farmer: '홍길동'},
	{name : "포도" , price :2000,farmer: '홍길동'},
	{name : "수박" , price :3000,farmer: '홍길동'},
 ]
 
 
/* document.getElementById("show").innerHTML= '<table><tbody>';
 
 
 const tr = document.createElement('tr');
 
 fruits.forEach(obj=>{
	 const td = document.createElement('td');
	 td.innerHTML =  obj.name  + obj.price
     tr.appendChild(td);     
 })
 
 
 document.getElementById('show').append(tr); */
 
 
 
 //수업코드
 
 const tbl = document.createElement('table');  
 const tbd = document.createElement('tbody');
 tbl.setAttribute('border' ,'1'); //테이블에 border 1 속성 추가 
 
 
 fruits.forEach(obj =>{
	 const tr = document.createElement('tr');  //tr생성 
	 for(let prop in obj){
		  const td1 = document.createElement('td');  
		   td1.innerHTML = obj[prop]; //배열 돌려서 값빼내서 td만들기 
		   tr.appendChild(td1); //만든 td를 tr에 붙히기 
	 }
	 
	 
	tbd.appendChild(tr);    //tr완성했으니까 tbd에 붙히기 
	 
 })
 
 tbl.appendChild(tbd);  // 테이블에 tbody붙히기 
 document.querySelector('#show').appendChild(tbl);  //만든 테이블을 화면에 출력 
 