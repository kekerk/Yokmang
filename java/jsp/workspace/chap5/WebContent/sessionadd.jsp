<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session ��ü�� �̿��� ��ٱ���</title>
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
	alert("<%=product %>��(��) �߰��Ǿ����ϴ�.");
	history.go(-1); //�Ѵܰ� ���� ������ ���ư���.
</script>
</body>
</html>