<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="./include/header.jsp" %>

<form action="/rest" method="POST">
	<h1> 글쓰기 </h1>
	제목    <input type="text" name="title"/><br/>
	작성자  <input type="text" name="user_name"/><br/>
	내용  <textarea name="content" cols=50 rows=20  maxlength=500 ></textarea><br>
	<input class="btn btn-info" type="submit" value="입력">
</form>

<%@include file="./include/footer.jsp" %>