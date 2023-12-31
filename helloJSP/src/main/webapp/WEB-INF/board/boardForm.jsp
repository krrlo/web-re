<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>


	


	<h3>등록화면</h3>
	<!-- 	input 태그들의 값을 서버로 전송하기 위한 정보를 담고있는 form태그 
 action의 값으로는 요청하는 컨포넌트 이름  폼 열어서 등록할 정보 입력  저장 버튼 누르면 여기데이터가 추가되게끔-->
	<form action="addBoard.do" method="post" enctype="multipart/form-data">   <!-- 파일 전송하는 타입으로 등록  -->

		<table class = "table">
			<tr>
				<th>제목</th>
				<td><input type="text" class="form-control" name="title"></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td><input type="text" readonly class="form-control" name="writer" value="${logId }>"></td>
			</tr>

			<tr>
				<td colspan="2"><textarea cols = "50" rows= "7" class="form-control" name="content"></textarea></td>

			</tr>

			<tr>
				<th>파일명</th>
				<td><input type="file" class="form-control" name="img"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" class="btn btn-primary" value="저장"> <input
					type="reset" class="btn btn-warning" value="초기화">
			</tr>

		</table>
		<p>
			<a href="boardList.do">뒤로가기</a>
	</form>
	
	<jsp:include page="../layout/footer.jsp"></jsp:include>
