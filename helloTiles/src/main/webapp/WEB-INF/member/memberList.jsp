
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 자바코드 쓰게하려고  -->



<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>연락처</th>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="member">
			<tr>
				<td>${member.mid }</td>
				<td>${member.name }</td>
				<td>${member.phone }</td>
				<!-- 클래스 이름과 똑같이 -->
			</tr>

		</c:forEach>
	</tbody>
</table>

