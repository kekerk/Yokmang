<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%--
		/WebContent/model1/board/delete.jsp
		1. num�� pass �Ķ���� 2�� ���� ����.
		2. �Էµ� ��й�ȣ�� db�� ����� ��й�ȣ ���ϱ�.
			- �´� ��� : �Խù� ����. BoardDao.delete(num)
					���� ���� : ���� ���� �޼��� ���. list.jsp�� ������ �̵�.
					���� ���� : ���� ���� �޼��� ���. info.jsp�� ������ �̵�.
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
		msg = "��й�ȣ ����";
		url = "deleteform.jsp?num="+board.getNum();
	}else {
		if(dao.delete(board)){
			msg ="�Խù��� �����Ǿ����ϴ�.";
			url = "list.jsp";
		}else {
			msg = "�Խù� ���� ����";
			url="info.jsp?num="+board.getNum();
		}
	}
%>
<script type="text/javascript">
alert("<%=msg%>");
location.href = "<%=url%>";
</script>