<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- /WebContent/model1/board/replyForm.jsp
				1. ������ �亯�� ��� ȭ��.
					������ ���� : num, ref, reflevel, refstep
										num : �Ķ���� ����
				2. �亯�� : ȭ�鿡 �Է¹ޱ�.
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��2 �Խ��� ��� ����</title>

</head>
<body>
<form action="reply.bo" method="post" name="f" >
	<input type="hidden" name="num" value="${board.num}">
	<input type="hidden" name="ref" value="${board.ref }">
	<input type="hidden" name="reflevel" value="${board.reflevel }">
	<input type="hidden" name="refstep" value="${board.refstep }">
	<table border="1" style="border-collapse: collapse;"  class="w3-table-all">
		<caption>��2 �Խñ� ��� ����</caption>
		<tr><td>�۾���</td><td><input type="text" name="name"></td></tr>
		<tr><td>��й�ȣ</td><td><input type="password" name="pass"></td></tr>
		<tr><td>����</td><td><input type="text" name="title" value="RE:${board.title}"></td></tr>
		<tr><td>����</td><td><textarea rows="15" cols="80" name="content"></textarea></td></tr>
		<tr><td colspan="2" align="center">
		<a href="javascript:document.f.submit()">[�亯 ���]</a>
		<a href="javascript:document.f.reset()">[�ٽ� �ۼ�]</a>
		<a href="javascript:history.go(-1)">[�ڷ� ����]</a>
		</td></tr>
	</table>
</form>
</body>
</html>