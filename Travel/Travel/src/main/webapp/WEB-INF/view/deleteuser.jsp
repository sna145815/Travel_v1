<!-- 회원탈퇴 페이지 (손유림) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/deleteuserstyle.css">
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
							<h5>회원탈퇴</h5>
						</header>
						<form action="/deleteuser" method="post">
							<div class="password">
								<table class="inputpwd">
									<tr>
										<td width=180px><label for="myPwd">비밀번호</label></td>
										<td><input type="password" name="pwd" placeholder="비밀번호" size=20/></td>
									</tr>
									<tr>
										<td><label for="PwdR">비밀번호 확인</label></td>
										<td><input type="password" name="pwdr" placeholder="비밀번호 확인" size=20/></td>
									</tr>
								</table>
							</div>	
							<div class="button">
								<button type="submit" class="btn_delete">탈퇴</button>
							</div>	
						</form>
					</section>
				</div>
			</div>
		</div>
	</div>
</body>
</html>