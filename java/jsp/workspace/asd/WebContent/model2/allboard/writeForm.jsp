<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%-- webcontent/model2/board/writeForm.jsp --%>
<html>
<head>
<meta charset="EUC-KR">
<title>Write</title>
<style type="text/css">
caption {
	font :bold;
	font-size: x-large;
}
td {
	padding : 10px;
}
</style>
<script type="text/javascript">
function board_submit(){
	if(document.f.password.value.length==0){
		alert("Input Password");
		document.f.pass.focus();
		return;
	}
	if(document.f.title.value.length==0){
		alert("Input Title");
		document.f.title.focus();
		return;
	}
	if(document.f.content.value.length==0){
		alert("Input Content");
		document.f.content.focus();
		return;
	}
	if(document.f.boardtype.value == 1 || document.f.boardtype.value==2){
		
		if(document.f.file1.value.length==0){
			alert("Select file");
			document.f.file1.focus();
			return;
		}	
	}
	
	document.f.submit();
}
</script>
</head>
<body>
<%--명장면 및 후기 게시판 부분 --%>
<c:if test="${param.boardtype == 1}">
<div style="margin: 50px; padding: 25px;" align="center">
<form action="write.all?boardtype=${param.boardtype}" name="f" method="post" enctype="multipart/form-data">
<input type="hidden" name="boardtype" value="${param.boardtype}">
<input type="hidden" name="id" value="${member.id}">
<input type="hidden" name="dormi" value="${member.dormi}">

	<table border="1" style="border-collapse: collapse;"  class="w3-table-all w3-centered">
	<caption>명장면 및 후기 게시판 글쓰기</caption>
	<tr>
	<td align="center">작성자</td>
	<td><input type="text" name="nickname" value="${member.nickname}" readonly></td>
	<td align="center">비밀번호</td>
	<td><input type="password" name="password" value="${member.password}" readonly></td>
	</tr>
	<tr>
	<td align="center">제목</td>
	<td><input type="text" name="title"></td>
	<td align="center">시리즈 선택 창</td>
	<td><select name="seriesno">
	<c:if test="${!empty param.seriesno}">
		<c:if test="${param.seriesno == 1}"><option value="1" selected="selected">해리포터와 마법사의 돌</option></c:if>
		<c:if test="${param.seriesno == 2}"><option value="2" selected="selected">해리포터와 비밀의 방</option></c:if>
		<c:if test="${param.seriesno == 3}"><option value="3" selected="selected">해리포터와 아즈카반의 죄수</option></c:if>
		<c:if test="${param.seriesno == 4}"><option value="4" selected="selected">해리포터와 불의 잔</option></c:if>
		<c:if test="${param.seriesno == 5}"><option value="5" selected="selected">해리포터와 불사조 기사단</option></c:if>
		<c:if test="${param.seriesno == 6}"><option value="6" selected="selected">해리포터와 혼혈왕자</option></c:if>
		<c:if test="${param.seriesno == 7}"><option value="7" selected="selected">해리포터와 죽음의 성물 1</option></c:if>
		<c:if test="${param.seriesno == 8}"><option value="8" selected="selected">해리포터와 죽음의 성물 2</option></c:if>
		<c:if test="${param.seriesno == 9}"><option value="9" selected="selected">신비한 동물사전</option></c:if>
	</c:if>
	<c:if test="${empty param.seriesno}">
		<option value="1">해리포터와 마법사의 돌</option>
		<option value="2">해리포터와 비밀의 방</option>
		<option value="3">해리포터와 아즈카반의 죄수</option>
		<option value="4">해리포터와 불의 잔</option>
		<option value="5">해리포터와 불사조 기사단</option>
		<option value="6">해리포터와 혼혈왕자</option>
		<option value="7">해리포터와 죽음의 성물 1</option>
		<option value="8">해리포터와 죽음의 성물 2</option>
		<option value="9">신비한 동물사전</option>
		</c:if>
	</select></td>
	</tr>		
	<tr>
	
	<td colspan="4"><textarea rows="15" cols="80" name="content" placeholder="내용을 입력하세요"></textarea></td>
	</tr>	
	<tr>
	<td align="center">File</td>
	<td><input type="file" name="file1"></td>	
	<td colspan="2" align="center">
	<a href="javascript:board_submit()" class="w3-button w3-black" style="text-decoration: none;">register</a>
	<a href="list.all?boardtype=${param.boardtype}" class="w3-button w3-black" style="text-decoration: none;">List</a></td>
	</tr>	
	</table>
</form>
</div>
<%-- 갤러리 게시판 부분 --%>
</c:if>
<c:if test="${param.boardtype == 2}">
<div style="margin: 50px; padding: 25px;" align="center">
<form action="write.all?boardtype=${param.boardtype}" name="f" method="post" enctype="multipart/form-data">
<input type="hidden" name="boardtype" value="${param.boardtype}">
<input type="hidden" name="id" value="${sessionScope.login}">
<input type="hidden" name="dormi" value="${member.dormi}">
	<table border="1" style="border-collapse: collapse;"  class="w3-table-all w3-centered">
	<caption>갤러리 게시판 글쓰기</caption>
	<tr>
	<td align="center">작성자</td>
	<td><input type="text" name="nickname" value="${member.nickname}" readonly></td><td colspan="2">자유 갤러리</td>
	</tr>
	<tr>
	<td align="center">비밀번호</td>
	<td><input type="password" name="password" value="${member.password}" readonly></td>
	<td align="center">제목</td>
	<td><input type="text" name="title"></td>
	</tr>		
	<tr>
	<td colspan="4"><textarea rows="15" cols="80" name="content" placeholder="내용을 입력하세요"></textarea></td>
	</tr>	
	<tr>
	<td align="center">File</td>
	<td><input type="file" name="file1"></td>	
	<td colspan="2" align="center">
	<a href="javascript:board_submit()" class="w3-button w3-black" style="text-decoration: none;">register</a>
	<a href="list.all?boardtype=${param.boardtype}" class="w3-button w3-black" style="text-decoration: none;">List</a></td>
	</tr>	
	</table>
</form>
</div>
</c:if>
<%-- 기숙사별 게시판 부분 --%>
<c:if test="${param.boardtype == 3}">
<div style="margin: 50px; padding: 25px;" align="center">
<form action="write.all?boardtype=${param.boardtype}" name="f" method="post" enctype="multipart/form-data">
<input type="hidden" name="boardtype" value="${param.boardtype}">
<input type="hidden" name="id" value="${sessionScope.login}">
<input type="hidden" name="dormi" value="${sessionScope.dormi}">
	<table border="1" style="border-collapse: collapse;"  class="w3-table-all">
	<caption>기숙사별 게시판 글쓰기</caption>
	<tr>
	<td align="center">글쓴이</td>
	<td><input type="text" name="nickname" value="${member.nickname}" readonly></td>
	</tr>	
	<tr>
	<td align="center">비밀번호</td>
	<td><input type="password" name="password" value="${member.password}" readonly></td>
	</tr>
	<tr>
	<td align="center">제목</td>
	<td><input type="text" name="title"></td>
	</tr>		
	<tr>
	<td align="center">내용</td>
	<td><textarea rows="15" cols="80" name="content" placeholder="내용을 입력하세요"></textarea></td>
	</tr>	
	<tr>
	<td align="center">File</td>
	<td><input type="file" name="file1"></td>
	</tr>	
	<tr>
	<td colspan="2" align="center">
	<a href="javascript:board_submit()" class="w3-button w3-black" style="text-decoration: none;">register</a>
	<a href="list.all?boardtype=${param.boardtype}" class="w3-button w3-black" style="text-decoration: none;">List</a></td>
	</tr>	
	</table>
</form>
</div>
</c:if>
<c:if test="${param.boardtype == 4}">
<div style="margin: 50px; padding: 25px;" align="center">
<form action="write.all?boardtype=${param.boardtype}" name="f" method="post" enctype="multipart/form-data">
<input type="hidden" name="boardtype" value="${param.boardtype}">
<input type="hidden" name="id" value="${sessionScope.login}">
<input type="hidden" name="dormi" value="${member.dormi}">
	<table border="1" style="border-collapse: collapse;"  class="w3-table-all">
	<caption>자유 게시판 글쓰기</caption>
	<tr>
	<td align="center">글쓴이</td>
	<td><input type="text" name="nickname" value="${member.nickname}" readonly></td>
	</tr>	
	<tr>
	<td align="center">비밀번호</td>
	<td><input type="password" name="password" value="${member.password}" readonly></td>
	</tr>
	<tr>
	<td align="center">제목</td>
	<td><input type="text" name="title"></td>
	</tr>		
	<tr>
	<td align="center">내용</td>
	<td><textarea rows="15" cols="80" name="content" placeholder="내용을 입력하세요"></textarea></td>
	</tr>	
	<tr>
	<td align="center">첨부파일</td>
	<td><input type="file" name="file1"></td>
	</tr>	
	<tr>
	<td colspan="2" align="center">
	<a href="javascript:board_submit()" class="w3-button w3-black" style="text-decoration: none;">register</a>
	<a href="list.all?boardtype=${param.boardtype}" class="w3-button w3-black" style="text-decoration: none;">List</a></td>
	</tr>	
	</table>
</form>
</div>
</c:if>
</body>
</html>