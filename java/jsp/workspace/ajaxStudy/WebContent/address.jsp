<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ �� ���� ã��</title>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
	function startRequest(rtype, tag) {
		// ���� ������ ������ var�� �տ� ���̸� �ȵȴ�.
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
				alert("�������� : " + httpRequest.status);
			}
		}
	}

	function listAllStates() {
		//response�� xml���� ���� ��ü�� ���ڿ��� �޾ƿ�.(DOM Tree ��ü) xmlDoc�� DOM tree �ֻ���� root node�� ����Ŵ.
		//xml�� <States>�� root tag
		// xmlDoc : xml�� DOM tree�� ���� ���, ��Ʈ���
		var xmlDoc = httpRequest.responseXML;
		// allStates : state tag���� �迭 ��ü(12�� state)
		var allStates = xmlDoc.getElementsByTagName("state");
		var divtag = document.getElementById("result");
		divtag.innerHTML = "���� ��ü ��";
		for (var i = 0; i < allStates.length; i++) {
			//			divtag.innerHTML += "<br>-" + allStates.item(i).childNodes[0].nodeValue;
			divtag.innerHTML += "<br>-"
					+ allStates[i].childNodes.item(0).nodeValue;
		}
	}

	function listPartStates() {
		var xmlDoc = httpRequest.responseXML;
		// node : 
		// document(HTML���� �ֻ���� ���)
		// document.getElementsByTagName(requestTag)[0];
		var node = xmlDoc.getElementsByTagName(requestTag)[0];
		var states = node.getElementsByTagName("state");
		var divtag = document.getElementById("result");
		divtag.innerHTML = "������ " + requestType + "�� ��";
		for (var i = 0; i < states.length; i++) {
			divtag.innerHTML += "<br>-"
					+ states[i].childNodes.item(0).nodeValue;
		}
	}
</script>
</head>
<body>
	<h1>������ �� ����</h1>
	<input type="button" value="���� ��ü ��" onclick="startRequest('all','all')">
	<input type="button" value="���� ���� ��" onclick="startRequest('��','east')">
	<input type="button" value="���� ���� ��" onclick="startRequest('��','west')">
	<input type="button" value="���� ���� ��" onclick="startRequest('��','south')">
	<input type="button" value="���� ���� ��" onclick="startRequest('��','north')">
	<div id="result"></div>
</body>
</html>