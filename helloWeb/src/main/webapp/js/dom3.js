//dom3.js

let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=FT0T1GIASo3H1YMtuIqZIb612ZTiTYOOTyZ0SMTilcHe4DM0xX8iVRPGxyl1e1omWPg0U4tWsYY7p31P%2BtWHFQ%3D%3D'
import table from './domTable.js';

let titles = ['센터id', '센터명', '시도', '연락처' , '주소'];


//table>thead>tr>th*5  +tbody>tr>td*5
//page284 수정 

fetch(url)   //url을 promise 객체로 만들어줌 
	.then(resolve => resolve.json())  //<< function(resolve) {return resolve.json()} //자바형태로 변형
	.then(fetchCallback)            //then함수에 매개값으로 함수가들어감 
	.catch(err => console.log('에러에러!!', err));



//fetch 호출되는 함수 .callback함수 
function fetchCallback(result) {
	console.log(result); //Object 안에 data에  rawdata들이 들어있음 
	let rawdata = result.data;  // rawdata = [{},{}]
	console.log(rawdata); //원래의  데이터 


	let sidoary = []; // 중복된 값이 제거된 시.도명이들어가있음 

	for (let val of rawdata) { // rawdata = [{},{}]
		if (sidoary.indexOf(val.sido) == -1) {    //sidoary배열에  val.sido가 없으면 추가 
			sidoary.push(val.sido)
		}
	}

	//console.log(sidoary); ///시도 이름이 들어간 sido = []배열  출력 


	//17개 시도 옵션 추가 
	sidoary.forEach(obj => {
		let option = document.createElement('option');
		option.innerHTML = obj;
		document.querySelector('#sidoList').append(option)

	})


	//////////////////////////////////
	//select 태그에 change이벤트 발생시키기 <원하는 시도 선택하면 그 시도만 보이게>

	document.querySelector('#sidoList').addEventListener('change', changeCallback); // change이벤트가 발생하면!! changeCallback();하면안됨 
	function changeCallback(e) {    //이벤트가 발생하면 함수를 실행하세요 
		console.log(e.target.value);  //광주광역시 클릭하면.. 
		let search = e.target.value;    //ex) 광주광역시를 선택하면  search에 광주광역시 들어감 

		//선택된 시도 값에 맞는 센터명만 출력하고싶음 
		let filterAry = rawdata.filter(center => {
			return center.sido == search;             //광주광역시만 골라담기 
		})   //조건에 만족하는 애들만 배열에 추가해줌 

		console.log(filterAry)  //광주광역시 애들만 나옴   [{…}, {…}, {…}, {…}, {…}, {…}
		genTable(filterAry)   //그걸로 테이블 만듦    // 광주광역시 , 1페이지 나오게 

	}///이벤트함수 


	//첫 화면으로 출력할 애들 지정 
	//return center.sido == '서울특별시';
	let filterAry = rawdata.filter((center, idx) => idx < 20)
	genTable(rawdata)


}// end fetchCallback




//선택된 데이터로 화면에 보여지게 하는 함수 
function genTable(rawdata = [], page = 1) {
	
	
    //헤드만들기 	
	let thead = table.makeHead(titles); 
	console.log(thead);


	//초기화 안하면 밑에 그려짐 
	document.querySelector("#show").innerHTML = '';

	//한페이지에 데이터 몇행 나오게할지 
	let startNo = (page - 1) *10; // rawdata의 0번 인덱스부터 
	let endNo = page * 10;   //   9번 인덱스 데이터 출력 


	//첫번째, 마지막 페이지 버튼 계산하기 
	let totalCnt = rawdata.length;  
	let lastPage = Math.ceil(totalCnt / 5); //전체 페이지 기준 
	let endPage;
	if(page == 1 || page == 2 || page == 3){          //페이지가 1.2.3일때는 endPage가 5가되게, 그 이후로 endpage는 현재페이지의 +2 
	    endPage= Math.ceil(page/5)*5;
	}else{
		endPage = page +2;
	}
	
	    //현재페이지 기준으로  = 5 
	let beginPage = endPage -4;  //1
	
	/// 이전페이지  , 이후페이지 버튼 생성하려고 조건 검 
	let prevPage =false,  nextPage= false;
	if(beginPage > 1){             
		prevPage = true;
	}
	if(endPage<lastPage){  // 지금현재 창 마지막페이지 << 진짜 최종페이지 
		nextPage=true;     // 뒤에 페이지 더 있다는 말 
	}
	if(endPage >lastPage){          
		endPage = lastPage;
	}
	
	document.querySelector('.pagination').innerHTML = '';
	//이거왜해??????????????????????
	
	
   //이전페이지 여부 
   if(prevPage){   //이전 페이지가 존재하면 
	   let aTage = document.createElement('a');  //a태그 생성
		aTage.setAttribute('href', '#');        
		aTage.innerHTML = '&laquo';               //<<표시 넣고 
		aTage.addEventListener('click', function(e) {   // <<를 클릭하면 그 전 페이지가 나오게
			genTable(rawdata, beginPage-1)
		})
		document.querySelector('.pagination').append(aTage); //.pagination 태그 밑에 
		//만든 a태그 달아라 
   }	
   
 
   
	
  //페이지 숫자  만들기 
	for (let i = beginPage; i <= endPage; i++) {
		let aTage = document.createElement('a');
		aTage.setAttribute('href', '#');
		aTage.innerHTML = i;
		if(i == page){
			aTage.setAttribute('class' , 'active')  //초록색 표시 적용되게 
		}
		aTage.setAttribute('data-page', i);
		aTage.addEventListener('click', function(e) {
			genTable(rawdata, i) //클릭하면 그 페이지의 데이터가 나오게 
		})//이벤트
		document.querySelector('.pagination').append(aTage);
	}




  //이후페이지
    if(nextPage){   //이후 페이지가 존재하면 
	   let aTage = document.createElement('a');  //a태그만들어서 
		aTage.setAttribute('href', '#');
		aTage.innerHTML = '&raquo';   //>>만들고 
		aTage.addEventListener('click', function(e) {   // >>클릭하면 그 다음페이지가 그려지게 
			genTable(rawdata, endPage+1)
		})
		document.querySelector('.pagination').append(aTage);
   }	
   
   
  
	/*let mapData = rawdata.map(center => {//원하는 데이터만 넣으려고  데이터 정리중...   //센터id	센터명 의료원 연락처 만 빼서 만들라고
		let newCenter = {
			id: center.id,
			centerName: center.centerName.replace('코로나19', ''),
			org: center.org,
			phoneNumber: center.phoneNumber,
			lat : center.lat,
			lng : center.lng
		}
		return newCenter;
	});*/


	//한페이지에 몇개의 데이터 행 보여줄지 설정 
	let mapData = rawdata.reduce((acc, center, idx) => {
		if (idx >= startNo && idx < endNo) {   //ex)rawdata인덱스 값이 0 ~ 9 인애들 
			let newCenter = {
				id: center.id,
				centerName: center.centerName.replace('코로나19', ''),
				sido: center.sido,
				phoneNumber: center.phoneNumber,
				lat: center.lat,   //숨길데이터
				lng: center.lng,   //숨길데이터 
				address : center.address
			}
			acc.push(newCenter);   
		}   
		return acc;//acc에는 인덱스가 0~9번인 애들만 들어가있음 
	}, []);


	console.log(mapData);  //만들어진 mapData출력 
	let tbody = table.makeBody(mapData);  //정리된 데이터로 바디 만들기 


	//테이블 출력하기 
	let tbl = document.createElement('table');
	tbl.setAttribute('border', 1)
	tbl.append(thead, tbody);
	document.querySelector('#show').append(tbl);  //show에 table붙힘  


	//지도가져오기 
	//tr클릭 이벤트 등록하기 
	//화면상의 tr 다 가져와서 이벤트 달아야함
	let targetTr = document.querySelectorAll('tbody tr');   //tbody 안에있는 tr만 가져올래요  all일때만 포이치 함수 사용 가능 
	//console.log(targetTr)
	targetTr.forEach(tr => {    //화면상의 tr을 클릭하면 지도가 나오는 이벤트 등록 
		tr.addEventListener('click', function(e) {
			console.log(tr)   //tr을 클릭하면 그 tr의 정보를 콘솔에 출력 
			//console.log(tr.children[4].innerHTML, tr.children[5].innerHTML)
			let lat = tr.dataset.lat;  //위도  tr.setAttribute('data-lat',center.lat); 여기꺼 가져옴 
			let lng = tr.dataset.lng;  //경도
			window.open('daumapi.html?x=' + lat + '&y=' + lng)
		})//이벤트 
	})//포이치 


}//end gentable


