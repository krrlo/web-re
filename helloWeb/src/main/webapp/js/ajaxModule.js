//ajaxModule.js   //1027

const table = {

	makeHead(titles = ['회원아이디', '비밀번호', '이름', '연락처']) {
		let head = "<thead><tr>";
		titles.forEach(title => {
			head += "<th>" + title + "</th>"
		})
		head += "</tr></thead>"
		return head;
	},


	makeBody(dataAry = [{ mid, pass, name, phone }]) {    //[{}] 배열 형태로 들어옴 
		let body = "<tbody id = 'list'>";
		dataAry.forEach(obj => {                         //배열안에있는 객체 하나가 들어옴 
			body+=this.makeTr(obj)
		}) //for each 
		body += "</tbody>";
		return body;
	},



	makeTable(titleAry, dataAry) {
		let table = "<table border = '1'>";
		table += this.makeHead(titleAry) + this.makeBody(dataAry);
		table += "</table>";
		return table;

	},


 //객체의 속성 값을 빼낼때 //그 값으로 한줄 추가하는 tr td생성
 //tr부분을 클릭하면 수정가능하게 만들기 
 //이벤트 = 이벤트 핸들러 
 	   	makeTr(obj) {  //객체 하나가 들어옴 
		let body ='';
		body += "<tr onclick ='showInfo(event,this)'>";   //매개값으로 이벤트와 this를 넘김    //this는 선택된 tr을 가르킴 
		for (let prop in obj) {
			body += "<td>" + obj[prop] + "</td>"
		}
		body += "</tr>"

		return body;   //한줄 만들어서 리턴 
	}



}//table


export { table }    /// table객체 