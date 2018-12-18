<%@page import="model.BoardDao"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- /WebContent/model1/board/U.jsp --%>
<html>
<%
	Board board = new Board();
	String path = application.getRealPath("/") + "model1/board/file/";
	MultipartRequest multi = new MultipartRequest(request,path, 10*1024*1024,"euc-kr");
	board.setName(multi.getParameter("name"));
	board.setTitle(multi.getParameter("title"));
	board.setContent(multi.getParameter("content"));
	if(multi.getFilesystemName("file1")==null){
		board.setFile1(multi.getParameter("file2"));
	}else{
	board.setFile1(multi.getFilesystemName("file1"));
	}
	board.setNum(Integer.parseInt(multi.getParameter("num")));

	BoardDao dao = new BoardDao();
	Board bd = dao.selectOne(Integer.parseInt(multi.getParameter("num")));
	String msg =null;
	String url = null;
	if(!bd.getPass().equals(multi.getParameter("pass"))){
		msg = "비밀번호가 맞지 않습니다.";
		url ="UForm.jsp?num="+board.getNum();

	}else {
	if(dao.update(board)){
		msg ="수정 성공";
		url = "list.jsp";
	}else{
		msg ="수정 실패";
		url = "UForm.jsp?num="+board.getNum();
	}
	}
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>