
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>게시물 수정</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
   function file_delete() {
	   document.f.file2.value="";
	   file_desc.innerHTML="";
   }
</script>
</head>
<body>
<form name = "f" action ="update.bo" method="post" enctype="multipart/form-data">
<input type="hidden" name="num" value="${b.num}">
<input type="hidden" name="code" value="${param.code }">
<input type ="hidden" name="file2" value="${b.file1}">
 <table border="1" style="border-collapse: collapse;" class="w3-table-all">
   <tr>
  <td colspan="7" rowspan="5" style="width:350px; height:550px;">
  <img src="img/${b.file1}" style="width:350px; height:550px;" name="file1" id="pic"></td></tr>
          <tr><td align = "center">제목</td>
     <td><input type="text" name="title" value = "${b.title}" readonly="readonly"></td></tr>
     <tr><td align = "center">비밀번호</td>
     <td><input type="password" name="pass" value="${b.pass}"></td></tr>
     <tr><td>내용</td>
     <td><textarea rows="15" cols="80" name="content">${b.content}</textarea></td></tr>

    <tr><td align = "center">첨부파일</td><td>
     <c:if test="${!empty b.file1}">
       <div id="file_desc">${b.file1 }
       <a href="javascript:file_delete()">[첨부파일삭제]</a></div>
     </c:if>
     <input type="file" name="file1">
     </td></tr>
     <tr><td colspan="15" align ="center">
     <a href="javascript:document.f.submit()">[게시물수정]</a></td></tr>
 </table>
</form>
</body>
</html>