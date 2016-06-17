<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="./include/header.jsp" %>


<script type="text/javascript">
	function goWrite() {
		location.href = "/rest/new";
	}
</script>
<div class="container">
	<h3> 게시판 목록 </h3>
	<table class="table table-striped">
		<thead>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>작성일</th>
			<th>조회수</th>
		</thead>
		
	<c:forEach items="${list}" var="vo">
	
		<tr>
			<td>${vo.board_no}</td>
			<td><a href="/rest/${vo.board_no}">${vo.title} (${vo.reply_cnt })</a></td>
			<td>${vo.user_name}</td>
			<td>${vo.regdate}</td>
			<td>${vo.view_cnt}</td>
		</tr>
	
	</c:forEach>
	</table>
	
	<input class="btn btn-info" type="button" value="글쓰기" onclick="goWrite()">
</div>

<%@include file="./include/footer.jsp" %>
