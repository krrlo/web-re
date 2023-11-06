
<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyForm</title>
</head>
<body>


<%
	BoardVO vo = (BoardVO) request.getAttribute("vo");
   // modifyformcontroller에서 가져온 VO를 활용해 수정화면 구성하기 
%>

<h3>수정화면</h3>
	
	<form action="modifyBoard.do">     <!-- 수정버튼 누르면 여기 입력된값으로 수정  -->
		<!-- 수정 , 삭제 시 값을 넘기기 위해 인풋 이든 타입으로 지정  -->
		<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">

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
				<td><img src = "images/<%=vo.getImage() %>" width="80px">
			</tr>

			<tr>
				<td colspan="2">
				<input type="submit" value="수정">    <!-- modifyboard.do에서 처리되는거  -->
				<input type="reset" value="초기화">
				</td>
			</tr>

		</table>
		
	</form>




</body>
</html>