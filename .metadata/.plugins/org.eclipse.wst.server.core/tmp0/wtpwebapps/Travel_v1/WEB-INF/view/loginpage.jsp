<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/layout/header.jsp" %>

<div class=container>
<form action="/login" method="post">
  <div class="form-group">
    <label for="id">id:</label>
    <input type="text" class="form-control" placeholder="Enter id" name="id" id="id">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" name="pwd" id="pwd">
  </div>
  <div class="form-group form-check">
     <button type="submit" class="btn btn-primary">로그인</button>
  </div>
  
</form>
</div>

</body>
</html>





