<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

		<table border="1">

			<tr>
				<th>글번호</th>
				<td><%=vo.getBoardNo()%></td>
				<th>작성일시</th>
				<td><%=vo.getWriteDate()%></td>
			</tr>


			<tr>
				<th>글제목</th>
				<td colspan="3"><%=vo.getTitle()%></td>
			</tr>


			<tr>
				<td colspan="4"><textarea rows="5" cols="40"> <%=vo.getContent()%></textarea>
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
	
	<p>
		<a href="boardList.do">목록으로가기</a>
	</p>
	
	<script>   //삭제 버튼을 누르면 삭제form이 열리게 
		document.querySelector('input[type=button]')
		.addEventListener('click',function(e){
			document.forms.myFrm.action = 'removeForm.do';
			document.forms.myFrm.submit();
		})
	</script>
	
<%@include file = "../layout/footer.jsp" %>