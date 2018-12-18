<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	AdminUserAction 추상 클래스
	1. 로그아웃 상태
		-> 로그인하세요 메세지 출력. loginForm.jsp 이동
	2. admin이 아닌 경우
		-> 관리자만 조회 가능합니다. 메세지 출력. main.jsp
	ListAction 클래스
	3.admin인 경우
		-> MemberDao 클래스에 list 메서드 추가하기.
		List<Member> list() 기능
--%>
<!DOCTYPE html>
 <html>
 <head>
<meta charset="EUC-KR">
<title>model2 회원목록보기</title>

 <style>
caption {
	font-weight: bold;
	font-size: large;
	}
</style> 
</head>
<body>
<div style="border:1px solid silver;">
<table border="1" style="border-collapse: collapse;" class="w3-table-all w3-hoverable">
	<caption>모델2 회원 목록 조회</caption>
	<tr><th>사진</th><th>아이디</th><th>이름</th><th>성별</th><th>전화</th><th>이메일</th><th>&nbsp;</th></tr>
<c:forEach var="list" items="${list}" > <%-- 순서대로 저장된 record를 출력 --%>
<tr class="w3-hover-green">
	<td><img src="img/sm_${list.picture}" width="50" height="50"></td> <%-- 작은 이미지 파일을 저장 : 썸네일 이미지 --%>
	<td><a href="info.me?id=${list.id} ">${list.id }</a></td>	
	<td>${list.name }</td>	
	<td>${list.gender==1?'남자':'여자'}</td>	
	<td>${list.tel}</td>	
	<td>${list.email}</td>	
	<td>
		<a href="updateform.me?id=${list.id}">[수정]</a>	
		<a href="delete.me?id=${list.id}">[강제탈퇴]</a>
	</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>
