//student.js
//학생 전체리스트 보여주는 페이지 로딩되면서 바로 실행되는 코드...........
//비동기 방식 코드 > 순차적 가독성 높이기, async, await
//fatch를 수정 
//async 함수(
//	await 처리 . promise 객체 타입으로 반환해줘야 await처리됨 
//	await 처리   await = 처리될때까지 다음단계로 안넘어감 
//	await 처리
//)

import svc from './service.js';


//학생 전체 목록 출력 
svc.studentList(
	//성공하면 실행할 함후 
	result => {
		console.log(result);
		let tbody = document.querySelector('#list');
		result.forEach(student => {
			tbody.append(makeTr(student));    //trtd만들어서 붙힘 
		})
	},
	err => console.log('에러', err)
); // 


/*fetch('../studentList.do')  //서블릿 실행 
	.then(resolve => resolve.json())     //자바객체타입으로바꿈 
	.then(result => {
		console.log(result); //	out.print(json); 한 애들이 들어와있음  학생리스트들 
		let tbody = document.querySelector('#list');
		result.forEach(student => {
			tbody.append(makeTr(student));    //trtd만들어서 붙힘 
		})
	})
	.catch(err => console.log('에러', err))*/


/*async function studentList() {
	let req = await fetch('../studentList.do');   //리스트들이 req에 담겨있음 프로미스 객체로 반환됨 
	let json = await req.json();     //제이슨 문자열을 자바스크립트 객체로 바꿔줌 {"code" : "ok"} ->  객체 {code : "ok"}  //code속성에 ok라는 값 
	let tbody = document.querySelector('#list');

	try {
		json.forEach(student => {
			tbody.append(makeTr(student));
		})
	} catch (err) {
		console.log(err)
	}
}*/




//등록버튼누르면 저장하게끔 이벤트 등록 
document.querySelector('#addBtn').addEventListener('click', addCallback);



//수정버튼 이벤트 서블릿(db변경) > 변경되었으면 화면에서 수정된 값이 출력되도록하기
document.querySelector('#modBtn').addEventListener('click', modCallback);



//등록버튼 callback함수 정의 
function addCallback(e) {
	console.log(e);
	//사용자가 입력한 등록정보를 변수에 담음 
	let sid = document.querySelector('input[id=sid]').value;    //속성이sid인 인풋태그를 찾아와라
	let sname = document.getElementById('sname').value;  // document.querySelector('#sname').value;  
	let pw = document.getElementById('pw').value;         //document.querySelector('input[name=pass]').value 로 쓰던지
	let sdept = document.getElementById('sdept').value;
	let birth = document.getElementById('birth').value;
	console.log(sid, sname, pw, sdept, birth);  //값이 제대로 나오는지 확인,
	// 서블릿에 전달해줄 값들 
	let param = `id=${sid}&name=${sname}&password=${pw}&dept=${sdept}&birthday=${birth}`;
	console.log(param);
	//id,name,password,dept,birthday >>파라메타 이름 공란 쓰지마  

	//ajax호출해서 값을 전달함 
	//fetch('../addStudent.do?' + param)  //서블릿에 보냄  >> get방식 요청 
	//get 방식 :url 패턴 , 값의 제한이 있음 . 비번 다 노출됨  
	//post방식 : 파라미터 표현 안됨 , 값의제한 없음 , content-type지정. 

	svc.addStudent(
		//optObj;
		{
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: param
		},
		//성공하면 실행할 함수

		result => {
			if (result.retCode == 'OK') {
				alert('등록성공');
				//등록한 애를 화면에 한줄 추가해야하니까    //필드명 : 실제 등록한 값 
				let tr = makeTr({ studentId: sid, studentName: sname, studentBirthday: birth })
				document.querySelector('#list').append(tr)  //추가한 한 행을 list에 붙혀 
			} else {
				alert('등록실패');
			}
		},
		//실패하면 실행할 함수

		err => console.log('에러' + err)

	);

	/*fetch('../addStudent.do', {
		method: 'post',   //post방식으로 요청 디폴트는 get
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' }, //컨텐트타입을키:value형식으로보냄 //공백안됨
		body: param //서블릿에 실제 넘어갈 데이터 
	})
		.then(resolve => resolve.json()) // 등록여부 코드를 받아와서 자바타입으로 변환 
		.then(result => {
			if (result.retCode == 'OK') {
				alert('등록성공');
				//등록한 애를 화면에 한줄 추가해야하니까    //필드명 : 실제 등록한 값 
				let tr = makeTr({ studentId: sid, studentName: sname, studentBirthday: birth })
				document.querySelector('#list').append(tr)  //추가한 한 행을 list에 붙혀 
			} else {
				alert('등록실패');
			}
		})
		.catch(err => console.log('에러' + err))*/

} //addCallback 이벤트 


//수정버튼 callback함수 정의 
function modCallback() {
	//사용자가 입력한 수정 값을 변수에 담음 
	let id = document.querySelector('input[name=sid]').value;  //어케알지..?
	let pass = document.querySelector('input[name=pass]').value;
	let name = document.querySelector('input[name=name]').value;
	let birth = document.querySelector('input[name=birth]').value;
	let param = `id=${id}&name=${name}&password=${pass}&birthday=${birth}`;


	svc.editStudent(
		//optObj;
		{
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: param
		},
		//성공하면 실행할 함수

		result => {
			console.log(result);      //{vo: {…}, retCode: 'OK'}    
			if (result.retCode == 'OK') {
				alert('수정성공');  //수정 성공했으면 
				//let tr = makeTr({studentId: result.vo.studentId, studentName: result.vo.studentName, studentBirthday: result.vo.studentBirthday })
				//document.getElementById('list').innerHTML += tr;  //추가한 한행을 화면에 
				let targetTr = document.querySelector('tr[data-sid=' + result.vo.studentId + ']');  //수정 전 애 
				let newTr = makeTr(result.vo);  //바꿀애 
				let parentElem = document.querySelector('#list');
				parentElem.replaceChild(newTr, targetTr);   //부모 요소에서 자식 요소 바꿀때..?  새로운값, 바꿀대상 
				console.log(document.getElementById("myModal"));
				document.getElementById("myModal").style.display = 'none';  //수정완료되면 창닫음 
			} else {
				alert('수정실패');
			}
		},
		//실패하면 실행할 함수	
		err => console.log('에러' + err)

	);


	//변수에 담은 값을 서블릿에 보내 
	/*fetch('../editStudent.do', {
		method: 'post',   //post방식으로 요청 디폴트는 get
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' }, //컨텐트타입을키:value형식으로보냄 //공백안됨
		body: param //실제 서블릿에 넘어갈 데이터 
	})
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);      //{vo: {…}, retCode: 'OK'}    
			if (result.retCode == 'OK') {
				alert('수정성공');  //수정 성공했으면 
				//let tr = makeTr({studentId: result.vo.studentId, studentName: result.vo.studentName, studentBirthday: result.vo.studentBirthday })
				//document.getElementById('list').innerHTML += tr;  //추가한 한행을 화면에 
				let targetTr = document.querySelector('tr[data-sid=' + result.vo.studentId + ']');  //수정 전 애 
				let newTr = makeTr(result.vo);  //바꿀애 
				let parentElem = document.querySelector('#list');
				parentElem.replaceChild(newTr, targetTr);   //부모 요소에서 자식 요소 바꿀때..?  새로운값, 바꿀대상 
				console.log(document.getElementById("myModal"));
				document.getElementById("myModal").style.display = 'none';  //수정완료되면 창닫음 
			} else {
				alert('수정실패');
			}
		})
		.catch(err => console.log('에러' + err));*/
}
///modCallback 이벤트 


///tr생성함수 이거자체가 forEach로 돌려지고있음  
//추가,수정,삭제할때의 tr을 조절 하려고
function makeTr(obj) {   //학생 객체 하나가 들어옴 
	let showF = ['studentId', 'studentName', 'studentBirthday'];
	let tr = document.createElement('tr')
	tr.setAttribute('data-sid', obj.studentId);  //들어온 학생 객체의 id를 tr에 저장  <tr data-sid="10">
	tr.addEventListener('dblclick', showModal);    //tr을 더블클릭하면 모달이 보이게하는 이벤트 등록 

	for (let prop of showF) {
		let td = document.createElement('td')
		td.innerHTML = obj[prop];       //obj[studentId] = 그 값이 나옴   
		tr.append(td);
	}  //들어온 값으로 tr 한줄 완성 

	//삭제버튼만들기 
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('data-sid', obj.studentId);    //버튼에 sid를 담아놓음 ... 삭제할때 쓸려고  <tr data-sid="10">
	btn.innerHTML = '삭제';

	btn.addEventListener('click', function(e) {
		console.log(e);          //버튼을 클릭하면 삭제되는 이벤트 등록 
		//ajax호출 -> 서블릿 실행  // 지워야할 애의 아이디 값을 서블릿으로 보냄 

		svc.removeStudnet(obj.studentId,

			//성공하면 실행할 함수 

			result => {          //서블릿 resp.getWriter().print 해서 보낸 값이 들어옴 
				console.log(result);   //{retCode: 'OK'}
				if (result.retCode == 'OK') {
					alert('삭제성공');
					tr.remove();  //그 tr을 지운다 
				} else {
					alert('삭제실패');
				}
			},

			//실패하면 실행할 함수
			err => console.log('에러' + err)

		);



		/*fetch('../delStudent.do?sid=' + obj.studentId)  //서블릿에 값을 전달함  
			.then(resolve => resolve.json())  //서블릿으로 부터 받아온 결과를 자바 타입으로 변환 
			.then(result => {          //서블릿 resp.getWriter().print 해서 보낸 값이 들어옴 
				console.log(result);   //{retCode: 'OK'}
				if (result.retCode == 'OK') {
					alert('삭제성공');
					tr.remove();  //그 tr을 지운다 
				} else {
					alert('삭제실패');
				}
			})
			.catch(err => console.log('에러' + err)) */

	})//버튼을 누르면 그 tr이 삭제가 되는 이벤트 등록 
	td.append(btn);
	tr.append(td);
	return tr;  // 삭제버튼 포함 학생한명 tr 완성 
}//maketr


//클릭하면 모달이 뜨게하는 이벤트 생성 
function showModal(e) {
	console.log(e.target.parentElement, this);
	//클릭당한 애의 아이디를 읽어와야함 
	let id = this.children[0].innerHTML;  // 이렇게 읽어오던지 
	id = this.dataset.sid;  // tr에 'data-sid = st1 값 넣어놨으니까  이렇게 읽어오던지
	console.log(id);  // id값 나옴    


	// Get the modal
	//클릭하면 클릭한거의 아이디값을 조회해서 그 애가 나오게해야함 



	svc.getStudent(id,

		//성공하면

		result => {
			console.log(result); //	out.print(json); 수정할 학생 1건의 정보  

			var modal = document.getElementById("myModal");
			modal.style.display = "block"; //창 뜨게 

			//result안에있는 값들을 빼내서 새로운 변수에 저장 
			let data = {
				id: result.studentId,
				name: result.studentName,
				pass: result.studentPassword,
				birth: result.studentBirthday
			};

			console.log(data);
			//수정상자안에서 조회되는 1건의 학생 정보 
			modal.querySelector('h2').innerHTML = data.name;
			modal.querySelector('input[name=pass]').value = data.pass;
			modal.querySelector('input[name=name]').value = data.name;
			modal.querySelector('input[name=birth]').value = data.birth;
			modal.querySelector('input[name=sid]').value = data.id; //얘는 화면에서 숨김 


			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];


			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
				modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";   //버튼을 클릭하면 블럭형태로 나오게 
				}
			}

		},

		//실패하면


		err => console.log('에러', err)

	)



	//let param = `id=${id}`
	/*fetch('../getStudent.do?' + `id=${id}`)   //서블릿에 값을 전달 
		.then(resolve => resolve.json())     //자바객체타입으로바꿈 
		.then(result => {
			console.log(result); //	out.print(json); 수정할 학생 1건의 정보  

			var modal = document.getElementById("myModal");
			modal.style.display = "block"; //창 뜨게 

			//result안에있는 값들을 빼내서 새로운 변수에 저장 
			let data = {
				id: result.studentId,
				name: result.studentName,
				pass: result.studentPassword,
				birth: result.studentBirthday
			};

			console.log(data);
			//수정상자안에서 조회되는 1건의 학생 정보 
			modal.querySelector('h2').innerHTML = data.name;
			modal.querySelector('input[name=pass]').value = data.pass;
			modal.querySelector('input[name=name]').value = data.name;
			modal.querySelector('input[name=birth]').value = data.birth;
			modal.querySelector('input[name=sid]').value = data.id; //얘는 화면에서 숨김 


			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];


			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
				modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";   //버튼을 클릭하면 블럭형태로 나오게 
				}
			}

		})//then
		.catch(err => console.log('에러', err))*/

}//showModal end
