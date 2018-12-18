<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- webcontent/model2/board/writeForm.jsp --%>
<html>
<head>
<meta charset="EUC-KR">
<title>모델2 게시판 글쓰기</title>

<script type="text/javascript">
function board_submit(){
	<%-- 내용 입력 안하면 못넘어가게 --%>
	if(document.f.name.value.length==0){
		alert("글쓴이를 입력하세요");
		document.f.name.focus();
		return;
	}
	if(document.f.pass.value.length==0){
		alert("비밀번호를 입력하세요");
		document.f.pass.focus();
		return;
	}
	if(document.f.title.value.length==0){
		alert("제목을 입력하세요");
		document.f.title.focus();
		return;
	}
	if(document.f.content.value.length==0){
		alert("내용을 입력하세요");
		document.f.content.focus();
		return;
	}
	document.f.submit();
}
</script>
</head>
<body>
<form action="write.bo" name="f" method="post" enctype="multipart/form-data">
	<table border="1" style="border-collapse: collapse;"  class="w3-table-all">
	<caption>모델1 게시판 글쓰기</caption>
	<tr>
	<td align="center">글쓴이</td>
	<td><input type="text" name="name"></td>
	</tr>	
	<tr>
	<td align="center">비밀번호</td>
	<td><input type="password" name="pass"></td>
	</tr>
	<tr>
	<td align="center">제목</td>
	<td><input type="text" name="title"></td>
	</tr>		
	<tr>
	<td align="center">내용</td>
	<td><textarea rows="15" cols="80" name="content">내용을 입력하세요</textarea></td>
	</tr>	
	<tr>
	<td align="center">첨부파일</td>
	<td><input type="file" name="file1"></td>
	</tr>	
	<tr>
	<td colspan="2" align="center">
	<a href="javascript:board_submit()">[게시물 등록]</a></td>
	</tr>	
	</table>
</form>
</body>
</html>