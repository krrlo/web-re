//object5.js 객체 복사 
const obj1 = {
	name:"hong",
	age : 20,
	weight:66
	//객체 속성추가하기 
}

//객체 속성 추가하기 객체의 속성기술자를 활용하여 
//obj1.bloodType = "O";
//obj1이라는 객체에 속성에 bt라는 것을 정의하겠습니다    
//속성 값을 받을때 조건 걸려면 

Object.defineProperty(obj1, 'bT',{   //obj1객체에 bT속성 추가하겠습니다  속성 추가할수있는 메서드 
	set : function(bt){
		if(bt == "A" || bt == "B" || bt == "AB" || bt == "O"){
			this._bT = bt;   //bT필드에 들어온 bt값 넣기 
		}else {
			console.log('없는 유형임');
			this._bT = "A";   //기본값세팅해줌 
		}
	},
	
	get : function(){
		return this._bT;
	}
		//얘네는 메소드가 아니라 필드래 .. 
})   ///메서드                    


obj1.bT = "C";   //set  obj1객체의  bT필드에 값을저장 
console.log(obj1.bT);   //get
  //set get이 지정되어있어야 값을 저장하거나 불러오는게 가능  


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const obj3 = obj1; //3에서 바꾼값이  1에서 바뀜  obj1의 주소값을 obj3가 참조하고 있음 // 주소를 참조하는 형태 


//객체를 만드는 방식
//아예 새로운 객체 만드는거   1,2 는 다른애임   //복사해주는거 
const obj2  = Object.assign({name:"h", age:22 , height :123},obj1);    // {}도 객체임    obj1의 값을 {}에 담음  담은걸 obj2에 참조시키는중 
console.log(obj2)  //결과 : name hong  age 20 height 123 weight66 bt a 

//{}에 값이 할당되어있으면 덮어쓰기됨
//있는 속성이면 1으로 대체 되고
//없는 값이거나 새로나온건 신규값으로..



////상속  부묘의 요소로 새로운 객체를 만듦     >> 자식 값 바뀌기 전에는 부모객체 참조  >>  부모 바뀌면 자식도 바뀜 
const obj4 = Object.create(obj1); ///obj1을 참조하는 obj4 생성 
obj4.name = 'k';  //자식바꿈 (상속에서 벗어나는 시점) 값이 변경되는ㅅ ㅣ점 .  부모와는 다른 값을 유지하도록 함 
obj4.age = 40;     //자식 바뀜  부모와 별개의 값 유지 

obj1.name='j';    //부모바뀜  >> 자식 이름도 j로 바뀜 

console.log(obj4)  //맨 처음 자식 값 안바꿀떄는 참조 값이 출력됨  {}  // 자식 값 바꾸고 나면 자식객체의 값대로 출력됨   //{name: 'k', age: 40}
console.log(obj4.name);  //>j
console.log(obj4.age); //>20






