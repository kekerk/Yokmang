<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%--
date �Ӽ��� �ִ� ��� :
session�� ��ϵ� date�Ӽ��� ��ȸ�Ͽ� ȭ�鿡 '�ݰ����ϴ�. ��ϵ� ��¥�� ~"
��ϵ� �Ӽ� ����.

date �Ӽ� ���� ��� : 
date �Ӽ��� ���� ��� alert â�� "��ϵ� ��¥ ����."
��ϵ� ����Ʈ �Ӽ� ����.
 --%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%  // ��ũ��Ʈ�� 
	String d = (String)session.getAttribute("date"); // date �Ӽ� ��ȸ�Ͽ� "yyyy-MM-dd hh:mm:ss a"�������� ��ϵ� ���ڿ��� d�� �����Ѵ�.
	if(d == null){ %> <%-- ��ϵ� �Ӽ��� ���� ��� --%>
	<script type="text/javascript">
	alert("��ϵ� ��¥ ����");
	//history.go(-1);
	   location.href="date1.jsp";
</script>

<%		
	} else { %> <%-- ��ϵ� �Ӽ��� �ִ� ��� --%>
�ݰ����ϴ�. ��ϵ� ��¥�� <%=d %> <br> <%-- ǥ���� --%>
<% session.removeAttribute("date"); }%> <%-- date �Ӽ��� �����Ѵ�. --%>


</body>
</html>