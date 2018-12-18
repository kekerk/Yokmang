<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- /WebContent/jstl/jstlcore3.jsp --%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>반복관련 JSTL 태그 : forEach</title>
</head>
<body>


<h3>반복관련태그 : forEach</h3>
<c:forEach var="test" begin="0" end="10" step="2"> 
<%-- 
	begin 값과 end값도 포함된다. 
	step이 없으면 1씩 증가하며 전부 출력.
--%>
	${test}&nbsp;&nbsp;&nbsp;
</c:forEach>


<h3>forEach 태그를 이용하여 1부터 100까지의 합 구하기 : 
<c:forEach var="test" begin="1" end="100"> <%-- for문의 역할 --%>
	<c:set var="sum"  value="${sum+test }" />
</c:forEach>
<mark>${sum}</mark></h3>
<br>


<h3>forEach 태그를 이용하여 구구단 2~9단까지 출력하기.</h3>
<c:forEach var="front" begin="2" end="9"> <%-- for문의 역할 --%>
<h3>${front}단</h3>
	<c:forEach var="back" begin="1" end="9"> <%-- for문의 역할 --%>
	<h4>${front} * ${back} = <c:out value="${front*back}"/></h4>	
	</c:forEach>
</c:forEach>

<%-----------------JSTL Core의 items속성을 이용하여 배열 형태의 값 저장----------------------%>
<h3>forEach 태그를 이용한 Map 객체 출력하기</h3>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	map.put("name", "홍길동");
	map.put("today", new Date());
	map.put("age", 20);
	pageContext.setAttribute("mapdata", map);
	
	List<Integer> list = new ArrayList<Integer>();
	for(int i=1;i<=10;i++){
		list.add(i*10);
		
	pageContext.setAttribute("list", list);
	}
%>
<c:forEach var="m" items="${mapdata }"> <%-- 객체의 집합 또는 배열 형태로 들어갈 때 --%>
	<h4>${m.key } : ${m.value}</h4><br>
</c:forEach>
<%------------------------------------------------------------------------------------------%>
<h3>EL을 이용한 Map 객체 출력하기</h3>
이름 : ${mapdata.name}<br>
오늘날짜 : ${mapdata.today}<br>
나이 : ${mapdata.age}
<%------------------------------------------------------------------------------------------%>
<h3>forEach 태그를 이용하여 list 객체 출력하기</h3>
<c:forEach var="l" items="<%=list %>">
		${l }<br>
</c:forEach>
<br>
<c:forEach var="l" items="${list }">
		${l }<br>
</c:forEach>
<%------------------------------------------------------------------------------------------%>
<c:forEach var="l" items="${list }" varStatus="stat">
	<c:if test="${stat.index==0 }">
		<h3>forEach 태그의 varStatus 속성 연습하기</h3>
	</c:if>
	<c:if test="${stat.index%2==0 }"><br></c:if>
	${stat.count }:${l } &nbsp;&nbsp;&nbsp;
</c:forEach>

<%---------------------varStatus 속성 : index 또는 count 메서드 사용------------------------%>
<h3>forEach 태그로 배열 객체 출력하기</h3>
<c:set var="arr" value="<%=new int[]{10,20,30,40,50}%>"/>
<h3>배열객체의 요소 출력하기 : arr[첨자]=값</h3>
<c:forEach var="l" items="${arr}" varStatus="stat">
	arr[${stat.index}]:${l }<br>
</c:forEach>
<%------------------------------------------------------------------------------------------%>
<h3>배열 객체의 두번째 요소부터 두개만 출력하기</h3>
<c:forEach var="l" items="${arr}" varStatus="stat" begin="1" end="2">
<%-- begin과 end는 첨자의 시작과 끝 --%>
arr[${stat.index}]:${l }<br>
</c:forEach>
<h3>배열 객체의 짝수 첨자 요소만 출력하기</h3>
<c:forEach var="l" items="${arr}" varStatus="stat" step="2">
<%-- step은 첨자간의 간격 --%>
arr[${stat.index}]:${l }<br>
</c:forEach>
</body>
</html>

