	//array5.js 배열을 정렬 해주는..  1027
	
	//console.log(펭수<라이언)  문자비교도 가능???????????????????
	const arr2 = ['펭수', '라이언', '어피치', '콘', '무지'];
	
	arr2.sort(function(a, b) {
		if (a < b) {
			return -1;  //오름차순 
		} else {
			return 1;   //내림차순  걍외워 
		}
	});
	
	
	//arr2.sort();  
	console.log(arr2);   //배열자체를 변경  ㄱㄴㄷ 순으로 
	
	
	const arr3 = [4, 8, 1, 12, 23, 9]
	arr3.sort(function(a, b) {               //a.b 앞 뒤 값 비교 
		if (a < b) {
			return -1;                   //음수값을 반환하면 오름차순 
		} else {
			return 1;
		}
	});
	console.log(arr3);
	
	
	
	////////////////////////////////////
	const json =
	`[{"id":1,"first_name":"Marleah","email":"mcritchlow0@tiny.cc"},
	{"id":2,"first_name":"Barrie","email":"bquinlan1@artisteer.com"},    
	{"id":3,"first_name":"Gram","email":"ghambrick2@google.com.br"},
	{"id":9,"first_name":"Gertrudis","email":"gsweet8@sphinn.com"},
	{"id":10,"first_name":"Travus","email":"tchallener9@discuz.net"}]`;
	
	
	let members = JSON.parse(json);   
	members.sort(function(a, b) {   //배열 이름순으로 정렬 
		if (a.first_name < b.first_name) {
			return -1;
		} else {
			return 1;
		}
	
	}).reverse();   //이름으로 정렬한거를 가져온 값을 뒤집겠다는 뜻 
	
	
	console.log(members);
	
	
	
	
	
	
	
	
