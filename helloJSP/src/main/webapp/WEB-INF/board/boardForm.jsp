<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>등록화면</h3>   
<!-- 	input 태그들의 값을 서버로 전송하기 위한 정보를 담고있는 form태그 
 action의 값으로는 요청하는 컨포넌트 이름  -->
	<form action="addBoard.do" method="post">

		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>

			<tr>
				<td colspan="2"><textarea cols="40" row="5" name="content"></textarea></td>

			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="저장">
				<input type="reset" value="초기화">
			</tr>

		</table>
		<p><a href ="boardList.do">뒤로가기</a>
	</form>

</body>
</html>