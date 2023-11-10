
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<style>
#list span {
	margin: 20px;
	margin-bottom: 10px;
	text-align: left;
}

#template {
	margin: 10px;
	margin-bottom: 10px;
	text-align: left;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>



<!--req.setAttribute("bno", vo) bno 에는 vo 객체가 담겨있음  ${bno } -->


<h3>상세화면</h3>

	<!-- 수정,삭제 버튼누르면 여기 값이 넘어감 -->

	<!-- 화면상에는 안보이게 , 값은 수정,삭제할때 넘겨줘야하니까 -->
	

	<table class="table">

		<tr>
			<th>상품코드</th>
			<td class="boardNo" class="form-control">${bno.prodCode }</td>
			<th>상품이름</th>
			<td class="boardNo" class="form-control">${bno.prodName }</td>
			<th>상품설명</th>
			<td class="boardNo" class="form-control">${bno.prodDesc }</td>
			<th>상품원래가격</th>
		    <td class="boardNo" class="form-control">${bno.price }</td>
		    <th>할인된가격</th>
		    <td class="boardNo" class="form-control">${bno.offPrice }</td>
		    <th>평점</th>
		    <td class="boardNo" class="form-control">${bno.likeIt }</td>
			<tr>
			<th>이미지</th>
			<!-- 이미지가 들어있으면 그 이미지를 보여주고 없으면 엑박안뜨게  -->
			<td colspan="3"><c:if test="${!empty bno.prodImage }"><img width="180px" src="resources/images/${bno.prodImage }"></c:if>	</td>
			</tr>
	</table>


<p>
	<a href="boardList.do">목록으로가기</a>
</p>


