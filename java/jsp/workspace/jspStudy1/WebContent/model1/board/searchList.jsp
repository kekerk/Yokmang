<%@page import="java.util.List"%>
<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��1 �Խù� ��� ����</title>
</head>
<%
  	int pageNum=1;
  	try{
  		//pageNum �Ķ���Ͱ� ���� ���� 1�� ����.
		pageNum=Integer.parseInt(request.getParameter("pageNum")); 
	  }catch(NumberFormatException e){}
 /* ------------------------------------------------------------------------ */
  	int limit = 10; // �ѹ��� �������� �Խù� �Ǽ�.
  	String search = null;
	String searchfor = request.getParameter("search");
	if(request.getParameter("sel").equals("1")){
		search = "title";
	}else{
		search = "name";
	}
  	BoardDao dao = new BoardDao();
  	int searchboardcount = dao.boardCountsearch(search,searchfor); //��ϵ� �Խù��� ��ü �Ǽ�. dao.boardCount()�� ���ϰ��� boardcount�� �ް� ��.
  	List<Board> list = dao.list2(pageNum,limit,search,searchfor);  //list : ���� �������� �������� �Խù� ��ü ����.
  	int maxpage = (int) ((double)searchboardcount/limit + 0.95);
  	int startpage = ((int)(pageNum/10.0 + 0.9)-1)*10 + 1;
  	int endpage = startpage +9;
  	if(endpage > maxpage) endpage = maxpage;
  %>

<body>
<table border="1" style="border-collapse: collapse;">
	<caption>��1 ���� �Խù� �˻�</caption>
	<% if(searchboardcount==0) { //��ϵ� �Խñ��� ���� ���%>
	<tr><td colspan="5" align="center">��ϵ� �Խñ��� �����ϴ�.</td></tr>
	<% }else{ //��ϵ� �Խñ��� �ִ� ���%>
	<tr><td colspan="5" align="right">�۰���:<%=searchboardcount %></td></tr>
	<tr align="center" valign="middle">
	<th width="8%">��ȣ</th>
	<th width="50%">����</th>
	<th width="14%">�ۼ���</th>
	<th width="17%">��¥</th>
	<th width="11%">��ȸ��</th>
	</tr>
		<% 
			int boardnum = (searchboardcount-((pageNum-1)*limit));
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
	��@&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%} else { %>
   @&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
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
	<%if(pageNum<=1) { %> [����] <%} else { %> <a href="searchList.jsp?pageNum=<%=pageNum-1 %>">[����]</a><%} %>
	<% for(int a=startpage;a<=endpage;a++){
			if(a == pageNum) {%>[<%=a %>]<%} else { %><a href="searchList.jsp?pageNum=<%=a %>">[<%=a %>]</a>
			<% } } %>
	<%if(pageNum >= maxpage) { %>[����]&nbsp;<%} else { %><a href="searchList.jsp?pageNum=<%=pageNum+1 %>">[����]</a><%} %></td>
	</tr>
<%} %>
	<tr><td colspan="5" align="right"><a href="writeForm.jsp">�۾���</a></td></tr>
	<tr><td colspan="5" align="right"><a href="javascript:location.href='list.jsp'">[��ü �Խù� ���]</a></td></tr>
</table>
</body>
</html>