<!-- ȸ��Ż�� ��� �˸�â ���� (������) -->
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
		alert('ȸ��Ż�� ����\nŻ�� ���� �߻�.');
		location.href = '/main';
	<%}else if(Result == 1){ %>
		alert('ȸ��Ż�� ����');
		location.href = '/deleteuser';
	<%}else if(Result == 2){ %>
		alert('ȸ��Ż�� ����\n��й�ȣ�� �Ȱ��� �ۼ����ּ���.');
		location.href = '/deleteuser';
	<%}else if(Result == 3){ %>
		alert('ȸ��Ż�� ����\n��й�ȣ �ٽ� Ȯ���ϼ���.');
		location.href = '/deleteuser';
	<%} %>
	</script>
</body>
</html>