<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../layout/menu.jsp"%>
<%@include file="../layout/header.jsp"%>

<!-- 로그인 페이지 화면 나오게 ,  아이디 패스워드 입력받아서 login.do로 보내라  -->
<form action="login.do" method="post">
	<table class="table">

		<tr>
			<th>아이디</th>
			<td><input type="text" class="form-control" name="id"></td>
		<tr>
		
		<tr>
			<th>비밀번호</th>
			<td><input type="password" class="form-control" name="pass"></td>
		<tr>
		
		
		<tr>
			<td colspan="2"><input type ="submit" class="btn btn-primary" value="로그인"></td>  <!-- 버튼써라 -->
		<tr>
		
	</table>
</form>
