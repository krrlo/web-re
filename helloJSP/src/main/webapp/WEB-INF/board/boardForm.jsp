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
				<td colspan="2"><input type="submit" value="저장"><input
					type="reset" value="초기화">
			</tr>

		</table>
	</form>

</body>
</html>