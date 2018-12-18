<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />
<sql:setDataSource var="conn" driver="org.mariadb.jdbc.Driver"
	url="jdbc:mariadb://localhost:3306/bigdb" user="scott" password="tiger" />
<sql:query var="rs" dataSource="${conn}">
	select * from member where id = '${param.id}'
</sql:query>
<c:forEach var="col" items="${rs.rows}">
	<c:choose>
		<c:when test="${ col.tel == param.tel && col.email == param.email }">
			<h3>비밀번호는 ${col.pass} 입니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>${col.id}님의 정보와 입력하신 정보가 맞지 않습니다.</h3>
		</c:otherwise>
	</c:choose>
</c:forEach>