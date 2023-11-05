<%@page import="co.yedam.board.service.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h3>게시판 목록.하하하하 </h3>
 	
 	<%
 	
 	List <BoardVO> list = (List<BoardVO>) request.getAttribute("list"); //list라는 어트리뷰트를 읽어오세요.. 리스트 컬렉션. 전체조회 데이터가 들어와있음 //얘 반환값은 오브젝트 타입에 담김 
 	
 	%>
 	
 	<table border="1">
 	<thead>
 	<tr>
 	<th>글번호</th>
 	<th>제목</th>
 	<th>작성자</th>
 	<th>작성일자</th>
 	<tbody>
 	
 	<% 
 	for (BoardVO vo : list){ %>
 		<tr>
 		<td><%=vo.getBoardNo()%></td>
 		<td><a href ="getBoard.do?bno=<%=vo.getBoardNo()%>"><%=vo.getTitle()%></a></td>
 		<td><%=vo.getWriter()%></td>
 		<td><%=vo.getWriteDate()%></td>
 		</tr>
 	<%
 	}
 	%>  
 	</tbody>
 	</table>
 	<p>
 	<a href="boardForm.do">게시글 등록하기</a>
 	 
 	
</body>
</html>