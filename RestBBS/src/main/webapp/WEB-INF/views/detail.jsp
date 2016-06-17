<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="./include/header.jsp" %>

<div class="container">
	<h3> 게시글 내용 </h3>
	<form style="float: right" action="/rest/${vo.board_no}" method="post">
		<input type="hidden" id="_method" name="_method" value="delete"/>
		<input class="btn btn-danger" type="submit" value="삭제" />
	</form>
	<table class="table">
			<tr>
				<th scope="row">글번호</th>
					<td>${vo.board_no}</td>
			</tr>
			<tr>
				<th scope="row">작성일</th>
					<td>${vo.regdate}</td>
			</tr>
			<tr>
				<th scope="row">작성자</th>
					<td>${vo.user_name}</td>
			</tr>
			<tr>
				<th scope="row">제목</th>
					<td>${vo.title}</td>
			</tr>
			<tr>
				<th scope="row">내용</th>
					<td><c:out value="${vo.content}" escapeXml="false"></c:out></td>
			</tr>
	</table>
		
	<h4>덧글</h4>
	
	<div id="reply_list" ></div>
	<div id="reply_page" ></div>
	
	<form id="reply">
		<input type="text" id="content" name="content" size="50" />
		, 작성자<input type="text" id="user_name" name="user_name" size="10" />
		<input class="btn btn-info" type="button" value="등록" onclick="insertReply()" />
	</form>
</div>
<script type="text/javascript">

	var bno = '${vo.board_no}';
	var currentPage = 1;
	
	function deleteReply(rno) {
		$.ajax({
			type : 'delete',
			url : '/reply/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
				
			},
			data : '',
			dataType : 'text',
			success : function (result) {
				if(result == "SUCCESS") {
					getReplyList();
				}
			}
		});
	}
	function insertReply() {
		
		/*
		var reply_frm = document.getElementById("reply");
		var reply_content = reply_frm.content;
		var reply_user = reply_frm.user_name;
		*/
		
		var reply_content = $("#content").val();
		var reply_user = $("#user_name").val();
		
		$.ajax({
			type : 'post',
			url : '/reply/' + bno,
			headers : {
				"Content-Type" : "application/json",
			},
			data : 
				'{"content":"' + reply_content + '", "user_name":"' + reply_user + '"}',
				// == JSON.stringify({content:reply_content, user_name:reply_user})
			dataType : 'text', // result의 타입이 text
			success : function (result) {
				if(result == "SUCCESS") {
					
					//$("#content").val("");
					//$("#user_name").val("");
					getReplyList();
					
				}
			}
		});
		
		
	}
	function setReplyList(list) {
			
		var result = "<ul>";
		
		/*
		for(var i in list) {
				result += "<li>" 
				+ "작성자:" + list[i].user_name 
				+ "<br>" + " 내용:" + l[i].content 
				+"<input class='btn btn-btn' type='button' id='btn_del' name='btn_del' value='삭제' onclick='deleteReply("
						+ list[i].reply_no
						+")'/>"
				+ "</li>";
		}
		result += "</ul>";
		*/
		
		$(list).each(function() {
			result += "<li>" + this.content
			+ "<input class='btn btn-btn' type='button' id='btn_del' name='btn_del' value='삭제' onclick='deleteReply("
			+ this.reply_no
			+")'/>"
			+ "</li>";
		});
		result += "</ul>";
		
		
		document.getElementById("reply_list").innerHTML = result;
	}	
	
	function getReplyList(page) {
		
		if (page == null) {
			page = currentPage;
		}
		
		$.ajax({
			type : 'get',
			url : '/reply/' + bno + '/' + page,
			headers : {
				"Content-Type" : "application/json",
				//"X-HTTP-Method-Override" : "GET",
			},
			dataType : 'json',
			data : '',
			success : function (result) {
				setReplyList(result.l);
				setPagePrint(result.p);
			}
		});
		
		currentPage = page;

	}
	
	function setPagePrint(pm) {
		var str = "<ul class='pagination'>";
		
		if(pm.prev) {
			str += "<li><a onclick='getReplyList(" + (pm.startPage - 1) + ")'>&lt;</a></li>"
		}
		
		for(var i = pm.startPage; i <= pm.endPage; i++) {
			if(i == pm.criteria.page) {
				str += "<li class='active'><a href='#'>" + i + "</a></li>"
			}else
			str += "<li><a href='#' onclick='getReplyList(" + i + ")' style='cursor:hand'>" + i + "</a></li>"
		}
		
		if(pm.next) {
			str += "<li> <a onclick='getReplyList(" + (pm.endPage + 1) + ")'>&gt;</a> </li>"
		}
		
		str += "</ul>"
			document.getElementById("reply_page").innerHTML = str;
	}
	
	getReplyList(currentPage);
</script>

<%@include file="./include/footer.jsp" %>