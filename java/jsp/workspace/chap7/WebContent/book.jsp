<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- /WebContent/book.jsp --%>
    <% request.setCharacterEncoding("euc-kr"); %>
    <jsp:useBean id="book" class="chap7.Book" scope="request"/>
     <%-- 
     		useBean : chap7.Book 클래스의 객체를 생성해서 book라고 하는 참조변수로 참조.
     		scope="request" : scope 영역에 request 속성으로 등록을 함.
     									   request.setAttribute("book",book) : request 영역에 속성으로 등록.
     									   pageContext.setAttribute("book",book) : page 영역에 속성으로 등록.
       --%>
    <jsp:setProperty property="*" name="book"/>
    <%-- 
    	  <jsp:setProperty : bean클래스의 setter 호출함.  
    	   property="*"   ->   book 객체에 setProperty와 parameter를 매칭.
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
<title>방명록</title>
</head>
<body>
<table border="1" style="border-collapse : collapse;">
<caption>방명록 조회</caption>
<%--  
	jsp:getProperty : getter 호출
			getWriter() 메서드 호출 
 --%>
<tr><td>방문자</td><td><jsp:getProperty property="writer" name="book"/></td></tr>
<tr><td>제목</td><td><jsp:getProperty property="title" name="book"/></td></tr>
<tr><td>방문자</td><td><jsp:getProperty property="content" name="book"/></td></tr>
</table>
</body>
</html>