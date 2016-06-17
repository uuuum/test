<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title> 파일업로드 </title>
</head>
<body>
<h1>
	파일업로드  
</h1>

<form action="/uploader" method="post" enctype="multipart/form-data">

	<input type="file" name="file"/>
	<input type="submit" value="등록"/>
	
</form>
</body>
</html>
