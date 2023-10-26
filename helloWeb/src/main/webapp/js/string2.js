	//string2.js
	
	const strr = 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime aliquid, dicta quas laudantium doloribus tenetur atque laborum ut itaque at, magni asperiores cumque sed aspernatur, dolores tempore officiis nisi explicabo?';
	
	
	//1.공백을 기준으로 가져온 단어의 크기가 5보다 큰 문장을 콘솔출력 
	
	
	let jj = strr.split(' '); 
	 //공백 기준으로 단어 잘라서 배열만들기 
	
	//배열돌리기 // 
	
	console.log(jj);
	//for in 객체의 속성 값을 꺼낼때  //for of 배열의 값 
	//잘린 단어들이 들어있는 배열 이름 jj 
	for (let i = 0; i < jj.length; i++) {
		if (jj[i].length > 5) {     // jj배열의 i번째 인덱스에 있는 단어의 길이가 5보다 크면   .. 그 단어를 출력 
			console.log(jj[i]);
		}
	}
	
	
	
	
	//2.생년월일 입력 => 남자/여자,
	
	check('9503054678532');
	
	function check(ssn) {
		// 어떤 형태로 들어오건 분간해야댐 
	
	result=ssn.slice(-7)    //뒤에서부터 7자리 .. 
	console.log(result)
	
	if(result.charAt(0) ==3){
		console.log("남자")
	}else{
		console.log("여자")
	}	
		}
	
	
	
	//3. 파일명과 파일의 확장자.
	let file = "d:/temp/sample/book.xls";  //이건계속 바뀔수있대
	// let fileName, fileExt
	
	
	let j = file.indexOf('.');
	console.log(j);  //26
	
	let fileExt = file.substr(j + 1, 3);   // 점의 위치로 파일확장자찾기 1 
	console.log('확장자는', fileExt);        //점의 위치 + 1 부터 3개 가지고오기 
	
	
	
	let ary = file.split('.');   // 점을 기준으로 배열 나눔 파일확장자찾기2 
	console.log(ary);  //['d:/temp/sample/book', 'xls']
	let fileExt2 = ary[1];               //dd 배열의 1번째 인덱스의 방 값이 xls임 
	console.log('확장자2는' , fileExt2);
	
	
	
	let ary2 = ary[0].split('/');     
	console.log(ary2);   //['d:', 'temp', 'sample', 'book'] 
	
	let fileName = ary2[ary2.length-1];
	console.log("파일이름은" , fileName)          //파일이름찾기 1
	
	
	
	let r=file.lastIndexOf('/')
	console.log(r);
	let rr = file.substr(r+1 , 4);
	console.log(rr); 						//파일이름찾기 2
	
	
	
	
