      //함수 선언 
   //     function myFucn(std,score =60){      //파라메타  //함수만들기 자스는 타입따로없음  변수이름만 적어주면됨   //새창띄우기 이클립스에서 run as
          //  if(score == undefined){
          //      score = 0;  //이거 없으면 언디파인드 , 초기값 지정 가능  score =60) 값안들어오면 초기값
          //  }
   //         console.log(`${std}의 점수는 ${score}입니다`)
   //         return score; // undefined 리턴 구문이 없으면 언디파인이 반환 
   //     }

     //함수표현식

     var myFucn = function myFucn(std,score =60){
        //  if(score == undefined){
          //      score = 0;  //이거 없으면 언디파인드 , 초기값 지정 가능  score =60) 값안들어오면 초기값
          //  }
          console.log(`${std}의 점수는 ${score}입니다`)
            return score; // undefined 리턴 구문이 없으면 언디파인이 반환 

     }
    

       // let myFucn = myFucn('홍길동');
        //myFucn('이주은');  //호출해야 실행됨  //arguement  //값을 다 안넣으면 undefind값이라고 뜸 

        console.log(myFucn('홍길동'));