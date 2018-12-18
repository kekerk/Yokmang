<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<jsp:useBean id="join" class="chap7.Join1"/>
<jsp:setProperty property="*" name="join"/> <%--  jsp:setProperty로 인하여 int형도 String 형으로 자동 형변환--%>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 조회</title>
</head>
<body>
<table border="1" style="border-collapse : collapse;">
<caption> 회원 가입 확인</caption>
<tr><td>아이디</td><td><jsp:getProperty property="id" name="join"/></td></tr>
<tr><td>비밀번호</td><td><jsp:getProperty property="pass" name="join"/></td></tr>
<tr><td>이름</td><td><jsp:getProperty property="name" name="join"/></td></tr>
<tr><td>성별</td><td><jsp:getProperty property="gender" name="join"/></td></tr>
<tr><td>이메일</td><td><jsp:getProperty property="email" name="join"/></td></tr>
<tr><td>생일</td><td><jsp:getProperty property="birth" name="join"/></td></tr>
</table>
</body>
</html>