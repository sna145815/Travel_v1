<!-- 게시판 디테일 페이지 (김진홍) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    <%@ include file="/layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글보기</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">글제목</td>
						<td colspan="2">${detail.title}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2">${detail.userID}</td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2">${detail.date}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="min-height: 200px; text-align: left;">${detail.content}</td>
					</tr>
				</tbody>
			</table>
			
			<a href="/board?cmd=getlist" class="btn btn-primary">목록</a>
			<a href="/board?cmd=delete&listID=${detail.listID }" class="btn btn-primary">글삭제</a>
			<a href="/board?cmd=showupdate&title=${detail.title}" class="btn btn-primary">글수정</a>
				
				
		</div>
	</div>
</body>
</html>