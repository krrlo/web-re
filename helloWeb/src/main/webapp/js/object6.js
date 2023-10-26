//object6.js
//map set


const map = new Map();   //키, 값 //맵 인스턴스 생성 
map.set('홍길동' , 80);              //맵에 키랑 값 넣기 
map.set('김길동' , 85);              
map.set('김길동' , 90);         //키 값이 똑같은거 넣으면 전에 꺼 덮어써버림 ... 
//map.delete('김길동');   //값 삭제 

const refval = [12];  //주소값을 가져옴 //이걸 갑자기 왜..............? 
//[12]배열객체래..   refval랑 [12]는 다른 객체임 
//let val1 = {}랑  let val2 = {} 랑 다른것처럼... 


console.log('dddddd' + refval)
map.set(refval,88);       // 키:refval,   값: 88 ; 넣기 
console.log(map.get(refval));   //get(key)를 넣어서 88이란 값 얻기 


console.log('-----------------')

console.log(map.get('홍길동')); 


       
for(let ent of map.entries()){        //키와 값을 반환. !!!배열타입!!!으로 반환해주는 entries함수  ent에는 배열이 저장되어있음 
	console.log(ent);
}



console.log(map.get('홍길동'));        
for(let ent of map.entries()){        //ent에는 배열이 저장되어있음 
	console.log('이름' + ent[0] + '점수'+ent[1]);
}



map.forEach(function(val,key,map){ 
	if(val > 80)  {
	console.log(val,key,map);
		
	}                 //값, 키, 맵 그자체 순서대로 출력됨 
})



map.forEach(function(v,k,m){ 
	if(k == "홍길동")                     //홍길동의 점수를 보고싶을떄 
	console.log(v,k,m);
})



//맵 <--> 배열.  //배열안에 배열 이 선언된거 
const ary = [['프로도' , 3] ,['라이언' ,5] , ['어피치' , 4]];
const fmap = new Map(ary);               //배열을 맵타입으로 바꾸려면   Map(생성자 = 배열);

for(let ent of fmap.entries()){
	console.log('키'+ ent[0] + '값' + ent[1]);
}


const entries = fmap.entries();
console.log(entries);       //entries : MapIterator 타입 

console.log(Array.from(fmap));
//맵을 배열로 바꾸려면 



//Set: 중복값 허용 X 
const set1 = new Set();
set1.add("라이언");
set1.add("프로도");
set1.add("어피치");
//set1.add({ name:"어피치" , pont:4});
set1.add( ["어피치" , 4]);
set1.add( ["어피치" , 4]);     //뭐가 같은데?????????????사이즈가 달라진다고??????????????????????????????

console.log(set1.size);   //크기가 3이라는 말 
set1.forEach(function(val,item,set){
	console.log(val,item,set);
})



//배열을 셋으로 
const setAry = ['라이언' , '프로도' , '무지' , '무지']    //배열을 > set타입으로 할께요
const set2 = new Set(setAry);
console.log(set2.size)   // 배열을 셋으로 만들면 중복된 값 ㅈㅔ거되어져서 나옴 



//셋 > 배열로 
console.log(Array.from(set2));
