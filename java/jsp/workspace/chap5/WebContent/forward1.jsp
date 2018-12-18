<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>forward 액션 태그 예제</title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %>
<h1>forward1.jsp 페이지 입니다. forward2.jsp로 forward 되므로 이 내용은 화면에 표시되지 않습니다.</h1>
<jsp:forward page="forward2.jsp"> <!--  jsp:forward page=" "  : 액션 태그 : 실행한 URL을 잡고 있는다.-->
	<jsp:param value="forward1.jsp에서 추가한 파라미터" name="test"/>
		<jsp:param value="Unknown" name="id"/>
</jsp:forward>
</body>
</html>