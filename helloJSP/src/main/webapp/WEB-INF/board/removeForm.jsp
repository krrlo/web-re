
<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>removeForm</title>
</head>
<body>


<%
	BoardVO vo = (BoardVO) request.getAttribute("vo");
   //서블릿에서 받아온 삭제 대상 vo  그 vo로 밑에 목록 세팅 
%>

<h3>게시글삭제화면</h3>
	<!-- 	input 태그들의 값을 서버로 전송하기 위한 정보를 담고있는 form태그 
 action의 값으로는 요청하는 컨포넌트 이름  -->
	<form action="removeBoard.do" method="POST">   
		<input type ="hidden" name="bno" value="<%=vo.getBoardNo()%>">

		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=vo.getTitle()%>"></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"  value="<%=vo.getWriter()%>"></td>
			</tr>

			<tr>
				<td colspan="2"><textarea cols="40" row="5" name="content"><%=vo.getContent()%></textarea></td>

			</tr>

			<tr>
				<th>파일명</th>
				<td><img src = "imangs/<%=vo.getImage() %>" width="80px">
			</tr>

			<tr>
				<td colspan="2">
				<input type="submit" value="삭제">    <!-- modifyboard.do에서 처리되는거  -->
				<input type="reset" value="초기화">
				</td>
			</tr>

		</table>
		<p>
			<a href="boardList.do">뒤로가기</a>
	</form>




</body>
</html>