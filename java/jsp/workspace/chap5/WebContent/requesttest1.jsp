<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>입력된 숫자까지의 합을 구하기</title>

<script type="text/javascript">
 function sumtest(f,kbn){
	 	f.kbn.value = kbn; // hidden 파라미터에 값 저장
	 	//num 파라미터에 값이 없거나, 숫자가 아니면 alert() 메세지 확인 후
	 	//num 파라미터에 focus 보내기.
	 	if(f.num.value.length==0){
	 		alert("값이 없습니다.");
	 		f.num.focus();
	 		return false;
	 	}
	 	if(isNaN(f.num.value)){
	 		alert("값이 숫자가 아닙니다.");
	 		f.num.value = " ";
	 		f.num.focus();
	 		return false;
	 	}
	 	f.submit(); // submit 발생시킴.  -> requesttest2.jsp 제어가 넘어감.
	 
 }
 function optest(f){
	 if(f.num1.value.length==0){
		 alert("값이 없습니다.");
		 f.num1.focus();
		 return false;
	 }
	 else if(f.num2.value.length==0){
		 alert("값이 없습니다.");
		 f.num2.focus();
		 return false;
	 }
	 if(isNaN(f.num1.value)){
		 alert("값이 숫자가 아닙니다.");
		 f.num1.value="";
		 f.num1.focus();
		 return false;
	 }
	 else if(isNaN(f.num2.value)){
		 alert("값이 숫자가 아닙니다.");
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
	<input type="text" name="num">까지의 합 구하기
	<input type="button" value="합계구하기" onclick="sumtest(this.form,1)">
	<input type="button" value="짝수 합계 구하기" onclick="sumtest(this.form,2) ">
	<input type="button" value="홀수 합계 구하기" onclick=" sumtest(this.form,3)">
</form>
<form action="requesttest3.jsp" method="post" onsubmit="return optest(this)"> <!--  return의 결과가 false면 submit 취소...? 이미 onsubmit-->
    <input type="hidden" name="kbn">
	<input type="text" name="num1">
	<select name="op">
	<option>+</option>
	<option>-</option>
	<option>*</option>
	<option>/</option>
	</select>
	<input type="text" name="num2">
	<input type="submit" value="결과구하기" >
</form>
</body>
</html>