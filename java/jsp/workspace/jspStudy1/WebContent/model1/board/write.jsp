<%@page import="model.BoardDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Board"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/model1/board/write.jsp
		1. �Ķ���� ���� Board ��ü ����.
			 Board ��ü �����Ͽ� MultipartRequest�� �Ķ���͸� �ϳ��� ����.
		2. Board ��ü�� db�� ����. BoardDao Ŭ���� �����Ͽ� insert �޼��� �߰�.
		3. list.jsp�� ������ �̵�.
			-> �Խ��� ��� ���� -> list.jsp
			-> �Խ��� ��� ���� -> writeForm.jsp
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
	board.setFile1(multi.getFilesystemName("file1")); //�ٸ��� �����Ѵ�.
//	SimpleDateFormat sf  = new SimpleDateFormat("yyyyMMdd");
//	Date date = sf.parse(multi.getParameter("regdate"));
//	board.setRegdate(date);
	BoardDao dao = new BoardDao();
	int num = dao.maxNum();  //��ϵ� num�� �ִ밪
	board.setNum(++num); 
	board.setRef(num);
	// setRef�� setNum�� ���� ���̴�.
	String msg ="��Ͻ���";
	String url = "writeForm.jsp";
	if(dao.insert(board)){
		msg = "��ϼ���";
		url ="list.jsp ";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>