<%@ page language="java" contentType="text/html; charset=EUC-KR"    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!--  chap4 프로젝트  생성
		 /WebContent/comment1.jsp -->
<html>
<head>
<meta charset="EUC-KR">
<title>주석 설명</title>
</head>
<body>
<h1>jsp에서 사용되는 주석 3가지</h1>
<ol> <!--  ol 리스트 기본값 : 1 -->
	<li>jsp 주석 : &lt;%-- JSP 주석 표현 --%&gt;</li>
	<!--  이곳은 JSP 주석입니다. JSP 페이지에서만 보여지고 서블릿에서는 보여지지 않습니다. -->
	<li>자바주석 : &lt;% // 한줄 자바 주석 %&gt;
						   &lt;% /* 여러줄 자바 주석 */ %&gt;<br>
						  자바 영역에서 사용되는 주석. 스크립트 내부에서 사용됩니다.<br>
						  자바 주석은 jsp와 servlet에서 볼 수 있습니다.
	</li>
	<% //한줄 주석입니다.
		  /* 여러줄 주석입니다 */ 
    	  String msg = "HTML 주석";
	%>
	<li> HTML 주석 : &lt;!-- HTML 주석 표현 --&gt;<br>
			JSP나 서블릿에서는 주석이 아닙니다.<br>
			브라우저에서 화면 출력시 주석으로 인식합니다.
			<!--  <%=msg %> 이곳은 HTML 주석입니다. 서블릿까지 주석이 아닙니다. HTML 주석은 브라우저의 소스보기로 볼 수 있습니다. -->
	</li>
</ol>
</body>
</html>