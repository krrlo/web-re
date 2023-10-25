  //cal.js



//makeCalendar();



const h = ['일','월','화','수','목','금','토'];


function makehead(h = []){           //얘를 html에 넣기 
	let head = '';
    head += '<table border = 1>';
    head += '<thead>';	
    head += '<tr>';
	h.forEach(function(item){
		head += makeTr(item);
	})
	head += '</tr>';
	head +='</thead>';
	
	console.log(head)
	document.getElementById('show').innerHTML += head;
}




function makeTr(member) {        
		let html = '';                  
		
		html += '<th>' + member + '</th>'
		
		return html;
	}


makehead(h);  //h넣어서 월화수목금토일 헤드만듬

/////////////



function makebody() {
	let body = '';
	body += '<tbody>';
	body += '<tr>';
	for (let i = 1; i <= 31; i++) {
		body += '<td>' + i + '</td>';
		if (i % 7 == 0) {
			body += '</tr><tr>';
		}
	}
	body += '</tr>';
	body += '</tbody>';

	console.log(body)
	document.getElementById('show').innerHTML += body;

}

makebody();



//makeCalendar(); //함수호출하면 화면에 