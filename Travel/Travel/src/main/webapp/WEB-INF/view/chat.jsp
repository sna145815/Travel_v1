<!-- 채팅기능(페이지) (김진홍) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <title>채팅</title>
    <style>
  .container {
    position:absolute;
    top:50%;
    left:50%;
    transform: translate(-50%,-50%);
  }
</style>
</head>
<body>
<div class=container>
 <fieldset id="chatform">
        <textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
        <br/>
        <input id="inputMessage" onkeyup="enterkey()" type="text"/>
        <input type="submit" value="send" onclick="send()" />
    </fieldset>
</div>
   
</body>
    <script type="text/javascript">
        var textarea = document.getElementById("messageWindow");
        var webSocket = new WebSocket('ws://localhost:8080/chat');
        var inputMessage = document.getElementById('inputMessage');
    webSocket.onerror = function(event) {
      onError(event)
    };
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
    function onMessage(event) {
        textarea.value += "상대 : " + event.data + "\n";
    }
    function onOpen(event) {
        textarea.value += "연결 성공\n";
    }
    function onError(event) {
      alert(event.data);
    }
    function send() {
        textarea.value += "나 : " + inputMessage.value + "\n";
        webSocket.send(inputMessage.value);
        inputMessage.value = "";
    }
    function enterkey() {
    	if (window.event.keyCode == 13) {
        	send();
        }
    }
  </script>
