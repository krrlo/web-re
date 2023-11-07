<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
#list span{

margin: 20px;
margin-bottom : 10px;
text-align: left;    

}


#template {
margin: 10px;
margin-bottom : 10px;
text-align: left;  
}


</style>


<%@include file = "../layout/menu.jsp" %>
<%@include file = "../layout/header.jsp" %>




	<%  
	
	//getboardControl에서 받아온 조회된 객체 1개를 가져옴 그 vo를 조회화면에 세팅 
	BoardVO vo = (BoardVO) request.getAttribute("bno");  
	
	%>


	<h3>조회화면</h3>

	<form action="modifyForm.do" name="myFrm">   <!-- 수정,삭제 버튼누르면 여기 값이 넘어감 -->
	
	
	    <!-- 화면상에는 안보이게 , 값은 수정,삭제할때 넘겨줘야하니까 -->
		<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">

		<table class="table">

			<tr>
				<th>글번호</th>
				<td class="boardNo" class="form-control" ><%=vo.getBoardNo()%></td>
				<th>작성일시</th>
				<td><%=vo.getWriterDate()%></td>
			</tr>


			<tr>
				<th>글제목</th>
				<td colspan="3" class="form-control" ><%=vo.getTitle()%></td>
			</tr>


			<tr>
				<td colspan="4"><textarea rows="5" cols="40" class="form-control" > <%=vo.getContent()%></textarea>
				</td>
			</tr>



			<tr>
				<th>이미지</th>   <!-- 이미지가 들어있으면 그 이미지를 보여주고 없으면 엑박안뜨게  -->
				<% if (vo.getImage() != null) {%>
				
			    <td><img align="center" width="150px"
					src="images/<%=vo.getImage()%>"></td>
					<% } %>
				<!-- 20231026_083823.png -->
			</tr>



			<tr>
				<th>작성자</th>
				<td><%=vo.getWriter()%></td>
				<th>조회수</th>
				<td><%=vo.getViewCnt()%></td>
			</tr>


			<tr>
				<td colspan="2" align="center">   <!-- 아이디 값이 null도 아니여야하고 작성자=로그인한 아이디가 같아야 수정, 삭제 가능 -->
				<% if(logId !=null && logId.equals(vo.getWriter())){%>
					<input type="submit" class="btn btn-primary" value="수정">
					<input type="button" class="btn btn-warning" value="삭제">
					
					
				<%} else {%>    <!-- 아니면 수정삭제 버튼 접근못하게  -->
					<input disabled type="submit" class="btn btn-primary" value="수정">
					<input disabled  type="button" class="btn btn-warning" value="삭제">
					<%} %>
				</td>
			</tr>

		</table>
	</form>
	
	
	
<h3>댓글등록</h3>
<table class = "table">
	<tr>
		<th>댓글내용</th>
		<td><input type="text" class="form-control" id="content"></td>
		<td><button id="addReply" class="btn btn-primary">댓글등록</button></td>
 	</tr>
</table>	
	
	


	
<h3>댓글목록</h3>

<ul id ="list">
	<li style ="display: none;" id ="template"> 
	<span>00</span>   <!-- replyno -->
	<b>첫번째댓글인데요</b>   <!-- reply -->
	<span>user01</span>  <!-- replyer -->
	<span>2023-10-10</span> <!-- replyDate -->
	<button id = "delReply" class="btn btn-warning">삭제</button>
	<hr>
	</li>
</ul>	

	
	<p>
		<a href="boardList.do">목록으로가기</a>
	</p>
	
	<script>   //삭제 버튼을 누르면 삭제form이 열리게 
		document.querySelector('input[type=button]')
		.addEventListener('click',function(e){
			document.forms.myFrm.action = 'removeForm.do';
			document.forms.myFrm.submit();
		});
	
	
	//한 게시글에 달린 댓글목록출력하기 
	let bno = "<%=vo.getBoardNo()%>";  
	let writer = "<%=logId%>";   
	//bno = document.querySelector('.boardNo').innerHTML;  //클래스 이름이 boardNo인 태그의 innerHTML
	fetch('replyList.do?bno='+bno) //23번 게시물의..?
	.then(resolve => resolve.json())
	.then(result => {  //result에는 글 번호 23번에 달린 댓글 내용 리스트가 들어가있음 
		console.log(result);
		result.forEach(reply => { 
			let li = makeRow(reply);   //화면에 그려주기 
			//한건 데이터 만드는 함수 
			document.querySelector('#list').append(li);   //ul태그에 만들어진 li붙힘 
		})
	})
	.catch(err => console.log(err));
	
	
	
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
					document.querySelector('#list').append(makeRow(result.vo)); //새로추가한 내용을 ul태그 밑에 붙힘 
				}else{
					alert('에러')
				}
			})
	})//댓글등록 이벤트
	
	

	
	//result안에들어있는 댓글 객체 1행씩 li템플릿 형식으로 변경 
	function makeRow(reply){
		
		let temp = document.querySelector('#template').cloneNode(true);
		temp.style.display ='block';
		temp.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo; //첫번째 스판태그의 내용에 
		temp.querySelector('b').innerHTML = reply.reply;   //b태그에 
		temp.querySelector('span:nth-of-type(2)').innerHTML = reply.replyer;  //두번째 스판태그에 
		temp.querySelector('span:nth-of-type(3)').innerHTML = reply.replyDate;  //세번째 스판태그에 
		
		temp.querySelector('#delReply').addEventListener('click' , function(e){ 
			fetch('delReply.do?rno=' + reply.replyNo)
			.then(resolve => resolve.json())
			.then(result => {
				console.log(result);
				if(result.retCode == 'OK'){
					alert('삭제성공');
					temp.remove();
				}else {
					alert('삭제실패');
				}
			})
			
		})//이벤트 
		return temp;
	}//makeRow 함수 
			
	</script>
	
<%@include file = "../layout/footer.jsp" %>