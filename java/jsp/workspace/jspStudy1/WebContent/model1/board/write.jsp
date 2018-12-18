<%@page import="model.BoardDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Board"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/model1/board/write.jsp
		1. 파라미터 값을 Board 객체 저장.
			 Board 객체 생성하여 MultipartRequest의 파라미터를 하나씩 저장.
		2. Board 객체를 db에 저장. BoardDao 클래스 생성하여 insert 메서드 추가.
		3. list.jsp로 페이지 이동.
			-> 게시판 등록 성공 -> list.jsp
			-> 게시판 등록 실패 -> writeForm.jsp
 --%>

<!DOCTYPE html>
<html>

<meta charset="EUC-KR">
<%
 	Board board = new Board();
	String path = application.getRealPath("/")+"model1/board/file/";
	MultipartRequest multi = new MultipartRequest(request,path, 10*1024*1024, "euc-kr");
//	board.setNum(Integer.parseInt(multi.getParameter("num")));
//	board.setRefstep(Integer.parseInt(multi.getParameter("readcnt")));
//	board.setRef(Integer.parseInt(multi.getParameter("ref")));
//	board.setReflevel(Integer.parseInt(multi.getParameter("reflevel")));
//	board.setRefstep(Integer.parseInt(multi.getParameter("refstep")));
	board.setName(multi.getParameter("name"));
	board.setPass(multi.getParameter("pass"));
	board.setTitle(multi.getParameter("title"));
	board.setContent(multi.getParameter("content"));
	board.setFile1(multi.getFilesystemName("file1")); //다르게 들어가야한다.
//	SimpleDateFormat sf  = new SimpleDateFormat("yyyyMMdd");
//	Date date = sf.parse(multi.getParameter("regdate"));
//	board.setRegdate(date);
	BoardDao dao = new BoardDao();
	int num = dao.maxNum();  //등록된 num의 최대값
	board.setNum(++num); 
	board.setRef(num);
	// setRef와 setNum은 같은 값이다.
	String msg ="등록실패";
	String url = "writeForm.jsp";
	if(dao.insert(board)){
		msg = "등록성공";
		url ="list.jsp ";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>