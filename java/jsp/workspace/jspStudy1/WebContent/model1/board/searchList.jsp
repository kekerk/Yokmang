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
<title>모델1 게시물 목록 보기</title>
</head>
<%
  	int pageNum=1;
  	try{
  		//pageNum 파라미터가 없는 경우는 1로 설정.
		pageNum=Integer.parseInt(request.getParameter("pageNum")); 
	  }catch(NumberFormatException e){}
 /* ------------------------------------------------------------------------ */
  	int limit = 10; // 한번에 보여지는 게시물 건수.
  	String search = null;
	String searchfor = request.getParameter("search");
	if(request.getParameter("sel").equals("1")){
		search = "title";
	}else{
		search = "name";
	}
  	BoardDao dao = new BoardDao();
  	int searchboardcount = dao.boardCountsearch(search,searchfor); //등록된 게시물의 전체 건수. dao.boardCount()의 리턴값을 boardcount가 받게 됨.
  	List<Board> list = dao.list2(pageNum,limit,search,searchfor);  //list : 현재 페이지에 보여지는 게시물 객체 저장.
  	int maxpage = (int) ((double)searchboardcount/limit + 0.95);
  	int startpage = ((int)(pageNum/10.0 + 0.9)-1)*10 + 1;
  	int endpage = startpage +9;
  	if(endpage > maxpage) endpage = maxpage;
  %>

<body>
<table border="1" style="border-collapse: collapse;">
	<caption>모델1 조건 게시물 검색</caption>
	<% if(searchboardcount==0) { //등록된 게시글이 없는 경우%>
	<tr><td colspan="5" align="center">등록된 게시글이 없습니다.</td></tr>
	<% }else{ //등록된 게시글이 있는 경우%>
	<tr><td colspan="5" align="right">글개수:<%=searchboardcount %></td></tr>
	<tr align="center" valign="middle">
	<th width="8%">번호</th>
	<th width="50%">제목</th>
	<th width="14%">작성자</th>
	<th width="17%">날짜</th>
	<th width="11%">조회수</th>
	</tr>
		<% 
			int boardnum = (searchboardcount-((pageNum-1)*limit));
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
	└@&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
	<%} else { %>
   @&nbsp;<a href="info.jsp?num=<%=b.getNum()%>"><%=b.getTitle() %></a>
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
	<%if(pageNum<=1) { %> [이전] <%} else { %> <a href="searchList.jsp?pageNum=<%=pageNum-1 %>">[이전]</a><%} %>
	<% for(int a=startpage;a<=endpage;a++){
			if(a == pageNum) {%>[<%=a %>]<%} else { %><a href="searchList.jsp?pageNum=<%=a %>">[<%=a %>]</a>
			<% } } %>
	<%if(pageNum >= maxpage) { %>[다음]&nbsp;<%} else { %><a href="searchList.jsp?pageNum=<%=pageNum+1 %>">[다음]</a><%} %></td>
	</tr>
<%} %>
	<tr><td colspan="5" align="right"><a href="writeForm.jsp">글쓰기</a></td></tr>
	<tr><td colspan="5" align="right"><a href="javascript:location.href='list.jsp'">[전체 게시물 목록]</a></td></tr>
</table>
</body>
</html>