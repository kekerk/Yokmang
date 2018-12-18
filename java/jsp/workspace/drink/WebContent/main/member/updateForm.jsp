<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보 수정</title>
<script>
$(function() {
    $( "#Datepicker" ).datepicker({
    	dateFormat : "yy-mm-dd",
    	changeYear : true,
    	changeMonth : true,
    	yearRange : 'c-100:c+10'
    });
  } );

function win_open() {
	 var op ="width=500, height=150, left=50, top=150";
	 open("memberimgForm.jsp","",op);
}

function passchg_winopen() {
	var op = "width=500,height=150, left=50, top=150";
	open("passchgForm.jsp?id=${mem.id}","",op);
}
</script>
</head>
<body>
<form action="update.me" name="f" method="post">
 <input type="hidden" name="picture" value="${mem.picture}">
  <table border="1" style="border-collapse: collapse;" class="w3-table-all w3-large">
   <caption>회원 정보 수정</caption>
   <tr><td colspan="6"rowspan="7" align ="center" valign="bottom">
     <img src="img/${mem.picture }" style="width:300px; height:300px;" id="pic"><br>
     <font size="3"><a href="javascript:win_open()">사진수정</a></font></td>
     <td>아이디</td><td>
     <input type="text" name="id" value="${mem.id}" readonly>
  </td></tr>
  <tr><td>비밀번호</td>
  <td><input type="password" name="pass" value="${mem.pass }"></td>
  </tr>
  <tr><td>이름</td>
  <td><input type="text" name="name" value="${mem.name}"></td>
  </tr>
 <tr><td>주량</td>
     <td><input type="text" name="max" value="${mem.max}">
     </td></tr>
   <tr><td>전화번호</td>
     <td colspan="2">&nbsp;:&nbsp;<input type = "text" name="tel" value="${mem.tel}"></td></tr>
   <tr><td>주소</td>
     <td colspan="2">&nbsp;:&nbsp;<input type = "text" name="addr" value="${mem.addr}"></td></tr>
   <tr><td>생년월일</td>
     <td colspan="2">&nbsp;:&nbsp;<input type = "text" name="birthday" id="Datepicker" value="${mem.birthday}"></td></tr>
     <tr><td colspan="3" align="center">
     <input type ="submit" value="회원수정">&nbsp;<input type="button" value = "비밀번호 수정"onclick="passchg_winopen()"></td></tr>
     
 </table>
</form>
</body>
</html>
