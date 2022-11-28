<!-- 글쓰기(조윤주) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
<%@ page import="java.io.PrintWriter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>글 작성</h1>
	<form action="/board?cmd=write" method="post" class="form-control">
		<table border="1">
			<tr>
				<th>NAME</th>
				<td><input type="text" name="userID"></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록">
			</tr>
		</table>
	</form>
</body>
</html>
