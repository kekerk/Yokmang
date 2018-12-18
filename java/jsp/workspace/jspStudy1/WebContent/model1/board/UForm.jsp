<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDao dao = new BoardDao();
	Board board = dao.selectOne(num);
%>
<script type="text/javascript">
function file_delete(){
	document.f.file2.value="";
	file_desc.innerHTML = "";
	
}
</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action = "U.jsp" name="f" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="<%=board.getNum() %>">
	<input type="hidden" name="file2" value="<%=board.getFile1()==null? "":board.getFile1() %>">
	<table border="1" style="border-collapse : collapse;">
	<caption>모델1으로 구현한 게시판 수정 화면</caption>
	<tr>
		<td align="center">작성자</td>
		<td><input type="text" name="name" value="<%=board.getName()%>" readonly></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="password" name="pass" ></td>
	</tr>
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="title" value="<%=board.getTitle()%>" ></td>
	</tr>		
	<tr>
		<td align="center">내용</td>
		<td><textarea rows="15" cols="80" name="content"><%=board.getContent() %></textarea></td>
	</tr>
	<tr>
		<td align="center">첨부파일</td>
	<td>
		<%if(board.getFile1()!=null && !board.getFile1().equals("")){ %>
		<div id ="file_desc"><%=board.getFile1() %><a href="javascript:file_delete()">[첨부파일삭제]</a></div>
		<%} %>
	<input type="file" name="file1"></td>
	</tr>
	<tr>
		<td colspan="3" align="center"><a href="javascript:document.f.submit()">[게시물수정]</a>
		</td>
	</tr>	
</table>
</form>
</body>
</html>