//string3.js
//String 이 가지고있는 내장객체임 


let today = new Date();//
today.getFullYear(); //연도를 가지고온 
today.getMonth(); // 
today.getDate();

//날짜 내가 원하는대로 변경. 
today.setFullYear(2022);
today.setMonth(9);  //1워ㅗㄹ
today.setDate(1);   //1일
today.setHours(10);   //10시

console.log(today.toString());
console.log(today.toString());


function dateFormat(today){
	//yyyy-MM-dd hh24:mm:ss
	return today.getFullYear() + "-" + "0"+(today.getMonth()+1) + "-"+ "0"+today.getDate() + "-" + today.getHours()+":"
	+today.getMinutes()+ ":" + today.getSeconds();
}

console.log(dateFormat(today));


let mon=today.setMonth(9);

console.log(mon)