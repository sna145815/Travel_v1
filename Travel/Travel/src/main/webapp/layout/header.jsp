<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
  <title>TravelPlan</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="/main">TravelPlan</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/signup">회원가입</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/login">로그인</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/board?cmd=getlist">게시판</a>
      </li>    
       <li class="nav-item">
        <a class="nav-link" href="/main?cmd=chat">채팅참여</a>
      </li> 
      <li class="nav-item">
        <a class="nav-link" href="/mypage">마이페이지</a>
      </li>   
    </ul>
  </div>  
</nav>
<br>
    