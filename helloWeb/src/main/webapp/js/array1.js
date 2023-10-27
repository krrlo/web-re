//array1.js


const arr1 = []
//배열에 뒤에 요소 추가 
arr1.push(10)    //여러 타입의 값을 담는거 가능    숫자, 문자, 객체 등 다 담을수 있음 
arr1.push('ten')  
arr1.push({name : 'hon' , age :20})  //객체담음 


//배열의 앞쪽에 추가  
arr1.unshift(20);  



//arr1.length = 3;    //배열 크기 줄일 수 있음 4>3으로 줄임    //4번째꺼는 삭제됨 

//20
//10
//ten


//arr1.length = 5;    //크기는 5인데 값인 4개밖에 없으면 마지막에 undefined

//arr1.pop();              //뒤에서부터 배열에서 어떤 위치의 값을 삭제할떄 
//arr1.shift();			//앞에서부터 배열에서 어떤 위치의 값을 삭제할떄 



//splice(시작인덱스, 삭제할 요소 길이 , 추가할 배열 요소 1, 추가할 배열요소 2....)
arr1.splice(1,0,30);   //추가
arr1.splice(1,1,30);   //추가 
arr1.splice(1,1);      //삭제 
arr1.splice(1,0,30,60);              
arr1.splice(1,2,30,60);


console.log("배열의 크기는 " , arr1.length)   // 길이는 3
for(let ary of arr1){             //배열 돌리기 
	console.log(ary);
}
//결과
//20   //앞에 추가됨 
//10
//ten
//{name: 'hon', age: 20}



