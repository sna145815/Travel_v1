<!-- 비밀번호 수정 결과 알림창 띄우기 (손유림) -->
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
	<%int Result= (int)request.getAttribute("Result"); %>
	
	<script>
	<%if(Result == 0){ %>	
		alert('비밀번호 변경 실패\n변경 오류 발생.');
		location.href = '/mypage';
	<%}else if(Result == 1){ %>
		alert('비밀번호 변경 성공');
		location.href = '/mypage';
	<%}else if(Result == 2){ %>
		alert('비밀번호 변경 실패\n재확인 비밀번호를 변경할 비밀번호와 똑같이 작성해주세요.');
		location.href = '/mypage';
	<%}else if(Result == 3){ %>
		alert('비밀번호 변경 실패\n현재 비밀번호를 다시 확인해세요.');
		location.href = '/mypage';
	<%} %>
	</script>
</body>
</html>