<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�۾���</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script>
 $(function(){
	$("#file1").on("change",function(){
		readURL(this);
	}) 
 })
 function readURL(input) {
	 if(input.files && input.files[0]){
		 var reader = new FileReader();
		 reader.onload = function(e){
			 $("#pic").attr("src",e.target.result)
		 }
		 reader.readAsDataURL(input.files[0]);
	 }
 }
 function board_submit(){
	 if(document.f.name.value==''){
		 alert('�̸��� �Է��ϼ���');
		 document.f.name.focus();
		 return;
	 }
	 if(document.f.pass.value==''){
		 alert('��й�ȣ�� �Է��ϼ���');
		 document.f.pass.focus();
		 return;
	 }
	 if(document.f.title.value==''){
		 alert('������ �Է��ϼ���');
		 document.f.title.focus();
		 return;
	 }
	 if(document.f.content.value==''){
		 alert('������ �Է��ϼ���');
		 document.f.content.focus();
		 return;
	 }
	 document.f.submit();
 }
</script>
<style>
 caption{
   font-size:20pt;
   font-weight:bold;
 }
</style>
</head>
<body>
<form name = "f" action ="write.bo" method="post" enctype="multipart/form-data">
<input type="hidden" value="${param.code}" name="code">
 <table border="1" style="border-collapse: collapse;" class="w3-table-all">
   <caption>Write</caption>
   <tr><td rowspan="5" style="width:350px; height:550px;"><img src="img/${b.file1}" style="width:350px; height:550px;" name="pic" id="pic"></td></tr>
     <tr><td align = "center">�۾���&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp; 
     <input type="text" value="������" name="name" readonly="readonly"></td></tr>
     <tr><td align = "center">��й�ȣ&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;
     <input type="password" name="pass"></td></tr>
          <tr><td align = "center">���� &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;     
     <input type="text" name="title"></td></tr>
     <tr><td>
     <textarea rows="20" cols="95" name="content"></textarea></td></tr>
     <tr><td align = "center">÷������</td>
     <td><input type="file" name="file1" id="file1"></td></tr>
     <tr><td colspan="15" align ="center">
     <a href="javascript:board_submit()">[�Խù� ���]</a></td></tr>
 </table>
</form>
</body>
</html>