<!-- 내가 쓴 글 목록 페이지 (손유림) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
<!--회원가입페이지 (최민성) -->
<div class=container>
<form action="/signup" method="post">   
    <div class="form-group">
        <label for="id">아이디 :</label> <input type="text"
            class="form-control" placeholder="아이디를 입력해주세요." id="id" name="id">
    </div>    
    <div class="form-group">
        <label for=password>비밀번호 </label> <input type="password"
            class="form-control" placeholder="비밀번호를 입력해주세요." id="password" name="pwd">
    </div>    
    <div class="form-group">
        <label for="name">이름 :</label> <input type="text"
            class="form-control" placeholder="이름을 입력해주세요." id="name" name="name">
    </div>   
   <div class="form-group">
        <label for="date">생년월일 :</label> <input type="date"
            class="form-control" placeholder="yyyy-mm-dd" id="date" name="date">
    </div>   
   <div class="form-group">
        <label for="gender">성별 :</label> <input type="text"
            class="form-control" placeholder="성별을 입력해주세요." id="gender" name="gender">
    </div>
   <div class="form-group form-check">
      <button type="submit" class="btn btn-primary">회원가입</button>
   </div>
</form>
</div>
</body>
</html>