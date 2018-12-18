<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>아이디 비밀번호 찾기</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#idsearch").click(function() {
		$.ajax({
			url : "ajax3.jsp",
			type:"POST",
			data : {id:$("#id").val(),tel:$("#tel").val(),email:$("#email").val()},
			success : function(data){
				$("#con").html(data);
			}
		})	
	})
})
</script>
</head>
<body>
id : <input type="text" id="id"><br>
telephone : <input type="text" id="tel"><br>
email : <input type="text" id="email"><br>
<button id="idsearch">아이디찾기</button>
<div id="con"></div>
</body>
</html>