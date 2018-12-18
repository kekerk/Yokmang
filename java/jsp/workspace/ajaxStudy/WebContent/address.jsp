<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>서울의 구 정보 찾기</title>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
	function startRequest(rtype, tag) {
		// 전역 변수로 쓰려면 var을 앞에 붙이면 안된다.
		requestType = rtype;
		requestTag = tag;
		sendRequest("address.xml", null, parseResult, "GET");
	}
	
	function parseResult() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				if (requestType == 'all')
					listAllStates();
				else
					listPartStates();
			} else {
				alert("서버오류 : " + httpRequest.status);
			}
		}
	}

	function listAllStates() {
		//response된 xml파일 내용 전체를 문자열로 받아옴.(DOM Tree 객체) xmlDoc는 DOM tree 최상단의 root node를 가리킴.
		//xml의 <States>는 root tag
		// xmlDoc : xml의 DOM tree의 문서 노드, 루트노드
		var xmlDoc = httpRequest.responseXML;
		// allStates : state tag들의 배열 객체(12개 state)
		var allStates = xmlDoc.getElementsByTagName("state");
		var divtag = document.getElementById("result");
		divtag.innerHTML = "서울 전체 구";
		for (var i = 0; i < allStates.length; i++) {
			//			divtag.innerHTML += "<br>-" + allStates.item(i).childNodes[0].nodeValue;
			divtag.innerHTML += "<br>-"
					+ allStates[i].childNodes.item(0).nodeValue;
		}
	}

	function listPartStates() {
		var xmlDoc = httpRequest.responseXML;
		// node : 
		// document(HTML문서 최상단의 노드)
		// document.getElementsByTagName(requestTag)[0];
		var node = xmlDoc.getElementsByTagName(requestTag)[0];
		var states = node.getElementsByTagName("state");
		var divtag = document.getElementById("result");
		divtag.innerHTML = "서울의 " + requestType + "쪽 구";
		for (var i = 0; i < states.length; i++) {
			divtag.innerHTML += "<br>-"
					+ states[i].childNodes.item(0).nodeValue;
		}
	}
</script>
</head>
<body>
	<h1>서울의 구 정보</h1>
	<input type="button" value="서울 전체 구" onclick="startRequest('all','all')">
	<input type="button" value="서울 동쪽 구" onclick="startRequest('동','east')">
	<input type="button" value="서울 서쪽 구" onclick="startRequest('서','west')">
	<input type="button" value="서울 남쪽 구" onclick="startRequest('남','south')">
	<input type="button" value="서울 북쪽 구" onclick="startRequest('북','north')">
	<div id="result"></div>
</body>
</html>