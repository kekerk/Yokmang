<%@page import="model.BoardDao"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<%
	Board board = new Board();
	String path = application.getRealPath("/") + "model1/board/file/";
	MultipartRequest multi = new MultipartRequest(request,path, 10*1024*1024,"euc-kr");
	board.setName(multi.getParameter("name"));
	board.setPass(multi.getParameter("pass"));
	board.setTitle(multi.getParameter("title"));
	board.setContent(multi.getParameter("content"));
	board.setFile1(multi.getFilesystemName("file1")); 
	board.setNum(Integer.parseInt(multi.getParameter("num")));

	BoardDao dao = new BoardDao();
	Board bd = dao.selectOne(Integer.parseInt(multi.getParameter("num")));
	String msg =null;
	String url = null;
	if(!bd.getPass().equals(board.getPass())){
		msg = "비밀번호가 맞지 않습니다.";
		url =  "UForm.jsp?num="+board.getNum();
	}else {
	if(dao.update(board)){
		msg ="등록성공";
		url = "list.jsp";
	}else{
		msg ="등록실패";
		url = "UForm.jsp?num="+board.getNum();
	}
	}
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>