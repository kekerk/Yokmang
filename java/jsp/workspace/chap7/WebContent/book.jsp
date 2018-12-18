<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- /WebContent/book.jsp --%>
    <% request.setCharacterEncoding("euc-kr"); %>
    <jsp:useBean id="book" class="chap7.Book" scope="request"/>
     <%-- 
     		useBean : chap7.Book Ŭ������ ��ü�� �����ؼ� book��� �ϴ� ���������� ����.
     		scope="request" : scope ������ request �Ӽ����� ����� ��.
     									   request.setAttribute("book",book) : request ������ �Ӽ����� ���.
     									   pageContext.setAttribute("book",book) : page ������ �Ӽ����� ���.
       --%>
    <jsp:setProperty property="*" name="book"/>
    <%-- 
    	  <jsp:setProperty : beanŬ������ setter ȣ����.  
    	   property="*"   ->   book ��ü�� setProperty�� parameter�� ��Ī.
    	   			writer parameter => setWriter()
    	   			book.setWriter(request.getParameter("writer"))
    	   			title parameter    => setTitle()
    	   			book.setTitle(request.getParameter("title"))
    	   			content parameter    => setContent()
    	   			book.setContent(request.getParameter("content"))
      --%>
      <jsp:setProperty property="title" param="title1" name="book"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����</title>
</head>
<body>
<table border="1" style="border-collapse : collapse;">
<caption>���� ��ȸ</caption>
<%--  
	jsp:getProperty : getter ȣ��
			getWriter() �޼��� ȣ�� 
 --%>
<tr><td>�湮��</td><td><jsp:getProperty property="writer" name="book"/></td></tr>
<tr><td>����</td><td><jsp:getProperty property="title" name="book"/></td></tr>
<tr><td>�湮��</td><td><jsp:getProperty property="content" name="book"/></td></tr>
</table>
</body>
</html>