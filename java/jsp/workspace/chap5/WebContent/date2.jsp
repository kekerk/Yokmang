<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%--
date 속성이 있는 경우 :
session에 등록된 date속성을 조회하여 화면에 '반갑습니다. 등록된 날짜는 ~"
등록된 속성 제거.

date 속성 없는 경우 : 
date 속성이 없는 경우 alert 창에 "등록된 날짜 없음."
등록된 데이트 속성 제거.
 --%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%  // 스크립트릿 
	String d = (String)session.getAttribute("date"); // date 속성 조회하여 "yyyy-MM-dd hh:mm:ss a"형식으로 등록된 문자열을 d에 저장한다.
	if(d == null){ %> <%-- 등록된 속성이 없는 경우 --%>
	<script type="text/javascript">
	alert("등록된 날짜 없음");
	//history.go(-1);
	   location.href="date1.jsp";
</script>

<%		
	} else { %> <%-- 등록된 속성이 있는 경우 --%>
반갑습니다. 등록된 날짜는 <%=d %> <br> <%-- 표현식 --%>
<% session.removeAttribute("date"); }%> <%-- date 속성을 삭제한다. --%>


</body>
</html>