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


	makeBody(dataAry = [{ mid, pass, name, phone }]) {    //객체타입으로 들어옴 
		let body = "<tbody id = 'list'>";
		dataAry.forEach(obj => {
			body += "<tr>";
			for (let prop in obj) {
				body += "<td>" + obj[prop] + "</td>"
			}
			body += "</tr>";
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


	makeTr(obj) {

		let body = '';
		body += "<tr>";
		for (let prop in obj) {
			body += "<td>" + obj[prop] + "</td>"
		}
		body += "</tr>"

		return body;   //한줄 만들어서 리턴 
	}



}//table


export { table }    /// table객체 