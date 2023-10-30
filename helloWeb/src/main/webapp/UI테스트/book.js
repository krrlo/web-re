import { table } from './bookModule.js';




let xhtp = new XMLHttpRequest();    
	xhtp.open('get', '../BookListServ'); 
	xhtp.send();
	xhtp.onload = loadJson;
	
	
	function loadJson() {   
	let json = JSON.parse(xhtp.responseText);   //받아온 json 데이터를 다시 자바형태로 
	console.log(json);   
	
	 let titles = ["북코드", "제목", "저자", "출판사","가격"];
	 
	 let jtable = table.makeTable(titles,json);
	 console.log(jtable)

	document.getElementById('show').innerHTML = jtable;  
	
	
}