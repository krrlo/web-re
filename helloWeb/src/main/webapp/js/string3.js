//string3.js
//String 이 가지고있는 내장객체임 


let today = new Date();//
today.getFullYear(); //연도를 가지고온 
today.getMonth(); //  달
today.getDate();   //날 

//날짜 내가 원하는대로 변경. 
today.setFullYear(2022);
today.setMonth(9);  //10월
today.setDate(1);   //1일
today.setHours(10);   //10시


console.log(today.toString());   //Sat Oct 01 2022 10:58:10 GMT+0900 (한국 표준시)


function dateFormat(today){   //위에서 설정한 대로 
	//yyyy-MM-dd hh24:mm:ss
	return today.getFullYear() + "-" + "0"+(today.getMonth()+1) + "-"+ "0"+today.getDate() + "  " + today.getHours()+":"
	+today.getMinutes()+ ":" + today.getSeconds();
}

console.log(dateFormat(today));  //함수는 불러야 실행된다 

//010 고치기 //