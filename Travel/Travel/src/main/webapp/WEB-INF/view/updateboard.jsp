<!-- 글쓰기(조윤주) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정</h1>
	<form action="/board?cmd=update" method="post" class="form-control">
		<table border="1">
			<tr>
				<th>NAME</th>
				<td><input type="text" name="userID" value="${detail.userID}"></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title" value="${detail.title}" readonly></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60" name="content">${detail.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">
			</tr>
		</table>
	</form>
</body>
</html>