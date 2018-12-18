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
<title>�ݺ����� JSTL �±� : forEach</title>
</head>
<body>


<h3>�ݺ������±� : forEach</h3>
<c:forEach var="test" begin="0" end="10" step="2"> 
<%-- 
	begin ���� end���� ���Եȴ�. 
	step�� ������ 1�� �����ϸ� ���� ���.
--%>
	${test}&nbsp;&nbsp;&nbsp;
</c:forEach>


<h3>forEach �±׸� �̿��Ͽ� 1���� 100������ �� ���ϱ� : 
<c:forEach var="test" begin="1" end="100"> <%-- for���� ���� --%>
	<c:set var="sum"  value="${sum+test }" />
</c:forEach>
<mark>${sum}</mark></h3>
<br>


<h3>forEach �±׸� �̿��Ͽ� ������ 2~9�ܱ��� ����ϱ�.</h3>
<c:forEach var="front" begin="2" end="9"> <%-- for���� ���� --%>
<h3>${front}��</h3>
	<c:forEach var="back" begin="1" end="9"> <%-- for���� ���� --%>
	<h4>${front} * ${back} = <c:out value="${front*back}"/></h4>	
	</c:forEach>
</c:forEach>

<%-----------------JSTL Core�� items�Ӽ��� �̿��Ͽ� �迭 ������ �� ����----------------------%>
<h3>forEach �±׸� �̿��� Map ��ü ����ϱ�</h3>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	map.put("name", "ȫ�浿");
	map.put("today", new Date());
	map.put("age", 20);
	pageContext.setAttribute("mapdata", map);
	
	List<Integer> list = new ArrayList<Integer>();
	for(int i=1;i<=10;i++){
		list.add(i*10);
		
	pageContext.setAttribute("list", list);
	}
%>
<c:forEach var="m" items="${mapdata }"> <%-- ��ü�� ���� �Ǵ� �迭 ���·� �� �� --%>
	<h4>${m.key } : ${m.value}</h4><br>
</c:forEach>
<%------------------------------------------------------------------------------------------%>
<h3>EL�� �̿��� Map ��ü ����ϱ�</h3>
�̸� : ${mapdata.name}<br>
���ó�¥ : ${mapdata.today}<br>
���� : ${mapdata.age}
<%------------------------------------------------------------------------------------------%>
<h3>forEach �±׸� �̿��Ͽ� list ��ü ����ϱ�</h3>
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
		<h3>forEach �±��� varStatus �Ӽ� �����ϱ�</h3>
	</c:if>
	<c:if test="${stat.index%2==0 }"><br></c:if>
	${stat.count }:${l } &nbsp;&nbsp;&nbsp;
</c:forEach>

<%---------------------varStatus �Ӽ� : index �Ǵ� count �޼��� ���------------------------%>
<h3>forEach �±׷� �迭 ��ü ����ϱ�</h3>
<c:set var="arr" value="<%=new int[]{10,20,30,40,50}%>"/>
<h3>�迭��ü�� ��� ����ϱ� : arr[÷��]=��</h3>
<c:forEach var="l" items="${arr}" varStatus="stat">
	arr[${stat.index}]:${l }<br>
</c:forEach>
<%------------------------------------------------------------------------------------------%>
<h3>�迭 ��ü�� �ι�° ��Һ��� �ΰ��� ����ϱ�</h3>
<c:forEach var="l" items="${arr}" varStatus="stat" begin="1" end="2">
<%-- begin�� end�� ÷���� ���۰� �� --%>
arr[${stat.index}]:${l }<br>
</c:forEach>
<h3>�迭 ��ü�� ¦�� ÷�� ��Ҹ� ����ϱ�</h3>
<c:forEach var="l" items="${arr}" varStatus="stat" step="2">
<%-- step�� ÷�ڰ��� ���� --%>
arr[${stat.index}]:${l }<br>
</c:forEach>
</body>
</html>

