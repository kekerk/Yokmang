<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Author Profile</title>
<style type="text/css">
#authorinfo {
	margin-top: 3%;
	padding: 2%;
}

#authorimg {
	width: 70%;
	margin-top : 50px;
}
</style>
</head>
<body>
	<div id="authorinfo" class="w3-row">
		<div class="w3-third w3-center">
			<img src="${path}/model2/actornseries/img/rowling.PNG" id="authorimg">
		</div>
		<div class="w3-twothird">
			<div>
				<h4>
					<strong>���� K. �Ѹ�</strong>(Joan K. Rowling)
				</h4>
				<p>��� : 1965�� 7�� 31��, ����</p>
				<hr style="border:2px solid silver;">
				<div>
					<h5><strong>�з� ����</strong></h5>
					<p>�Ϲ��� ���б� ���ڻ�</p>
					<p>������ ���б� ���ڻ�</p>
					<p>�����ʹ��б� �ҹ���, ������ �л�</p>
					<h5><strong>���� ����</strong></h5>
					<p>������ ������(2012)</p>
					<p>�ȵ����� ���л�(2010)</p>
					<p>���������� ���߸��� ����(2009)</p>
					<p>������ �۰���(2000)</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>