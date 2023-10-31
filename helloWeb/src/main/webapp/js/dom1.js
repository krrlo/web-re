//dom1.js


const fruits = ['수박', '사과', '복숭아', '포도' ]

//#show>ul>li:수박..




document.getElementById("show").innerHTML= '<ul>'


let li1 =document.createElement('li');
li1.innerHTML='수박';
document.querySelector('ul').appendChild(li1);


let li2 =document.createElement('li');
li2.innerHTML='사과';
document.querySelector('ul').appendChild(li2);


let li3 =document.createElement('li');
li3.innerHTML='복숭아';
document.querySelector('ul').appendChild(li3);


let li4 =document.createElement('li');
li4.innerHTML='포도';
document.querySelector('ul').appendChild(li4);





//수업코드
//#show>ul>li:수박+li:사과+li:복숭아+li:포도

//ul생성 
const ul = document.createElement('ul');   //ul태그 만들겟습니다 ,, 

//li생성 
fruits.forEach(obj => {
	const li = document.createElement('li');  //li만들게요 
	li.innerHTML = obj;  //그 li에 과일 이름 넣기 
	ul.appendChild(li);    //ul의 자식으로 만들어진 li넣기 
	
})       //한바퀴 돌면 li하나 만들어짐 !!     //전부 돌면 ul밑에 모든 li들이 생성된 상태 

document.getElementById('show').appendChild(ul);  //show밑에  만들어진 ul넣기 
//화면에 보이는 시점 