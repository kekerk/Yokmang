<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
<title>ȸ�� ���� ȭ��</title>
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
		 alert('���̵� �Է��ϼ���');
		 f.id.focus();
		 return false;
	 }
	 if(f.pass.value==''){
		 alert('��й�ȣ�� �Է��ϼ���');
		 f.pass.focus();
		 return false;
	 }
	 if(f.name.value=='') {
		 alert('�̸��� �Է��ϼ���');
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
 <input type ="hidden" name="picture" value=""><%-- memberimg.jsp ���� img.src �� ���� picture�� value���� �޾ƿ� ���� --%>
 <table border='1' class="w3-table-all w3-large">
  <caption>�ִ��� ��Ͷ�</caption>
  <tr>
  <td colspan="6" rowspan="7"><img src="" style="width:300px; height:300px;" id="pic">
  <br><font size="3"><a href ="javascript:win_open()">�������</a></font></td>
   <td>���̵�</td><td>&nbsp;:&nbsp;<input type = "text" name="id"></td></tr>
   <tr><td>��й�ȣ</td>
     <td>&nbsp;:&nbsp;<input type = "password" name="pass"></td></tr>
   <tr><td>�̸�</td>
     <td>&nbsp;:&nbsp;<input type = "text" name="name"></td></tr>
   <tr><td>�ַ�</td>
     <td>&nbsp;:&nbsp;<input type="text" name="max">&nbsp;(���� ����)</td></tr>
   <tr><td>��ȭ��ȣ</td>
     <td colspan="2">&nbsp;:&nbsp;<input type = "text" name="tel"></td></tr>
   <tr><td>�ּ�</td>
     <td colspan="2">&nbsp;:&nbsp;<input type = "text" name="addr"></td></tr>
   <tr><td>�������</td>
     <td colspan="2">&nbsp;:&nbsp;<input type = "text" name="birthday"id="Datepicker"></td></tr>
    <tr><td colspan="3" align="right">
      <input type="submit" value="ȸ������">
      <input type="reset" value="�ʱ�ȭ">
      </td></tr>
 </table>
</form>
</body>
</html>