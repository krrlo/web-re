//string2.js

const strr = 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime aliquid, dicta quas laudantium doloribus tenetur atque laborum ut itaque at, magni asperiores cumque sed aspernatur, dolores tempore officiis nisi explicabo?';


//1.공백을 기준으로 가져온 단어의 크기가 5보다 큰 문장을 콘솔출력 


let jj = strr.split(' ');

//배열돌리기 // 

console.log(jj);
//for in //for of 다름 ,,

for (let i = 0; i < jj.length; i++) {
	if (jj[i].length > 5) {
		console.log(jj[i]);
	}
}

	//2.생년월일 입력 => 남자/여자,

	check('950305-4678532');

	function check(ssn) {
		// 어떤 형태로 들어오건 분간해야댐 
		result = ssn.replace('-', '')
		result = ssn.replace(' ', '')
		// console.log(result);

		if (result.charAt(6) == 3) {
			console.log('남자');
		} else {
			console.log('여자');
		}
	}



	//3. 파일명과 파일의 확장자.
	let file = "d:/temp/sample/book.xls";  //이건계속 바뀔수있대
	let j = file.indexOf('.');
	console.log(j);  //26

	let fileExt = file.substr(j + 1, 3);   // 점의 위치로 파일확장자찾기 1
	console.log('확장자는' , fileExt);



     let dd =file.split('.');   // 점을 기준으로 배열 나눔 파일확장자찾기2 
     console.log(dd);
     let ext=dd[1];
  	 console.log(ext);

   
   
    let r =file.split('/')
    console.log(r);
 	
 	let name = r[3];
 	console.log(name);
 	
 	let namee = name.split('.');
 	
 	let filename =namee[0];
 	console.log('파일명은', filename);  //book나옴.... 
    



