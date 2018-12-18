<%@page import="model.Board"%>
<%@page import="java.util.List"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <% request.setCharacterEncoding("euc-kr"); %>
 <%-- 
 	WebContent/model1/board.list.jsp
 	1.pageNum 파라미터 존재. pageNum 파라미터가 없으면 1로 설정.               pageNum-> 페이지 분류
 	2.페이지 별로 10건씩 출력하는 알고리즘.
 		-> db에서 해당 페이지의 출력되는 게시물을 조회. 순서 지정.
 	3.게시물을 화면에 출력.
  --%>
  <%
  	int pageNum=1;
  	try{
  		//pageNum 파라미터가 없는 경우는 1로 설정.
		pageNum=Integer.parseInt(request.getParameter("pageNum")); 
	  }catch(NumberFormatException e){}
 /* ------------------------------------------------------------------------ */
  	int limit = 10; // 한번에 보여지는 게시물 건수.
  	BoardDao dao = new BoardDao();
  	int boardcount = dao.boardCount(); //등록된 게시물의 전체 건수. dao.boardCount()의 리턴값을 boardcount가 받게 됨.
  	List<Board> list = dao.list(pageNum,limit);  //list : 현재 페이지에 보여지는 게시물 객체 저장.
  	
  /* -----------------------------페이지 부분-------------------------------- */
  /*
		전체 보여질 페이지(maxpage)
		
		boardcount : 11
		
		maxpage : 11.0/10 => 1.1 + 0.95 => 2.05  (int) 2.05 --> 2 페이지
		
		boardcount : 10
				
		maxpage : 10.0/10 => 1.0 + 0.95 => 1.95  (int) 1.95 --> 1 페이지
		
		boardcount : 505
				
		maxpage : 505.0/10 => 50.5 + 0.95 => 51.45  (int) 51.45 --> 51 페이지		
		
		화면에 시작될 페이지(startpage)
		
		pageNum : 2
		
		startpage : 2/10.0 +0.9 -> 1.1 -1 => 0.1 --(int)--> 0 => 0*10 +1 => 1페이지.
		
		pageNum : 10
				
		startpage : 10/10.0 +0.9 -> 1.9 -1 => 0.9 --(int)--> 0 => 0*10 +1 => 1페이지.

		pageNum : 11
				
		startpage : 11/10.0 +0.9 -> 2.0 -1 => 1.0 --(int)--> 1 => 1*10 +1 => 11페이지.
		
		화면에 표시될 마지막 페이지(endpage)
		
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
<title>모델1 게시물 목록 보기</title>

</head>
<body>
<form action="searchList.jsp" method="post" name="f">
<table border="1" style="border-collapse: collapse;">
	<caption>모델1 게시판 등록</caption>
	<% if(boardcount==0) { //등록된 게시글이 없는 경우%>
	<tr><td colspan="5" align="center">등록된 게시글이 없습니다.</td></tr>
	<% }else{ //등록된 게시글이 있는 경우%>
	<tr><td colspan="5" align="right">글개수:<%=boardcount %></td></tr>
	<tr align="center" valign="middle">
	<th width="8%">번호</th>
	<th width="50%">제목</th>
	<th width="14%">작성자</th>
	<th width="17%">날짜</th>
	<th width="11%">조회수</th>
	</tr>
		<% 
			int boardnum = (boardcount-((pageNum-1)*limit));
		%>
	<% for(Board b : list) {%>
		<%-- 답변 순서 상관없이 최근 게시물까지 차례대로 출력.
				 boardnum = 1page : boardcount
				 						2page : boardcount - limit(10)
				 						3page : boardcount - 2*limit(10)
				 						boardcount-((pageNum-1)*limit) : 시작 board 번호
		 --%>
	<tr align="center" valign="middle">

	<td><%=boardnum-- %></td>
	<%-- 첨부파일이 있는 경우 @ 붙여서 출력 --%>
	<%-- 답글인 경우  안으로 들여쓰기 --%>
	<td align="left">
	<% if(b.getFile1()!=null && !b.getFile1().equals("")){
		if(b.getReflevel()>0){
		%>
	<% for(int i=1;i<b.getReflevel();i++) {%>	
			&nbsp;&nbsp;&nbsp;
		<%} %>
	└<a href="file/<%=b.getFile1()%>">@</a>&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%} else { %>
   <a href="file/<%=b.getFile1()%>">@</a>&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%} }else{ 	
		if(b.getReflevel()>0){
		%>	
	<% for(int i=1;i<=b.getReflevel();i++) {%>	
				&nbsp;&nbsp;&nbsp;
		<%} %>
	└&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%} else { %>
   &nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%}  } %>
	</td>
	<td><%=b.getName() %></td>
	<td><%=b.getRegdate() %></td>
	<td><%=b.getReadcnt() %></td>
	</tr>
	<% } %>
	<%-- 페이지 부분 출력 --%>
	<tr align="center">
	<td colspan="5">
	<%-- pageNum 파라미터 전달 부분 --%>
	<%if(pageNum<=1) { %> [이전] <%} else { %> <a href="list.jsp?pageNum=<%=pageNum-1 %>">[이전]</a><%} %>
	<% for(int a=startpage;a<=endpage;a++){
			if(a == pageNum) {%>[<%=a %>]<%} else { %><a href="list.jsp?pageNum=<%=a %>">[<%=a %>]</a>
			<% } } %>
	<%if(pageNum >= maxpage) { %>[다음]&nbsp;<%} else { %><a href="list.jsp?pageNum=<%=pageNum+1 %>">[다음]</a><%} %></td>
	</tr>
<%} %>
	<tr><td colspan="3" align="center">
	<input type="text" name="search"></td>
	<td align="center"><input type="radio" name="sel" value="1">제목<input type="radio" name="sel" value="2">작성자</td>
	<td align="center"><input type="submit" value="검색"></td></tr>
	<tr><td colspan="5" align="right"><a href="writeForm.jsp">글쓰기</a></td></tr>
</table>
</form>
</body>
</html>