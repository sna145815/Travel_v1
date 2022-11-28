<!-- 내가 쓴 글 목록 페이지 (손유림) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mypagestyle.css">
</head>
<body>
	<div id="wrap">
		<div id ="header">
			<div class="visual_area">
				<h1 class="txt">
					<a href="/mypage">My Page</a>
				</h1>
			</div>
		</div>
		<div id ="content_area">
			<div class ="content">
				<div class="content_in">
					<!-- 좌측 메뉴 -->
					<nav class="menu_area">
						<div class="menu1">
							<h5>개인정보관리</h5>
							<a href="/mypage" class="update">회원정보수정</a>
							<a href="/deleteuser" class="delete">회원탈퇴</a>
						</div>
						<div class="menu2">
							<h5>게시판</h5>
							<a href="/mywriting" class="post">내가 쓴 글</a>
							
						</div>
					</nav>
					<!-- 콘텐츠 내용 -->
					<section class ="content_right">
						<header class="sectiontitle">
							<h5>내가 쓴 글</h5>
						</header>
						<div>
							<table class="table" style="text-align: center; border: 1px solid #dddddd">
								<tr>
									<th style="background-color: #eeeeee; text-align: center;">글 번호</th>
									<th style="background-color: #eeeeee; text-align: center;">제목</th>
									<th style="background-color: #eeeeee; text-align: center;">작성일</th>
								</tr>
								<c:forEach var="n" items="${writing}">
									<tr>		
										<td>${n.listID}</td>
										<td style="cursor:pointer; color:blue;" onclick="location.href='/mywriting?title=${n.title}';">${n.title}</td>
										<td>${n.date}</td>
									</tr>
								</c:forEach>
							</table>
						</div>				
					</section>
				</div>
			</div>
		</div>
	</div>
</body>
</html>