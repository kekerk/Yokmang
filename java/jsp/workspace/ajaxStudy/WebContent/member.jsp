<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- /WebContent/member.jsp --%>
<%-- -------------------------------------------------------------------------------------------------------------------------------------------------------- --%>
<%-- ajax 방식으로 요청시 한글 인코딩이 UTF-8로 인코딩 됨. --%>
<fmt:requestEncoding value="UTF-8"/>
<%-- DataSource : DB Connection 객체를 생성 --%>
<sql:setDataSource var="conn" driver="org.mariadb.jdbc.Driver" url="jdbc:mariadb://localhost:3306/bigdb" 	user="scott" password="tiger" />
<sql:query var="rs" dataSource="${conn}">
	select * from member where name like ?
	<sql:param>%${param.name}%</sql:param>
</sql:query>
<%-- -------------------------------------------------------------------------------------------------------------------------------------------------------- --%>
<table border="1" style="border-collapse: collapse;">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>전화</th>
		<th>이메일</th>
		<th>사진</th>
	</tr>
	<c:forEach var="data" items="${rs.rows}">
		<tr>
			<td>${data.id}</td>
			<td>${data.name}</td>
			<td>${data.tel}</td>
			<td>${data.email}</td>
			<td><img src="picture/${data.picture}" width="50" height="50"></td>
		</tr>
	</c:forEach>
</table>