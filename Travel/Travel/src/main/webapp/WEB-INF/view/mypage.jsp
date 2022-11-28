<!-- 마이페이지 & 비밀번호 수정(손유림) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
							<h5>회원정보수정</h5>
						</header>
						<div>
							<form action="/mypage" method="post">
								<table class="sectiontable">	
									<tr>
										<td width=200px>아이디<td>
										<td id="userId" width=300px><strong>${user.id}</strong></td>
									</tr>
									<tr>
										<td>비밀번호 확인<td>
										<td><input type="password" name="pwd" placeholder="비밀번호 확인" size=15/></td>
										<td><span id="checkpw"></span></td>
									</tr>
									<tr>
										<td>비밀번호 수정<td>
										<td><input type="password" name="uppwd" placeholder="비밀번호 수정" size=15/></td>
									</tr>
									<tr>
										<td>비밀번호 재확인<td>
										<td><input type="password" name="pwdr" placeholder="비밀번호 재확인" size=15/></td>
										<td>
											<span id="checkpwdr"><button type="submit" class="btn_update">비밀번호 변경</button></span>
										</td>
									</tr>	
									<tr>
										<td>생년월일<td>
										<td id="userbirth"><strong>${user.date}</strong></td>
									</tr>
									<tr>
										<td>성별<td>
										<td id="userGender"><strong>${user.gender}</strong></td>
									</tr>
								</table>
							</form>
						</div>
						<div class="button">
							<span>
								<button type="submit" class="btn_cancel" onclick="location.reload()">취소</button>
							</span>
							<span>
								<button type="submit" class="btn_check" onclick="location.href = '/main';">확인</button>
							</span>
						</div>	
					</section>
				</div>
			</div>
		</div>
	</div>
</body>
</html>