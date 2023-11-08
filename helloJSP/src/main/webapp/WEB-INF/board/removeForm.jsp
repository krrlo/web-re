
<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>



<h3>게시글삭제화면</h3>

	<form action="removeBoard.do" method="POST">  <!-- 삭제버튼누르면 삭제진행 --> 
	<!-- 삭제버튼  submit되면 bno 넘겨서 삭제처리해야하니까  -->
		<input type ="hidden" name="bno" value="${vo.boardNo }">

		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" class="form-control" value="${vo.title }"></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"   class="form-control" value="${vo.writer }"></td>
			</tr>

			<tr>
				<td colspan="2"><textarea cols="40" row="5"  class="form-control" name="content">${vo.content }</textarea></td>

			</tr>

			<tr>
				<th>파일명</th>
				<td><img src = "imangs/${vo.image }" class="form-control" width="80px">
			</tr>

			<tr>
				<td colspan="2">
				<input type="submit" class="btn btn-primary" value="삭제">   
				<input type="reset" class="btn btn-warning" value="초기화">
				</td>
			</tr>

		</table>
		<p>
			<a href="boardList.do">뒤로가기</a>
	</form>


<%@include file = "../layout/footer.jsp" %>

