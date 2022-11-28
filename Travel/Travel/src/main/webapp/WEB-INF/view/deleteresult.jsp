<!-- 회원탈퇴 결과 알림창 띄우기 (손유림) -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int Result= (int)request.getAttribute("Result"); %>
	
	<script>
	<%if(Result == 0){ %>	
		alert('회원탈퇴 실패\n탈퇴 오류 발생.');
		location.href = '/main';
	<%}else if(Result == 1){ %>
		alert('회원탈퇴 성공');
		location.href = '/deleteuser';
	<%}else if(Result == 2){ %>
		alert('회원탈퇴 실패\n비밀번호를 똑같이 작성해주세요.');
		location.href = '/deleteuser';
	<%}else if(Result == 3){ %>
		alert('회원탈퇴 실패\n비밀번호 다시 확인하세요.');
		location.href = '/deleteuser';
	<%} %>
	</script>
</body>
</html>