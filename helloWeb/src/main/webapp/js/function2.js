///function2
console.log('dddddd');


//js객체 만드는 방식  1 
// Member memeber = new Member();  자바 
const member = {
 name: "홍길동",    //name =속성   값 = 홍길동 
 age:18,
 heigth: 178.9,
 showInfo : function(){           //객체안에 정의 되어있는 함수 메소드 
  // console.log(`이름은 ${this.name} 이고 나이는 ${this.age}입니다`)    
  return (`이름은 ${this.name} 이고 나이는 ${this.age}입니다`)  
  
  //해당되는 객체 자신 인스턴스 this의 뭐뭐
 }
}


const member1 = {
    name: "김길동",    //name =속성   값 = 홍길동 
    age:18,
    heigth: 170.9,
    showInfo : function(){           //객체안에 정의 되어있는 함수 메소드 
     // console.log(`이름은 ${this.name} 이고 나이는 ${this.age}입니다`)    
     return (`이름은 ${this.name} 이고 나이는 ${this.age}입니다`)  
     
     //해당되는 객체 자신 인스턴스 this의 뭐뭐
    }
   }


   const member2 = {
    name: "박길동",    //name =속성   값 = 홍길동 
    age:20,
    heigth: 180.9,
    showInfo : function(){           //객체안에 정의 되어있는 함수 메소드 
     // console.log(`이름은 ${this.name} 이고 나이는 ${this.age}입니다`)    
     return (`이름은 ${this.name} 이고 나이는 ${this.age}입니다`)  
     
     //해당되는 객체 자신 인스턴스 this의 뭐뭐
    }
   }


   member.showInfo();  //member안에있는 showInfo 메소드 호출 


 const members = [member,member1,member2]  //새로운 배열 생성 


///////////////////
let show = document.getElementById('show')   //show라는 아이디값 찾아간다   // 아이디 값이 show인  ...  document = page가 그려지는 위치 
console.log(show);  //  
console.log(typeof show); // object 
//show.innerHTML = "<ul><li>Apple</li><li>banana</li></ul>";   //화면에 나타남 
//show.innerText ="<ul><li>Apple</li><li>banana</li></ul>";    //그대로 나옴 
//table>thead>tr>th*2  + tbody>tr>td*2 
 
// table>tbody>(tr>td*4)*3


let str = "";
str += '<table border = 1>';
str += '<tbody>';
members.forEach(function(item){
    str += makeTr(item)
})
str += '</tbody>';
str += '</table>';

show.innerHTML = str;   
console.log(str)

function makeTr(member={name , age, heigth, showInfo}){        //테이블만드는 함수 생성  함수로 오는 매개변수의 타입이 오브젝트타입으로 할거다 
   let html = '';
   html +='<tr>';
   html += '<td>' + member.name + '</td>'
   html +=  '<td>' + member.age + '</td>'
   html +=  '<td>' + member.heigth + '</td>'
   html +=  '<td>' + member.showInfo() + '</td>'
   html +='</tr>';
   return html;
}


//console.log(makeTr(member));

