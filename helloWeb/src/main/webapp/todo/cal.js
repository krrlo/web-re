//cal.js




const h = ['일', '월', '화', '수', '목', '금', '토'];  //헤드 만들 글 넣기 


function makecal(h = []) {           //얘를 html에 넣기 
	let head = '';
	head += '<table border = 1>';
	head += '<thead>';
	head += '<tr>';
	h.forEach(obj => 
		head += '<th>' + obj + '</th>'
	);
	head += '</tr>';
	head += '</thead>';
	head += this.makebody();            //tbody 넣기 
	head += '</table>';

	document.getElementById('show').innerHTML += head;
}





function makebody() {
	let body = '';
	//let style = '';
	body += '<tbody>';
	body += '<tr>';
	for (let i = 1; i <= 31; i++) {
		if(i % 7 == 1){    //일요일이면 글자 빨간색 
			body += '<td style="color:red;">' + i + '</td>';
		}else{
			//body += '<td>' + i + '</td>';         //아니면 그냥 
			if(i == today.getDate()){   //오늘날자에는 파란색 
			body += '<td style="color:yellow;">' + i + '</td>';
			}else if(i % 7 == 0){  //토요일에 파란색 
				body += '<td style="color:blue;">' + i + '</td>';
			}
			else{  //아무것도아니면 그냥 출력 
				body+='<td>'+i+'</td>';
			}	
		}
		
		if (i % 7 == 0) { 
		         // 7마다 줄바꿈 
			body += '</tr><tr>';
		}
		
	}//포
	
	body += '</tr>';
	body += '</tbody>';


	return body;

}

makecal(h);       //함수실행 



