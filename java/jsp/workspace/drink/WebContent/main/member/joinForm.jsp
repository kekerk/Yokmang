<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
<title>회원 가입 화면</title>
<script type="text/javascript">
$(function() {
    $( "#Datepicker" ).datepicker({
    	dateFormat : "yy-mm-dd",
    	changeYear : true,
    	changeMonth : true,
    	yearRange : 'c-100:c+10'
    });
  } );

 function joincheck(f) {
	 if(f.id.value==''){
		 alert('아이디를 입력하세요');
		 f.id.focus();
		 return false;
	 }
	 if(f.pass.value==''){
		 alert('비밀번호를 입력하세요');
		 f.pass.focus();
		 return false;
	 }
	 if(f.name.value=='') {
		 alert('이름을 입력하세요');
		 f.name.focus();
		 return false;
	 }
 }
 function win_open() {
	 var op ="width=500, height=150, left=50, top=150";
	 open("memberimgForm.jsp","",op);
 }
</script>
</head>
<body>
<form action = "join.me" name="f" method="post" onsubmit="return joincheck(this)">
 <input type ="hidden" name="picture" value=""><%-- memberimg.jsp 에서 img.src 의 값과 picture의 value값을 받아와 넣음 --%>
 <table border='1' class="w3-table-all w3-large">
  <caption>주당들아 어서와라</caption>
  <tr>
  <td colspan="6" rowspan="7"><img src="" style="width:300px; height:300px;" id="pic">
  <br><font size="3"><a href ="javascript:win_open()">사진등록</a></font></td>
   <td>아이디</td><td>&nbsp;:&nbsp;<input type = "text" name="id"></td></tr>
   <tr><td>비밀번호</td>
     <td>&nbsp;:&nbsp;<input type = "password" name="pass"></td></tr>
   <tr><td>이름</td>
     <td>&nbsp;:&nbsp;<input type = "text" name="name"></td></tr>
   <tr><td>주량</td>
     <td>&nbsp;:&nbsp;<input type="text" name="max">&nbsp;(소주 기준)</td></tr>
   <tr><td>전화번호</td>
     <td colspan="2">&nbsp;:&nbsp;<input type = "text" name="tel"></td></tr>
   <tr><td>주소</td>
     <td colspan="2">&nbsp;:&nbsp;<input type = "text" name="addr"></td></tr>
   <tr><td>생년월일</td>
     <td colspan="2">&nbsp;:&nbsp;<input type = "text" name="birthday"id="Datepicker"></td></tr>
    <tr><td colspan="3" align="right">
      <input type="submit" value="회원가입">
      <input type="reset" value="초기화">
      </td></tr>
 </table>
</form>
</body>
</html>