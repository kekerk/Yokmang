<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html><%-- info.jsp에 비밀번호변경 넣기. --%>
<style>
	table {
		margin: 0 auto;
		width : 400px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style>
<%
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	String login = (String) session.getAttribute("login");
	String msg=null;
	String url=null;
	if(login == null){
		msg="로그인 하세요";
		url ="loginform.jsp";
	}else if(!login.equals(id) && !login.equals("admin")){
		msg="자기 비밀번호만 수정이 가능합니다";
		url="main.jsp";
	}
%>
<head>
<meta charset="EUC-KR">
<title>비밀번호 재설정</title>
</head>
<body>
	<form action="repass.jsp" name="f" method="post">
	<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
	<table border="1" style="border-collapse : collapse;">
		<caption>비밀번호 수정</caption>
		<tr>
			<td>현재 비밀번호</td>
			<td><input type="password" name="pass1"></td>
		</tr>
		<tr>
			<td>수정할 비밀번호</td>
			<td><input type="password" name="pass2"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="비밀번호 변경">
			</td>
		</tr>	
	</table>
	</form>

</body>
</html>