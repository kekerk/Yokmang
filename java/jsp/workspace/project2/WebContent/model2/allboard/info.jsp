<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Info</title>
<style type="text/css">
caption {
	font :bold;
	font-size: x-large;
}
</style>
</head>
<body>
<c:if test="${param.boardtype == 1}"><%-- 명장면 및 후기 게시판 info --%>
<form action="reply.all" method="post">
<input type="hidden" name="no" value="${allboard.no}">
<input type="hidden" name="boardtype" value="${param.boardtype}">
<div style="margin: 50px; padding: 25></form>px;" align="center">
<table border="1" style="border-collapse : collapse;" class="w3-table-all w3-centered">
	<caption>게시물 상세 보기</caption>
	<tr><td colspan="4">글쓴이 : ${allboard.nickname}</td></tr>
	<tr><td colspan="4">제목 : [${allboard.seriesname}] ${allboard.title}</td></tr>
	<tr>
	<td style="width:40%"colspan="2"><img src="file/${allboard.file1}" style="width:100%;"></td>
	<td style="width:60%"colspan="2">${allboard.content}</td>
	</tr>
	<tr><td colspan="4" align="center">
	<c:if test="${sessionScope.login == allboard.id}">
	<a href="updateForm.all?no=${allboard.no}&boardtype=${allboard.boardtype}"  style="text-decoration:none;" class="w3-button w3-black">edit</a> 
	<a href="deleteform.all?no=${allboard.no}&boardtype=${allboard.boardtype}"  style="text-decoration:none;" class="w3-button w3-black">delete</a> 
	</c:if>
	<c:if test="${sessionScope.login=='admin'}">
	<a href="deleteadmin.all?no=${allboard.no}&boardtype=${allboard.boardtype}" style="text-decoration:none;" class="w3-button w3-black">delete(admin)</a>
	</c:if>
	<a href="list.all?boardtype=${param.boardtype}" style="text-decoration:none;" class="w3-button w3-black">list</a>
	</td>
	</tr> 
	<%-- 댓글 부분 --%>
	<tr>
	<td colspan="4"><textarea cols="80" rows="5" name="content" placeholder="댓글을 적어주세요"></textarea></td></tr>
	<tr><td colspan="4"><button class="w3-button w3-black">reply</button></td></tr>
	<c:if test="${boardcount==0 }">
	<tr><td colspan="4">댓글이 없습니다.</td></tr>
	</c:if>
		<c:if test="${boardcount!=0 }">
	<c:forEach var="comments" items="${commentslist}">
	<tr>
<td style="width:25%">${comments.dormi} ${comments.grade}학년<br>${comments.nickname}</td>
	<td colspan="2" style="width:70%">${comments.content}</td>
	<td style="width:5%">
	<c:if test="${sessionScope.login == comments.id}">
	<a href="commentdelete.all?ref_no=${comments.ref_no}&no=${allboard.no}&boardtype=${param.boardtype}" class="w3-button w3-black">delete</a>
	</c:if>
	<c:if test="${sessionScope.login != comments.id}">
	<a href="#" class="w3-button w3-gray">not mine</a>
	</c:if>
	</td>
	</tr>
</c:forEach>	
	<%-- 페이지 부분 출력 --%>
	<tr align="center">
	<td colspan="4">
	<%-- pageNum 파라미터 전달 부분 --%>
	<c:if test="${pageNum<=1 }">Previous</c:if>
	<c:if test="${pageNum >1 }"><a href="info.all?pageNum=${pageNum-1}&boardtype=${boardtype}&no=${param.no}" style="text-decoration:none;">Previous</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}">${a}</c:if>
		<c:if test="${a!=pageNum }"><a href="info.all?pageNum=${a}&boardtype=${boardtype}&no=${param.no}" style="text-decoration:none;">${a}</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }">Next</c:if>
	<c:if test="${pageNum < maxpage }"><a href="info.all?pageNum=${pageNum+1}&boardtype=${boardtype}&no=${param.no}" style="text-decoration:none;">Next</a></c:if>
	</td>
	</tr>
	</c:if>
</table>
</div>
</form>
</c:if>
<%-- ---------------------------------------------------------------------------------------- --%>
<c:if test="${param.boardtype == 2}"><%-- 갤러리 게시판 info --%>
<form action="reply.all" method="post">
<input type="hidden" name="no" value="${allboard.no}">
<input type="hidden" name="boardtype" value="${param.boardtype}">
<div style="margin: 50px; padding: 25px; vertical-align: middle;" align="center">
<table border="1" style="border-collapse : collapse;" class="w3-table-all w3-centered">
	<caption>게시물 상세 보기</caption>
	<tr><td colspan="4">글쓴이 : ${allboard.nickname}</td></tr>
	<tr><td colspan="4">제목 : ${allboard.title}</td></tr>
	<tr>
	<td style="width:40%;"colspan="2"><img src="file/${allboard.file1}" style="width:100%; margin-top : 10px;"></td>
	<td style="width:60%;"colspan="2">${allboard.content}</td>
	</tr>
	<tr><td colspan="4" align="center">
	<c:if test="${sessionScope.login == allboard.id}">
	<a href="updateForm.all?no=${allboard.no}&boardtype=${allboard.boardtype}"  style="text-decoration:none;" class="w3-button w3-black">edit</a> 
	<a href="deleteform.all?no=${allboard.no}&boardtype=${allboard.boardtype}"  style="text-decoration:none;" class="w3-button w3-black">delete</a> 
	</c:if>
	<c:if test="${sessionScope.login=='admin'}">
	<a href="deleteadmin.all?no=${allboard.no}&boardtype=${allboard.boardtype}" style="text-decoration:none;" class="w3-button w3-black">delete(admin)</a>
	</c:if>
	<a href="list.all?boardtype=${param.boardtype}" style="text-decoration:none;" class="w3-button w3-black">list</a>
	</td>
	</tr> 
		<%-- 댓글 부분 --%>
	<tr>
	<td colspan="4"><textarea cols="80" rows="5" name="content" placeholder="댓글을 적어주세요"></textarea></td></tr>
	<tr><td colspan="4"><button class="w3-button w3-black">reply</button></td></tr>
	<c:if test="${boardcount==0 }">
	<tr><td colspan="4">댓글이 없습니다.</td></tr>
	</c:if>
		<c:if test="${boardcount!=0 }">
	<c:forEach var="comments" items="${commentslist}">
	<tr>
<td style="width:25%">${comments.dormi} ${comments.grade}학년<br>${comments.nickname}</td>
	<td colspan="2" style="width:70%">${comments.content}</td>
	<td style="width:5%">
	<c:if test="${sessionScope.login == comments.id}">
	<a href="commentdelete.all?ref_no=${comments.ref_no}&no=${allboard.no}&boardtype=${param.boardtype}" class="w3-button w3-black">delete</a>
	</c:if>
	<c:if test="${sessionScope.login != comments.id}">
	<a href="#" class="w3-button w3-gray">not mine</a>
	</c:if>
	</td>
	</tr>
</c:forEach>	
	<%-- 페이지 부분 출력 --%>
	<tr align="center">
	<td colspan="4">
	<%-- pageNum 파라미터 전달 부분 --%>
	<c:if test="${pageNum<=1 }">Previous</c:if>
	<c:if test="${pageNum >1 }"><a href="info.all?pageNum=${pageNum-1}&boardtype=${boardtype}&no=${param.no}" style="text-decoration:none;">Previous</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}">${a}</c:if>
		<c:if test="${a!=pageNum }"><a href="info.all?pageNum=${a}&boardtype=${boardtype}&no=${param.no}" style="text-decoration:none;">${a}</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }">Next</c:if>
	<c:if test="${pageNum < maxpage }"><a href="info.all?pageNum=${pageNum+1}&boardtype=${boardtype}&no=${param.no}" style="text-decoration:none;">Next</a></c:if>
	</td>
	</tr>
	</c:if>
</table>
</div>
</form>
</c:if>
<c:if test="${param.boardtype == 3}"><%-- 기숙사별 게시판 info --%>
<div style="margin: 50px; padding: 25px;" align="center">
<form action="reply.all" method="post">
<input type="hidden" name="no" value="${allboard.no}">
<input type="hidden" name="boardtype" value="${param.boardtype}">
<input type="hidden" name="dormi" value="${dormi}">
<table border="1" style="border-collapse : collapse;" class="w3-table-all w3-centered">
	<caption>게시물 상세 보기</caption>
	<tr><td colspan="4">글쓴이 : ${allboard.nickname}</td></tr>
	<tr><td colspan="4">제목 : ${allboard.title}</td></tr>
	<tr>
	<td colspan="4">${allboard.content}</td>
	</tr>
	<tr><td colspan="4">첨부파일 :
	
	<c:if test="${!empty allboard.file1}">
	<a href="file/${allboard.file1}">${allboard.file1}</a>
	</c:if>
	<c:if test="${empty allboard.file1 }">
	[파일 없음]
	</c:if>
	</td>
	</tr>
	<tr><td colspan="4" align="center">
	<c:if test="${sessionScope.login==allboard.id}">
	<a href="updateForm.all?no=${allboard.no}&boardtype=${allboard.boardtype}&dormi=${param.dormi}" style="text-decoration:none;" class="w3-button w3-black">edit</a> 
	<a href="deleteform.all?no=${allboard.no}&boardtype=${allboard.boardtype}&dormi=${param.dormi}" style="text-decoration:none;" class="w3-button w3-black">delete</a> 
	</c:if>
	<c:if test="${sessionScope.login=='admin'}">
	<a href="deleteadmin.all?no=${allboard.no}&boardtype=${allboard.boardtype}&dormi=${param.dormi}" style="text-decoration:none;" class="w3-button w3-black">delete[admin]</a>
	</c:if>
	<a href="list.all?boardtype=${param.boardtype}&dormi=${param.dormi}" style="text-decoration:none;" class="w3-button w3-black">list</a>
	</td>
	</tr> 
	<%-- 댓글 부분 --%>
	<tr>
	<td colspan="4"><textarea cols="80" rows="5" name="content" placeholder="댓글을 적어주세요"></textarea></td></tr>
	<tr><td colspan="4"><button class="w3-button w3-black">reply</button></td></tr>
	<c:if test="${boardcount==0 }">
	<tr><td colspan="4">댓글이 없습니다.</td></tr>
	</c:if>
		<c:if test="${boardcount!=0 }">
	<c:forEach var="comments" items="${commentslist}">
	<tr>
	<td style="width:25%">${comments.dormi} ${comments.grade}학년<br>${comments.nickname}</td>
	<td colspan="2" style="width:70%">${comments.content}</td>
	<td style="width:5%">
	<c:if test="${sessionScope.login == comments.id}">
	<a href="commentdelete.all?ref_no=${comments.ref_no}&no=${allboard.no}&boardtype=${param.boardtype}&dormi=${param.dormi}" class="w3-button w3-black">delete</a>
	</c:if>
	<c:if test="${sessionScope.login != comments.id}">
	<a href="#" class="w3-button w3-gray">not mine</a>
	</c:if>
	</td>
	</tr>
</c:forEach>	
	<%-- 페이지 부분 출력 --%>
	<tr align="center">
	<td colspan="4">
	<%-- pageNum 파라미터 전달 부분 --%>
	<c:if test="${pageNum<=1 }">Previous</c:if>
	<c:if test="${pageNum >1 }"><a href="info.all?pageNum=${pageNum-1}&boardtype=${boardtype}&no=${param.no}&dormi=${param.dormi}" style="text-decoration:none;">Previous</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}">${a}</c:if>
		<c:if test="${a!=pageNum }"><a href="info.all?pageNum=${a}&boardtype=${boardtype}&no=${param.no}&dormi=${param.dormi}" style="text-decoration:none;">${a}</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }">Next</c:if>
	<c:if test="${pageNum < maxpage }"><a href="info.all?pageNum=${pageNum+1}&boardtype=${boardtype}&no=${param.no}&dormi=${param.dormi}" style="text-decoration:none;">Next</a></c:if>
	</td>
	</tr>
	</c:if>	
</table>
</form>
</div>
</c:if>
<c:if test="${param.boardtype == 4}"><%-- 자유게시판 info --%>

<div style="margin: 50px; padding: 25px;" align="center">
<form action="reply.all" method="post">
<input type="hidden" name="no" value="${allboard.no}">
<input type="hidden" name="boardtype" value="${param.boardtype}">
<table border="1" style="border-collapse : collapse;" class="w3-table-all w3-centered">
	<caption>게시물 상세 보기</caption>
	<tr><td colspan="4">글쓴이 : ${allboard.nickname}</td></tr>
	<tr><td colspan="4">제목 : ${allboard.title}</td></tr>
	<tr>
	<td colspan="4">${allboard.content}</td>
	</tr>
		<tr><td colspan="2">첨부파일</td>
	<td colspan="2">
	<c:if test="${!empty allboard.file1}">
	<a href="file/${allboard.file1}">${allboard.file1}</a>
	</c:if>
	<c:if test="${empty allboard.file1 }">
	[파일 없음]
	</c:if>
	</td>
	</tr>
	<tr><td colspan="4" align="center">
	<c:if test="${sessionScope.login == allboard.id}">
	<a href="updateForm.all?no=${allboard.no}&boardtype=${allboard.boardtype}"  style="text-decoration:none;" class="w3-button w3-black">edit</a> 
	<a href="deleteform.all?no=${allboard.no}&boardtype=${allboard.boardtype}"  style="text-decoration:none;" class="w3-button w3-black">delete</a> 
	</c:if>
	<c:if test="${sessionScope.login=='admin'}">
	<a href="deleteadmin.all?no=${allboard.no}&boardtype=${allboard.boardtype}" style="text-decoration:none;" class="w3-button w3-black">delete(admin)</a>
	</c:if>
	<a href="list.all?boardtype=${param.boardtype}" style="text-decoration:none;" class="w3-button w3-black">list</a>
	</td>
	</tr> 
<%-- 댓글 부분 --%>
	<tr>
	<td colspan="4"><textarea cols="80" rows="5" name="content" placeholder="댓글을 적어주세요"></textarea></td></tr>
	<tr><td colspan="4"><button class="w3-button w3-black">reply</button></td></tr>
	<c:if test="${boardcount==0 }">
	<tr><td colspan="4">댓글이 없습니다.</td></tr>
	</c:if>
		<c:if test="${boardcount!=0 }">
	<c:forEach var="comments" items="${commentslist}">
	<tr>
	<td style="width:25%">${comments.dormi} ${comments.grade}학년<br>${comments.nickname}</td>
	<td colspan="2" style="width:70%">${comments.content}</td>
	<td style="width:5%"><a href="commentdelete.all?ref_no=${comments.ref_no}&no=${allboard.no}&boardtype=${param.boardtype}" class="w3-button w3-black">delete</a></td>
	</tr>
</c:forEach>	
	<%-- 페이지 부분 출력 --%>
	<tr align="center">
	<td colspan="4">
	<%-- pageNum 파라미터 전달 부분 --%>
	<c:if test="${pageNum<=1 }">Previous</c:if>
	<c:if test="${pageNum >1 }"><a href="info.all?pageNum=${pageNum-1}&boardtype=${boardtype}&no=${param.no}" style="text-decoration:none;">Previous</a></c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}" >
		<c:if test="${a==pageNum}">${a}</c:if>
		<c:if test="${a!=pageNum }"><a href="info.all?pageNum=${a}&boardtype=${boardtype}&no=${param.no}" style="text-decoration:none;">${a}</a></c:if>
	</c:forEach>
	<c:if test="${pageNum >= maxpage }">Next</c:if>
	<c:if test="${pageNum < maxpage }"><a href="info.all?pageNum=${pageNum+1}&boardtype=${boardtype}&no=${param.no}" style="text-decoration:none;">Next</a></c:if>
	</td>
	</tr>
	</c:if>
</table>
</form>
</div>
</c:if>
<c:if test="${param.boardtype == 5}"><%-- 방명록 info --%>
<div style="margin: 50px; padding: 25px;" align="center">
<form action="reply.all" method="post">
<input type="hidden" name="no" value="${allboard.no}">
<input type="hidden" name="boardtype" value="${param.boardtype}">
<table border="1" style="border-collapse : collapse;" class="w3-table-all w3-centered">
	<caption>게시물 상세 보기</caption>
	<tr><td colspan="2">글쓴이 : ${allboard.nickname}</td></tr>
	<tr><td colspan="2">제목 : ${allboard.title}</td></tr>
	<tr>
	<td>${allboard.content}</td>
	</tr>
	<tr><td colspan="2" align="center">
	<c:if test="${sessionScope.login==allboard.id}">
	<a href="updateForm.all?no=${allboard.no}&boardtype=${allboard.boardtype}" style="text-decoration:none;">[수정]</a> 
	<a href="deleteform.all?no=${allboard.no}&boardtype=${allboard.boardtype}" style="text-decoration:none;">[삭제]</a> 
	</c:if>
	<c:if test="${sessionScope.login=='admin'}">
	<a href="deleteadmin.all?no=${allboard.no}&boardtype=${allboard.boardtype}" style="text-decoration:none;">[강제삭제]</a>
	</c:if>
	<a href="list.all?boardtype=${param.boardtype}" style="text-decoration:none;">[목록]</a>
	</td>
	</tr> 
</table>
</form>
</div>
</c:if>
</body>
</html>