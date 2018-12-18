<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>WebSocket Client</title>
<style type="text/css">
table {
	width: 90%;
	border-collapse: collapse;
}

th, td {
	border: 3px solid #bcbcbc;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;
}

td {
	background-color: #f2f2f2;
}

td.title {
	background-color: #e2e2e2;
	color: blue;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
<c:set var="port" value="${pageContext.request.localPort}" />
<c:set var="server" value="${pageContext.request.serverName}" />
<c:set var="path" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	$(function() {
		// new WebSocket() : javascript 객체
		// ws://localhost:8080/mavenshop3/chatting.shop : 채팅 서버의 url 
		var ws = new WebSocket("ws://${server}:${port}${path}/chatting.shop");
		ws.onopen = function() {
			$("#chatStatus").text("info:connection opened");
			// on : event
			// evt : 값
			$("input[name=chatInput]").on("keydown",function(evt) {
				if(evt.keyCode==13){ // evt.keyCode==13 : Enter 키
					var msg=$("input[name=chatInput]").val();
				ws.send(msg);//서버에 문자를 전송
				$("input[name=chatInput]").val("");
				}
			});
		}
		//서버에서 메세지 수신된 경우
		ws.onmessage=function(event){
			$("textarea").eq(0).append(event.data+"\n");//event.data : 서버에서 전송된 메세지. 수신된 메세지.
			//prepend : 앞쪽에 출력하기.
			//append : 뒤쪽에 출력하기
		}
		//서버와 연결이 끊어 진 경우
		ws.onclose=function(event){
			$("#chatStatus").text("info:connection closed");
		}
	})
</script>
</head>
<body><p>
<div id="chatStatus"></div>
<textarea name="chatMsg" rows="15" cols="40"></textarea>
<br>
메세지 입력 : <input type="text" name="chatInput">
</body>
</html>