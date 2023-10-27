//array4.js  


const json =
`[{"id":1,"first_name":"Marleah","email":"mcritchlow0@tiny.cc"},
{"id":2,"first_name":"Barrie","email":"bquinlan1@artisteer.com"},    
{"id":3,"first_name":"Gram","email":"ghambrick2@google.com.br"},
{"id":9,"first_name":"Gertrudis","email":"gsweet8@sphinn.com"},
{"id":10,"first_name":"Travus","email":"tchallener9@discuz.net"}]`;


let members = JSON.parse(json); 
 //members 배열을 만듬
 
 
 ///////////////////////////find함수
 
 let result = members.find(function(item,idx,ary){
	//console.log(a,b,c);
	
	if(item.id>2){
		return true;
	}else{
		return false;
	}
	
	
	// return item.id == 2;
	 //{id: 2, first_name: 'Barrie', email: 'bquinlan1@artisteer.com'}
	  //id값이 2인애 가지고오기 
 })
 
 
  console.log(result);
  
  
 
  

  
  
  
  ///////////////////////fiiter함수 
  
  
  
  result =members.filter(function(item,idx,ary){
	//  console.log(a,b,c);
	
	  return item.id>2
	  //(3) [{…}, {…}, {…}]  ,  배열로 반환해줌 
  })
  
  
  console.log(result);
  
  
  
   //((item,idx) item지우면안됨 
    //인덱스 2,3 인애만 result에 담고싶다면 
  result =members.filter((item,idx) => {
	//  console.log(a,b,c);
	  return idx>=1 && idx <3   //만족하는 애들을 true가되서 배열로 반환해줌 
	//결과 (2) [{…}, {…}]
  })
  
    console.log(result);
    
    
    
  ///////////////////////////////reudce함수 
  
  result=members.reduce((acc,item,idx) => {
	  if(idx >= 1 && idx <3){
		  acc.push(item);
	  }
	  return acc;   // +item하면안됨 
  },[])
  
  //[]로 초기화 
  


   console.log(result);
   //(2) [{…}, {…}]
    
    
    
 //////////////////////some, every = > true / false를 리턴해줌 
 //이름의 길이가 5개가 넘는 애 
 //some은 배열 돌아서 하나라도 만족하면 true 
 //every는 배열 돌아서 다 만족해야 true
   result = members.some((member) => {
	   console.log(member)
	   //이거 출력이상한데.?????????????????????????????????????다시 
	   return member.first_name.length>5;      //이름의 길이가 5이 넘는 애가 있는지 return
   })                                           //만족하는 애가 있으면 true를 반환함 
    
    
     console.log(result);  //false
    
   
   
 //map: a > b ?????????????????????다시 
 //멤버를 하나 받으면 회원등급을 추가하고싶다  디폴트는 c 
 result = members.map(member => {
	 let obj ={id:member.id, name :member.first_name , email: member.email , grade : 'c'}
	 return obj;   //반환하는 값을 
 })
  
    console.log(result);    //   [{…}, {…}, {…}, {…}, {…}]  성적이 추가된 새로운 배열을 만들어줌  //? 
  
  
  
 