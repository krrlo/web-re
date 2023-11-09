<%@page import="co.yedam.board.service.BoardVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<style>
#list span {
	margin: 20px;
	margin-bottom: 10px;
	text-align: left;
}

#template {
	margin: 10px;
	margin-bottom: 10px;
	text-align: left;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>



<!--req.setAttribute("bno", vo) bno 에는 vo 객체가 담겨있음  ${bno } -->


<h3>조회화면</h3>

<form action="modifyForm.do" name="myFrm">
	<!-- 수정,삭제 버튼누르면 여기 값이 넘어감 -->

	<!-- 화면상에는 안보이게 , 값은 수정,삭제할때 넘겨줘야하니까 -->
	<input type="hidden" name="bno" value="${bno.boardNo }">

	<table class="table">

		<tr>
			<th>글번호</th>
			<td class="boardNo" class="form-control">${bno.boardNo }</td>
			<th>작성일시</th>
			<td><fmt:formatDate value="${bno.writerDate }"
					pattern="yyyy-MM-dd-HH:mm:ss"></fmt:formatDate></td>
		</tr>


		<tr>
			<th>글제목</th>
			<td colspan="3" class="form-control">${bno.title }</td>
		</tr>


		<tr>
			<td colspan="4"><textarea rows="5" cols="40" class="form-control">${bno.content }</textarea></td>
		</tr>



		<tr>
			<th>이미지</th>
			<!-- 이미지가 들어있으면 그 이미지를 보여주고 없으면 엑박안뜨게  -->
			<td colspan="3"><c:if test="${!empty bno.image }"><img width="180px" src="images/${bno.image }"></c:if>	</td>
		</tr>



		<tr>
			<th>작성자</th>
			<td>${bno.writer }</td>
			<th>조회수</th>
			<td>${bno.viewCnt }</td>
		</tr>


		<tr>
			<td colspan="2" align="center">
				<!-- 아이디 값이 null도 아니여야하고 작성자=로그인한 아이디가 같아야 수정, 삭제 가능 --> 
				<c:choose>
					<c:when test="${!empty logId && logId == bno.writer }">
						<input type="submit" class="btn btn-primary" value="수정">
						<input type="button" class="btn btn-warning" value="삭제">
					</c:when>
					<c:otherwise>
						<input disabled type="submit" class="btn btn-primary" value="수정">
						<input disabled type="button" class="btn btn-warning" value="삭제">
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</form>



<h3>댓글등록</h3>
<table class="table">
	<tr>
		<th>댓글내용</th>
		<td><input type="text" class="form-control" id="content"></td>
		<td><button id="addReply" class="btn btn-primary">댓글등록</button></td>
	</tr>
</table>





<h3>댓글목록</h3>
<p id ="empty"></p>
<ul id="list">
	<li style="display: none;" id="template">
		<span>00</span> <!-- replyno -->
		<b>첫번째댓글인데요</b> <!-- reply --> 
		<span>user01</span> <!-- replyer -->
		<span>2023-10-10</span><!-- replyDate -->
		<button id="delReply" class="btn btn-warning">삭제</button>
		<hr>
	</li>
</ul>



<!-- 페이지 숫자 링크 만들기  -->
<div class="pagination"></div>


<p>
	<a href="boardList.do">목록으로가기</a>
</p>



<script>   //삭제 버튼을 누르면 삭제form이 열리게 
		document.querySelector('input[type=button]')
		.addEventListener('click',function(e){
			document.forms.myFrm.action = 'removeForm.do';
			document.forms.myFrm.submit();
		});
	
	
	
	let bno = "${bno.boardNo }";  
	let writer = "${logId }";   
	bno = document.querySelector('.boardNo').innerHTML;  //클래스 이름이 boardNo인 태그의 innerHTML
	let page= 1;  // 게시글 눌렀을때 1페이지니까초록색 뜨게할라고 
	
	
	//댓글목록 보여주기
	function showList(pg = 1){   //페이지 값이 있으면 있는거, 없으면 초기값 1 
		
	document.querySelectorAll('#list li:not(:nth-of-type(1))').forEach(li => li.remove()); //li를 다 지워 
	//첫번째 li는 템플릿이라 남겨놓고...
	fetch('replyList.do?bno='+bno + '&page=' + pg) //몇번 게시글에 몇 페이지 보여줄건지
	.then(resolve => resolve.json())
	.then(result => {  
		console.log(result);   //result = {list:[ ] dto: {…}}
		
		if(pg < 0){  //댓글 하나 추가하면 무조건 마지막페이지 보이게할라고 
			page = Math.ceil(result.dto.total/5)
			showList(page);
			return;
		}
		
		if(pg > Math.ceil(result.dto.total/5)){   // 삭제 처리 후 마지막 페이지가 보이도록 
			page = Math.ceil(result.dto.total/5)
			showList(page);
		}
		
		if(result.dto.total == 0){    //등록된 댓글이 없다면 함수빠져나옴 
			document.querySelector('#empty').innerHTML='등록된 댓글이 없습니다'   //새로고침 안해도..되게..해봐
			return;
		}
		
	
		
		
		result.list.forEach(reply => { 
			let li = makeRow(reply);   //화면에 그려주기 
			//한건 데이터 만드는 함수 
			document.querySelector('#list').append(li);   //ul태그에 만들어진 li붙힘 
		})//foreach
		console.log(result.dto);  //{total: 55, currentPage: 1, next: true, prev: false, startPage: 1, …}
		makePaging(result.dto)
	}) //두번째 then
	.catch(err => console.log(err));
	
	}//showList()함수 
	
	
	
	showList();
	
	//댓글목록이 출력이되고, dto를 가지고 버튼을 만듬 
	//페이지 숫자 버튼생성 
	//dto객체가 하나 들어옴 
	//{total: 55, currentPage: 1, next: true, prev: false, startPage: 1, endPage: 10 , boardNo :1 }
	function makePaging(dto={}){
		
		document.querySelector('.pagination').innerHTML='';	 //초기화	
		
		//이전페이지가 있으면 
		if(dto.prev){
			let aTag = document.createElement('a');
			aTag.setAttribute('href' , dto.startPage-1);      //11페이지에서 <<누르면 10페이지로 가게끔   
			aTag.innerHTML = "&laquo";
			document.querySelector('.pagination').append(aTag);
		}
		
		//페이지 10개씩 보여주기 
		for(let i = dto.startPage; i <= dto.endPage; i++){
			let aTag = document.createElement('a');
			aTag.setAttribute('href' , i);       //<a href="1">1</a>
			aTag.innerHTML = i;
			//active녹색 주는거 
			if(i == page){
				aTag.className = 'active'; //i가 == 선택된 페이지면 
			}
			document.querySelector('.pagination').append(aTag);
		}//포 
		
		//이후페이지가 있으면 
		if(dto.next){
			let aTag = document.createElement('a');
			aTag.setAttribute('href' , dto.endPage+1);
			aTag.innerHTML = "&raquo";
			document.querySelector('.pagination').append(aTag);
		}		
		
		
		//a 페이지 숫자 태그에 클릭이벤트 만들기 
		document.querySelectorAll('.pagination a').forEach(ele => {  //페이지네이션클래스의 모든 a태그들을 가져옴   //배열 메소드 forEach씀 
			ele.addEventListener('click', function(e){   //각각의 e에 이벤트를 단다 
				e.preventDefault();   //기본 기능 차단하고 아랫부분 코드 계속 실행하겠다는 말 //페이지안넘어가게 
				 page = ele.getAttribute('href');  //href의 값 = page
				showList(page);  //그 페이지를 보여줌 
			})//클릭이벤트 
		})//포이치
	}//makePage end 
	
	
	
	//댓글 등록버튼 이벤트 
	document.querySelector('#addReply').addEventListener('click', function(e){
			let reply = document.querySelector('#content').value;  //댓글내용 값 가져옴 
			//아작스 bno/writer/reply를 서블릿으로 전달 
			
			if(!bno || writer =='null' || !reply ){
				alert("로그인 하지 않았거나 작성되지 않은 항목이 있습니당")
				return;   //함수를 중간에 종료하려면 
			}
			
			fetch('addReply.do',{
				method:'post',
				headers : {'Content-Type': 'application/x-www-form-urlencoded'},
				body: 'bno=' +bno + '&reply=' + reply + '&replyer=' +writer
			})
			.then(resolve => resolve.json())
			.then(result => {
				console.log(result);
				if(result.code == 'ok'){
					//document.querySelector('#list').append(makeRow(result.vo)); //새로추가한 내용을 ul태그 밑에 붙힘 
					showList(-1);
				}else{
					alert('에러')
				}
			})
			
			
			
	})//댓글등록 이벤트
	
	

	
	//댓글 객체 1행씩 li템플릿 형식으로 변경 
	// {replyNo: 15, boardNo: 1, reply: 'dddd', replyer: 'M001', replyDate: '2023-11-07'}
	function makeRow(reply){
		
		//수업 코드도 있음 
		
		let temp = document.querySelector('#template').cloneNode(true);
		temp.style.display ='block';
		temp.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo; //첫번째 스판태그의 내용에 
		temp.querySelector('b').innerHTML = reply.reply;   //b태그에 
		temp.querySelector('span:nth-of-type(2)').innerHTML = reply.replyer;  //두번째 스판태그에 
		temp.querySelector('span:nth-of-type(3)').innerHTML = reply.replyDate;  //세번째 스판태그에 
		
		temp.querySelector('#delReply').addEventListener('click' , function(e){ 
			
			if(writer != reply.replyer){   //로그인한사람 = 댓글 작성자가 일치하지 않으면 
				alert("삭제권한이없습니다")
				return; 
			}
			
			fetch('delReply.do?rno=' + reply.replyNo)
			.then(resolve => resolve.json())
			.then(result => {
				console.log(result);
				if(result.retCode == 'OK'){
					alert('삭제성공');
					temp.remove();
					showList(page);
				
				}else {
					alert('삭제실패');
				}
			})//then
			
		})//삭제이벤트 
		return temp;
	}//makeRow 함수 
			
	</script>
