//function5.js

let sum1 = 0;

[10,20,30].forEach(function(item){
	
	sum1+=item; //consumer : 매개값을 소진, 반환값은 없음
		
})

console.log('foreach' + sum1)


//////////////////////////reduce   //결과값을 새로운 값으로 반환해주는 함수  function:매개값을 소진, 반환값을 생성 
sum1=0;   //초기화 
sum1 =[10,20,30].reduce(function(acc,item,idx,ary){   //실행한 값을 반환해줌 
	console.log(acc,item,idx);                      //acc 는 누적값  //return해서 나오는 값이 그다음 순번의 초기값이됨
	return acc+item;                  //그다음 순번의 초기값이됨 
},0);    //0은 초기값       //이게없으면 달라짐 

console.log('reduce' + sum1)  //최종 누적값이 sum1에 저장됨 30이 나옴 

//////////////////////////
function sum(a=0,b=0, ...args){   //첫번째 두번째는 정해져있고 무ㅓ가 들어올지는 모르겠지만 args로 처리 
	console.log(args)   //들어온 매개변수의 순번에 따라 10,20,30,40,50이 들어있는 객체 
	return a+b+args.reduce((acc,item) => acc+item)
	//return a+b+args.reduce(function(acc,item) => {return acc+item}) 을 간단하게 
	}
	//+args.for     //처리할라면                //10+언디파인 + 언디파인 하면  콘솔창에 Nun라고 뜸    //초기값 지정   // 매개변수 parametars
//console.log(sum(10));



function sum(a=0,b=0, ...args){   
	console.log(args);
	let result = 0;
	result = a+b;
	args.forEach(num => result +=num);
	//args.forEach(function(num){result += num}); tq뭔소리냐고 시발ㅇ니 ㅏㅁㅎ런ㅇ ㅣ러
	return result;
	
	}

console.log(sum(10,20,30,40,50,60));   //앞에꺼 3개만 계산됨    //매개 값 arguments.


const numAry = [4,2,6,9,1,7];
let max = 0 ;

max=numAry.reduce(function(acc,item,idx){
	console.log(acc,item,idx);
	if(acc>item){
		return acc;
	}else{
		return item;
	}
},0)


console.log('최대값' , max)

