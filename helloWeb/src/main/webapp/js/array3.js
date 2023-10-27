//array3.js  //배열에서 원하는 문자 번호 찾기 


//String에서 글자 찾기 
let result="hello, world".indexOf(",");
console.log(result);   //없으면 -1 반환 ,  
//>>결과 5


//배열에서 글자 찾기 
let names = ["콘", "무지" , "라이언" , "어피치"];
result = names.indexOf("라이언");


if(result == -1){
	console.log("없는이름인데요?")
}else{
	console.log("몇번 위치에 있냐면요.... >> " + (result+1));
}


//객체가 들어있는 배열 생성    // 민식이라는 사람이 몇명있는지 보고싶대... 
let members = [
	{name: "김민식" , age:22},
	{name: "이민식" , age:23},
	{name: "주우니" , age:28},
]



let search = "민식"

let sum = 0;

members.forEach(function(m){
	if(m.name.indexOf(search) != -1){
		sum += 1;
	}
})

console.log("민식이가 몇명있냐면..>>" , sum);

