<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Էµ� ���ڱ����� ���� ���ϱ�</title>

<script type="text/javascript">
 function sumtest(f,kbn){
	 	f.kbn.value = kbn; // hidden �Ķ���Ϳ� �� ����
	 	//num �Ķ���Ϳ� ���� ���ų�, ���ڰ� �ƴϸ� alert() �޼��� Ȯ�� ��
	 	//num �Ķ���Ϳ� focus ������.
	 	if(f.num.value.length==0){
	 		alert("���� �����ϴ�.");
	 		f.num.focus();
	 		return false;
	 	}
	 	if(isNaN(f.num.value)){
	 		alert("���� ���ڰ� �ƴմϴ�.");
	 		f.num.value = " ";
	 		f.num.focus();
	 		return false;
	 	}
	 	f.submit(); // submit �߻���Ŵ.  -> requesttest2.jsp ��� �Ѿ.
	 
 }
 function optest(f){
	 if(f.num1.value.length==0){
		 alert("���� �����ϴ�.");
		 f.num1.focus();
		 return false;
	 }
	 else if(f.num2.value.length==0){
		 alert("���� �����ϴ�.");
		 f.num2.focus();
		 return false;
	 }
	 if(isNaN(f.num1.value)){
		 alert("���� ���ڰ� �ƴմϴ�.");
		 f.num1.value="";
		 f.num1.focus();
		 return false;
	 }
	 else if(isNaN(f.num2.value)){
		 alert("���� ���ڰ� �ƴմϴ�.");
		 f.num2.value="";
		 f.num2.focus();
		 return false;
	 }
 }
</script>
</head>
<body>
<form action="requesttest2.jsp" method="post" >
	<input type="hidden" name="kbn">
	<input type="text" name="num">������ �� ���ϱ�
	<input type="button" value="�հ豸�ϱ�" onclick="sumtest(this.form,1)">
	<input type="button" value="¦�� �հ� ���ϱ�" onclick="sumtest(this.form,2) ">
	<input type="button" value="Ȧ�� �հ� ���ϱ�" onclick=" sumtest(this.form,3)">
</form>
<form action="requesttest3.jsp" method="post" onsubmit="return optest(this)"> <!--  return�� ����� false�� submit ���...? �̹� onsubmit-->
    <input type="hidden" name="kbn">
	<input type="text" name="num1">
	<select name="op">
	<option>+</option>
	<option>-</option>
	<option>*</option>
	<option>/</option>
	</select>
	<input type="text" name="num2">
	<input type="submit" value="������ϱ�" >
</form>
</body>
</html>