<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<fmt:requestEncoding value="UTF-8"/>
<sql:setDataSource var="conn" driver="org.mariadb.jdbc.Driver" url="jdbc:mariadb://localhost:3306/bigdb" 	user="scott" password="tiger" />
<sql:query var="rs" dataSource="${conn}">
	select * from board where ${param.column} like ?
	<sql:param>%${param.find}%</sql:param>
</sql:query>
<table border="1" style="border-collapse: collapse;">
	<tr>
		<th>작성자</th>
		<th>제목</th>
		<th>내용</th>
		<th>첨부파일</th>
	</tr>
	<c:forEach var="data" items="${rs.rows}">
		<tr>
			<td>${data.name}</td>
			<td>${data.title}</td>
			<td>${data.content}</td>
			<td>${data.file1}</td>
		</tr>
	</c:forEach>
</table>



