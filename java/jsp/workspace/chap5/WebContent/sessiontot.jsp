<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>장바구니 상품 보기</title>
</head>
<body>
<h2>장바구니 목록</h2>
<%
ArrayList<String> list = (ArrayList<String>)session.getAttribute("list"); 
	if(list== null || list.size()==0){
%>
	<h3>장바구니에 선택한 상품이 없습니다.</h3>
<%	} else {
		for(String p : list) { %>	
		<h4><%=p %></h4>
<%	}%>

<hr>
<h3> 장바구니에 등록된 상품 갯수 : <%=list.size() %></h3>
<%	} 
	session.removeAttribute("list"); //list 속성을 제거.
	session.invalidate(); //session 객체를 새로 변경.
%>
<!--  session 객체를 공유하는 페이지들을 같은 session 영역이라 한다.
		 session2.jsp, sessionadd.jsp, sessiontot.jsp가 같은 session 영역임.
 -->
</body>
</html>