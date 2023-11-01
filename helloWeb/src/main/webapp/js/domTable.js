//domtable.js


export default {

	hiddenFields:['lat' , 'lng'],   ///화면에 숨기려고 
	makeHead: function(titles) {
		let thead = document.createElement('thead');
		let tr = document.createElement('tr');
		titles.forEach(obj => {
			let th = document.createElement('th');
			th.innerHTML = obj;  //th만들고 
			tr.append(th);      //tr에 붙혀
		})
		thead.append(tr);  //thead에 tr 붙혀 
		return thead;
	}, //헤드


	makeBody: function(dataAry = [{}, {}]) {  //배열이 들어옴 

		let tbody = document.createElement('tbody');
		dataAry.forEach(obj => {
			tbody.append(this.makeTr(obj)); // tbody에 만든 tr/td붙힘
		})
		return tbody;

	},//바디

	makeTr: function(center = {}) {  //객체가들어옴 tr.td 만듦 
		let tr = document.createElement('tr')
		tr.setAttribute('data-lat',center.lat);   //값을 담아 놓는다 //tr.dataset.lat
		tr.setAttribute('data-lng',center.lng);                  //tr.dataset.lng
		for (let prop in center) {                 
                if(this.hiddenFields.indexOf(prop) != -1){  //prop 가 'lat' , 'lng' 이면 지나쳐 
					continue;
				}
			let td = document.createElement('td')
			td.innerHTML = center[prop];             
			tr.append(td);
		}//for
		return tr;
	}//tr


}//end export default