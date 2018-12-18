<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8"/>
<sql:setDataSource var="conn" driver="org.mariadb.jdbc.Driver"
	url="jdbc:mariadb://localhost:3306/bigdb" user="scott" password="tiger" />
<sql:query var="rs" dataSource="${conn}">
select * from member where id like ?
<sql:param>%${param.id}%</sql:param>
</sql:query>
<ul>
<c:forEach var="data" items="${rs.rows}">
	<li>${data.id}</li>
</c:forEach>
</ul>