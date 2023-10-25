//object4.js

const obj = {   //객체생성 
	sno:1001,
	sname:'홍길동',
	address:'대구중구 100번지',
	friends:[
		{name : '김민수' , phone: '010-1111'},
		{name : '최현수' , phone: '010-2222'},
	],
	hobbies :[
		'독서' , '영화보기' , '여행','요리'
	]
}


obj.addFriend =function (friend){
	this.friends.push(friend);  //this는 객체를 가르킴 . 
}

obj.addFriend({name: '박현수', phone: '4444444'});




//필드새로추가
obj.pets = ['고양이','멍멍이..','멧돼지']  //밖에서 바로 정의해서 써도됨 
console.log(obj.pets[2]);
obj.pets[2] = '붕어';   //값 바꾸고싶을때
console.log(obj.pets[2]);



console.log('이름' , obj['sname']);
console.log('친구는' , obj.friends.length,'명입니다');
console.log('첫번째 친구이름:' , obj['friends'][0].name);
obj['friends'][1]['phone'] = '010-3333';
console.log('2번째 친구번호:' , obj['friends'][1]['phone']);
obj.hobbies.forEach(hobby => console.log(hobby));