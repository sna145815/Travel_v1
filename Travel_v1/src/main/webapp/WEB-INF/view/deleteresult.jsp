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
		alert('ȸ��Ż�� ����');
		location.href = '/deleteuser';
	<%}else{ %>
		alert('ȸ��Ż�� ����\n��й�ȣ�� �ٽ� Ȯ���ؼ���');
		location.href = '/deleteuser';
	<%} %>
	</script>
</body>
</html>