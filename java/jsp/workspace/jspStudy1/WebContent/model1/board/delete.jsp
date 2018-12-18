<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%--
		/WebContent/model1/board/delete.jsp
		1. num과 pass 파라미터 2개 변수 저장.
		2. 입력된 비밀번호와 db의 저장된 비밀번호 비교하기.
			- 맞는 경우 : 게시물 삭제. BoardDao.delete(num)
					삭제 성공 : 삭제 성공 메세지 출력. list.jsp로 페이지 이동.
					삭제 실패 : 삭제 실패 메세지 출력. info.jsp로 페이지 이동.
 --%>
<html>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pass = request.getParameter("pass");
	String msg = null;
	String url = null;
	BoardDao dao = new BoardDao();
	Board board = dao.selectOne(num);
	if(!board.getPass().equals(pass)){
		msg = "비밀번호 오류";
		url = "deleteform.jsp?num="+board.getNum();
	}else {
		if(dao.delete(board)){
			msg ="게시물이 삭제되었습니다.";
			url = "list.jsp";
		}else {
			msg = "게시물 삭제 실패";
			url="info.jsp?num="+board.getNum();
		}
	}
%>
<script type="text/javascript">
alert("<%=msg%>");
location.href = "<%=url%>";
</script>