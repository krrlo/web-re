<%@page import="co.yedam.board.service.MemberVO"%>
<%@page import="co.yedam.board.service.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<%@include file = "../layout/menu.jsp" %>
<%@include file = "../layout/header.jsp" %>

	<h3>회원 전체조회</h3>

	<%
	List <MemberVO> list = (List<MemberVO>) request.getAttribute("list"); //list라는 어트리뷰트를 읽어오세요.. 리스트 컬렉션. 전체조회 데이터가 들어와있음 //얘 반환값은 오브젝트 타입에 담김
	%>


	<table class="table">
 	<thead>
 	<tr>
 	<th>아이디</th>
 	<th>이름</th>
 	<th>연락처</th>
 	<tbody>
 	
 	<% 
 	for (MemberVO vo : list){ %>
 		<tr>
 		<td><%=vo.getMid()%></td>
 		<td><%=vo.getName()%></a></td>
 		<td><%=vo.getPhone()%></td>
 		</tr>
 	<%
 	}
 	%>  
 	</tbody>
 	</table>

<%@include file="../layout/footer.jsp" %>