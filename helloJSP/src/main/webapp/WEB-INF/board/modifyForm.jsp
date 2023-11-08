
<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>



<!-- ${vo} -->


<h3>수정화면</h3>
	
	<form action="modifyBoard.do">     <!-- 수정버튼 누르면 여기 입력된값으로 수정  -->
		<!-- 수정 , 삭제 시 값을 넘기기 위해 인풋 이든 타입으로 지정  -->
		<input type="hidden" name="bno" value="${vo.boardNo }">

		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" class="form-control" value="${vo.title }"></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" class="form-control" value="${vo.writer }"></td>
			</tr>

			<tr>
				<td colspan="2"><textarea cols="40" row="5" class="form-control" name="content">${vo.content }</textarea></td>

			</tr>

			<tr>
				<th>파일명</th>
				<td><img src = "images/${vo.image }" class="form-control" width="80px">
			</tr>

			<tr>
				<td colspan="2">
				<input type="submit"  class="btn btn-primary" value="수정">    <!-- modifyboard.do에서 처리되는거  -->
				<input type="reset" class="btn btn-warning" value="초기화">
				</td>
			</tr>

		</table>
		
	</form>




<%@include file = "../layout/footer.jsp" %>