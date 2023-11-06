/**
 *  service.js  .. student.js와 연결된 파일 
 */

export default {

	//학생 전체 목록 가져오기 
	async studentList(successCallback, errorCallback) {   //처리/실패 시 ,,? 사용할 콜백함수를 매개값으로 

		let req = await fetch('../studentList.do');  //서블릿 실행 결과 값이 제이슨타입으로 들어와있음 
		let json = await req.json();   //결과값이 들어있음  객체 타입으로  변환 

		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}
	},

	//학생 한건 조회 
	async getStudent(id, successCallback, errorCallback) {
		let req = await fetch('../getStudent.do?id=' + id);
		let json = await req.json();   //결과값이 들어있음 자스 객체로 바꿈 

		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}
	},

	//추가 
	async addStudent(optObj, successCallback, errorCallback) {

		let req = await fetch('../addStudent.do', optObj);   //optObj 사용자 등록값
		let json = await req.json();   //결과값이 들어있음 자스 객체로 바꿈 

		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}


	},

	//수정
	async editStudent(optObj, successCallback, errorCallback) {

		let req = await fetch('../editStudent.do', optObj);   //optObj 사용자 등록값
		let json = await req.json();   //결과값이 들어있음 자스 객체로 바꿈 

		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}

	},

	//삭제 
	async removeStudnet(id, successCallback, errorCallback) {

		let req = await fetch('../delStudent.do?sid=' + id);   //optObj 사용자 등록값
		let json = await req.json();   //결과값이 들어있음 자스 객체로 바꿈 

		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}

	}


}//end