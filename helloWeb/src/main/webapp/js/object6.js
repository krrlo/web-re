//object6.js
//map set


const map = new Map();   //키, 값 //맵 인스턴스 생성 
map.set('홍길동' , 80);              //맵에 키랑 값 넣기 
map.set('김길동' , 85);              
map.set('김길동' , 90);         //키 값이 똑같은거 넣으면 전에 꺼 덮어써버림 ... 
//map.delete('김길동');   //키를 넣으면 그 값 삭제 

console.log(map);
const ar = [12];  // 배열을 하나 선언 //[12]배열객체래   

//let val1 = {}랑  let val2 = {} 랑 다른것처럼... 

console.log('dddddd' + ar)   //>>dddddd12

map.set(ar,88);       // 키:ar,(위에서 선언한 배열을 key로 사용한거 )   값: 88 ; 넣기 
//map.set([12],88) 하면 안됨  
console.log(map.get(ar));   //get(key)를 넣어서 88이란 값 얻기 


console.log('-----------------')

console.log(map.get('홍길동')); //>80


       
for(let ent of map.entries()){    //키와 값을 반환. !!!배열타입!!!으로 반환해주는 entries함수  ent에는 배열이 저장되어있음 
	console.log(ent);
}
//['홍길동', 80]
//['김길동', 90]
//[Array(1), 88]


console.log(map.get('홍길동'));    //>80

     
for(let ent of map.entries()){        //ent에는 배열이 저장되어있음 
	console.log('이름' + ent[0] + '점수'+ent[1]);
}                    ///ent 0 번방의 값    / ent의 1번 방의 값 

//이름홍길동 점수80
//이름김길동 점수90
//이름12 점수88



map.forEach(function(val,key,map){    //map에도  forEach 사용가능 
	if(val > 80)  {
	console.log(val,key,map);
		
	}                 //값, 키, 맵 그자체 순서대로 출력됨 
})

// 90 '김길동' Map(3) {'홍길동' => 80, '김길동' => 90, Array(1) => 88}
// 88 [12] Map(3) {'홍길동' => 80, '김길동' => 90, Array(1) => 88}




map.forEach(function(v,k,m){ 
	if(k == "홍길동")                     //홍길동의 점수를 보고싶을떄 
	console.log(v,k,m);
})

// 80 '홍길동' Map(3) {'홍길동' => 80, '김길동' => 90, Array(1) => 88}



//맵 <--> 배열.  //배열안에 배열 이 선언된거 
//배열을 >> 맵으로 바꿈 
const ary = [['프로도' , 3] ,['라이언' ,5] , ['어피치' , 4]];  //이 배열을 
const fmap = new Map(ary);             // 맵으로 바꿉니다 

for(let ent of fmap.entries()){
	console.log('키'+ ent[0] + '값' + ent[1]);
	//키프로도 값3
	//키라이언 값5
	//키어피치 값4
	console.log(ent)
	//['프로도', 3]    배열타입으로 반환되어 나옴 
	//['라이언', 5]
	//['어피치', 4]
	
}

const entries = fmap.entries();
console.log(entries);       //entries : MapIterator 타입 

//맵을 배열로 바꾸려면 
console.log(Array.from(fmap));
//[['프로도' , 3] ,['라이언' ,5] , ['어피치' , 4]]



//Set: 중복값 허용 X 
const set1 = new Set();  //새로운 Set생성 
set1.add("라이언");
set1.add("프로도");
set1.add("어피치");
//set1.add({ name:"어피치" , pont:4});
set1.add( ["어피치" , 4]);
set1.add( ["어피치" , 4]);   //set안에 배열을 추가 

console.log(set1.size);   //size 5

set1.forEach(function(val,item,set){    //set도 forEach사용가능 
	console.log(val,item,set);
})

//라이언 /라이언 set자체 : Set(5) {'라이언', '프로도', '어피치', Array(2), Array(2)}
//프로도 프로도   set자체 : Set(5) {'라이언', '프로도', '어피치', Array(2), Array(2)}
//어피치 어피치   set자체 : Set(5) {'라이언', '프로도', '어피치', Array(2), Array(2)}
//['어피치', 4]  ['어피치', 4]   set자체 : Set(5) {'라이언', '프로도', '어피치', Array(2), Array(2)}
//


//배열을 셋으로 
const setAry = ['라이언' , '프로도' , '무지' , '무지']    //배열을 > set타입으로 할께요
const set2 = new Set(setAry);
console.log(set2.size)   // 결과 사이즈: 3 배열을 셋으로 만들면 중복된 값 ㅈㅔ거되어져서 나옴 
console.log(set2)
//{'라이언', '프로도', '무지'}

//셋 > 배열로 
console.log(Array.from(set2));
//['라이언', '프로도', '무지']
