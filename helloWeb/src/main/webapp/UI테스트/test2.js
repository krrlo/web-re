

//test2.js

const novemberCal = {

	makeHead() {
		const days = ['일', '월', '화', '수', '목', '금', '토'];
		let resulttable = '<table border = 1><thead>';
		resulttable += '<tr>'
		days.forEach(title => {
			resulttable += "<th>" + title + "</th>"
		})
		resulttable += "</tr></thead>"
		return resulttable;

	},



	makeBody() {

		let resulttable = this.makeHead();
		resulttable += '<tbody>';
		resulttable += '<tr>';
		resulttable += '<td></td>'
		resulttable += '<td></td>'
		resulttable += '<td></td>'
		for (let i = 1; i <= 4; i++) {
			resulttable += '<td>' + i + '</td>'
		}//포
		resulttable += '</tr><tr>'
		for (let i = 5; i <= 30; i++) {
			resulttable += '<td>' + i + '</td>'
			if (i % 7 == 4) {
				resulttable += '</tr><tr>'
			}

		}//포
		resulttable += '</tr>' 
		resulttable += '</tbody>'

		return resulttable;
	},



	show() {
		
		document.getElementById('show').innerHTML = this.makeBody();
	}


}///novembercal


novemberCal.show();

