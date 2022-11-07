<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%boolean Result= (boolean)request.getAttribute("Result"); %>
	
	<script>
	<%if(Result){ %>	
		alert('회원탈퇴 성공');
		location.href = '/deleteuser';
	<%}else{ %>
		alert('회원탈퇴 실패\n비밀번호를 다시 확인해세요');
		location.href = '/deleteuser';
	<%} %>
	</script>
</body>
</html>