
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!--${list } 목록이담겨있음 -->











<h3>게시판 목록</h3>

<table class="table">
	<thead>
		<tr>
			<th>제품번호</th>
			<th>상품이름</th>
			<th>원래가격</th>
			<th>할인가격</th>
			<th>평점</th>
			<th>이미지</th>
	<tbody>
		<c:forEach items="${list }" var="vo">

			<tr>
				<td>${vo.prodCode }</td>
				<td><a href="getBoard.do?bno=${vo.prodCode }">${vo.prodName }</a></td>
				<td>${vo.price }</td>
				<td>${vo.offPrice }</td>
				<td>${vo.likeIt }</td>
				<td><img width="180px" src="resources/images/${vo.prodImage }"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<p>

	

	