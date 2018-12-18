<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- /WebContent/model1/board/replyForm.jsp
				1. 원글의 답변글 등록 화면.
					원글의 정보 : num, ref, reflevel, refstep
										num : 파라미터 정보
				2. 답변글 : 화면에 입력받기.
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>모델2 게시판 답글 쓰기</title>

</head>
<body>
<form action="reply.bo" method="post" name="f" >
	<input type="hidden" name="num" value="${board.num}">
	<input type="hidden" name="ref" value="${board.ref }">
	<input type="hidden" name="reflevel" value="${board.reflevel }">
	<input type="hidden" name="refstep" value="${board.refstep }">
	<table border="1" style="border-collapse: collapse;"  class="w3-table-all">
		<caption>모델2 게시글 답글 쓰기</caption>
		<tr><td>글쓴이</td><td><input type="text" name="name"></td></tr>
		<tr><td>비밀번호</td><td><input type="password" name="pass"></td></tr>
		<tr><td>제목</td><td><input type="text" name="title" value="RE:${board.title}"></td></tr>
		<tr><td>내용</td><td><textarea rows="15" cols="80" name="content"></textarea></td></tr>
		<tr><td colspan="2" align="center">
		<a href="javascript:document.f.submit()">[답변 등록]</a>
		<a href="javascript:document.f.reset()">[다시 작성]</a>
		<a href="javascript:history.go(-1)">[뒤로 가기]</a>
		</td></tr>
	</table>
</form>
</body>
</html>