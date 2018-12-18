<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session 객체를 이용한 장바구니</title>
</head>
<body>
<%
		request.setCharacterEncoding("EUC-KR");
		String product = request.getParameter("product");
		ArrayList<String> list = (ArrayList<String>)session.getAttribute("list"); 
		if(list==null){
			list = new ArrayList<String>();
			session.setAttribute("list", list);
		}
		list.add(product);
%>
<script type="text/javascript">
	alert("<%=product %>이(가) 추가되었습니다.");
	history.go(-1); //한단계 이전 문서로 돌아가기.
</script>
</body>
</html>