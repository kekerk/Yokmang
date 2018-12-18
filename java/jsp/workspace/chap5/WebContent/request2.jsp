<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>요청 파라미터 정보 출력</title>
</head>
<body>
<%
    // 파라미터의 기본 인코딩 : 8859_1 : 스페인어
	request.setCharacterEncoding("EUC-KR"); //한글 인코딩. post 가능함. 1번으로 입력.
	String name = request.getParameter("name"); //request로 getParameter할때 속성 타입은 name이어야한다.(id X)
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String hobby = request.getParameter("hobby");
	String year = request.getParameter("year");
%>
<h2>요청 파라미터 한개 출력 하기</h2>
이름 : <%=name %><br>
나이 : <%=age %><br>
성별 : <%=(gender.equals("1")? "남":"여") %><br>
취미 : <%=hobby %><br>
출생년도 : <%=year %><br>
<hr>
<h2>하나의 요청 파라미터에 여러개의 값을 출력하기.</h2>
<%
	String[] hobbies = request.getParameterValues("hobby");
	for(String h : hobbies){ %>
	<%=h %> &nbsp;&nbsp;&nbsp;
<%}%>
<hr>
<h2>파라미터 이름을 조회하여 여러개의 값을 출력하기 </h2>
<table border="2 solid thick"><tr><th>파라미터이름</th><th>파라미터값</th></tr>
<%
// getParameterNames() : 파라미터 이름들 조회
// Enumeration : Iterator의 구버전. 반복자.
	Enumeration e = request.getParameterNames(); // 파라미터 이름을 모를 때. 
 
	while(e.hasMoreElements()){
	String pname = (String)e.nextElement();
	String[] pvalue = request.getParameterValues(pname); %>

<tr><td><%=pname %></td>
		<td><% for(String v : pvalue) { %>
				  <%=v %> &nbsp;&nbsp;&nbsp;
	        	  <%}%></td>
</tr>
<%}%>
</table>
</body>
</html>

<!--  
	request 객체 : 요청 객체. 요청 정보를 저장하고 있는 객체.
						   파라미터 정보. 입력된 값
						    String value = request.getParameter("파라미터이름");
						    String[] values = request.getParameterValues("파라미터이름");
						    Enumeration e = request.getParameterNames(); 파라미터 이름들 리턴.
 -->