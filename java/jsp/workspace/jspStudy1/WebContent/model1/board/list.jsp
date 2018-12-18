<%@page import="model.Board"%>
<%@page import="java.util.List"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <% request.setCharacterEncoding("euc-kr"); %>
 <%-- 
 	WebContent/model1/board.list.jsp
 	1.pageNum �Ķ���� ����. pageNum �Ķ���Ͱ� ������ 1�� ����.               pageNum-> ������ �з�
 	2.������ ���� 10�Ǿ� ����ϴ� �˰���.
 		-> db���� �ش� �������� ��µǴ� �Խù��� ��ȸ. ���� ����.
 	3.�Խù��� ȭ�鿡 ���.
  --%>
  <%
  	int pageNum=1;
  	try{
  		//pageNum �Ķ���Ͱ� ���� ���� 1�� ����.
		pageNum=Integer.parseInt(request.getParameter("pageNum")); 
	  }catch(NumberFormatException e){}
 /* ------------------------------------------------------------------------ */
  	int limit = 10; // �ѹ��� �������� �Խù� �Ǽ�.
  	BoardDao dao = new BoardDao();
  	int boardcount = dao.boardCount(); //��ϵ� �Խù��� ��ü �Ǽ�. dao.boardCount()�� ���ϰ��� boardcount�� �ް� ��.
  	List<Board> list = dao.list(pageNum,limit);  //list : ���� �������� �������� �Խù� ��ü ����.
  	
  /* -----------------------------������ �κ�-------------------------------- */
  /*
		��ü ������ ������(maxpage)
		
		boardcount : 11
		
		maxpage : 11.0/10 => 1.1 + 0.95 => 2.05  (int) 2.05 --> 2 ������
		
		boardcount : 10
				
		maxpage : 10.0/10 => 1.0 + 0.95 => 1.95  (int) 1.95 --> 1 ������
		
		boardcount : 505
				
		maxpage : 505.0/10 => 50.5 + 0.95 => 51.45  (int) 51.45 --> 51 ������		
		
		ȭ�鿡 ���۵� ������(startpage)
		
		pageNum : 2
		
		startpage : 2/10.0 +0.9 -> 1.1 -1 => 0.1 --(int)--> 0 => 0*10 +1 => 1������.
		
		pageNum : 10
				
		startpage : 10/10.0 +0.9 -> 1.9 -1 => 0.9 --(int)--> 0 => 0*10 +1 => 1������.

		pageNum : 11
				
		startpage : 11/10.0 +0.9 -> 2.0 -1 => 1.0 --(int)--> 1 => 1*10 +1 => 11������.
		
		ȭ�鿡 ǥ�õ� ������ ������(endpage)
		
		startpage : 11
		
		endpage : 20

  */
  	int maxpage = (int) ((double)boardcount/limit + 0.95);
  	int startpage = ((int)(pageNum/10.0 + 0.9)-1)*10 + 1;
  	int endpage = startpage +9;
  	if(endpage > maxpage) endpage = maxpage;
  	
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��1 �Խù� ��� ����</title>

</head>
<body>
<form action="searchList.jsp" method="post" name="f">
<table border="1" style="border-collapse: collapse;">
	<caption>��1 �Խ��� ���</caption>
	<% if(boardcount==0) { //��ϵ� �Խñ��� ���� ���%>
	<tr><td colspan="5" align="center">��ϵ� �Խñ��� �����ϴ�.</td></tr>
	<% }else{ //��ϵ� �Խñ��� �ִ� ���%>
	<tr><td colspan="5" align="right">�۰���:<%=boardcount %></td></tr>
	<tr align="center" valign="middle">
	<th width="8%">��ȣ</th>
	<th width="50%">����</th>
	<th width="14%">�ۼ���</th>
	<th width="17%">��¥</th>
	<th width="11%">��ȸ��</th>
	</tr>
		<% 
			int boardnum = (boardcount-((pageNum-1)*limit));
		%>
	<% for(Board b : list) {%>
		<%-- �亯 ���� ������� �ֱ� �Խù����� ���ʴ�� ���.
				 boardnum = 1page : boardcount
				 						2page : boardcount - limit(10)
				 						3page : boardcount - 2*limit(10)
				 						boardcount-((pageNum-1)*limit) : ���� board ��ȣ
		 --%>
	<tr align="center" valign="middle">

	<td><%=boardnum-- %></td>
	<%-- ÷�������� �ִ� ��� @ �ٿ��� ��� --%>
	<%-- ����� ���  ������ �鿩���� --%>
	<td align="left">
	<% if(b.getFile1()!=null && !b.getFile1().equals("")){
		if(b.getReflevel()>0){
		%>
	<% for(int i=1;i<b.getReflevel();i++) {%>	
			&nbsp;&nbsp;&nbsp;
		<%} %>
	��<a href="file/<%=b.getFile1()%>">@</a>&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%} else { %>
   <a href="file/<%=b.getFile1()%>">@</a>&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%} }else{ 	
		if(b.getReflevel()>0){
		%>	
	<% for(int i=1;i<=b.getReflevel();i++) {%>	
				&nbsp;&nbsp;&nbsp;
		<%} %>
	��&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%} else { %>
   &nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%}  } %>
	</td>
	<td><%=b.getName() %></td>
	<td><%=b.getRegdate() %></td>
	<td><%=b.getReadcnt() %></td>
	</tr>
	<% } %>
	<%-- ������ �κ� ��� --%>
	<tr align="center">
	<td colspan="5">
	<%-- pageNum �Ķ���� ���� �κ� --%>
	<%if(pageNum<=1) { %> [����] <%} else { %> <a href="list.jsp?pageNum=<%=pageNum-1 %>">[����]</a><%} %>
	<% for(int a=startpage;a<=endpage;a++){
			if(a == pageNum) {%>[<%=a %>]<%} else { %><a href="list.jsp?pageNum=<%=a %>">[<%=a %>]</a>
			<% } } %>
	<%if(pageNum >= maxpage) { %>[����]&nbsp;<%} else { %><a href="list.jsp?pageNum=<%=pageNum+1 %>">[����]</a><%} %></td>
	</tr>
<%} %>
	<tr><td colspan="3" align="center">
	<input type="text" name="search"></td>
	<td align="center"><input type="radio" name="sel" value="1">����<input type="radio" name="sel" value="2">�ۼ���</td>
	<td align="center"><input type="submit" value="�˻�"></td></tr>
	<tr><td colspan="5" align="right"><a href="writeForm.jsp">�۾���</a></td></tr>
</table>
</form>
</body>
</html>