//domtable.js


export default {


	makeHead: function(titles) {
		let thead = document.createElement('thead');
		let tr = document.createElement('tr');
		titles.forEach(obj => {
			let th = document.createElement('th');
			th.innerHTML = obj;
			tr.append(th);
		})
		thead.append(tr);
		return thead;
	}, //헤드


	makeBody: function(dataAry = [{}, {}]) {  //배열이 들어옴 

		let tbody = document.createElement('tbody');
		dataAry.forEach(obj => {
			tbody.append(this.makeTr(obj));
		})
		return tbody;

	},//바디

	makeTr: function(center = {}) {  //객체가들어옴 tr.td 만듦 
		let tr = document.createElement('tr')
		for (let prop in center) {
			let td = document.createElement('td')
			td.innerHTML = center[prop];
			tr.append(td);
		}

		return tr;
	}//tr


}//end 