<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- /WebContent/model1/member/updateform.jsp
			 1. id 파라미터를 가져온다.
		  	2. 로그아웃 상태인 경우 : alert("로그인하세요"); , loginform.jsp 페이지로 이동.
			3.	로그인 상태인 경우 
				- id파라미터와 login값을 비교해서 다르면 alert("자기정보만 조회가 가능"); , main.jsp 페이지로 이동.
				- id파라미터와 login값을 비교해서 같으면 DB에서 해당 member 정보를 가져오기.
		    4. member 정보를 화면에 출력하기.
 --%>
<html>
<%
		String login = (String) session.getAttribute("login");
		String id  = request.getParameter("id");
		if(login==null){%>
		<script>
		alert("로그인하세요");
		location.href="loginform.jsp";
		</script> 
		<%} else {
			if(!login.equals(id) && !login.equals("admin")){ %>
		<script>
		alert("본인의 정보만 수정이 가능합니다.");
		location.href="main.jsp";
		</script> 
		<%	} else {
			MemberDao dao = new MemberDao();
			Member mem = dao.selectOne(id);  %>
<head>
<meta charset="EUC-KR">
<title>model1 회원 정보 수정</title>
</head><style>
	table {
		margin: 0 auto;
		width : 800px;
		border: 2px solid green;
		text-align: center;
	}
	caption {
	font-weight: bold;
	font-size: x-large;
	}
</style>
<script >
function win_open() {
	var op = "width=500, height=150, left=50, top=150";
	open("memberimgForm.jsp","",op);
	
}
function passchg_winopen() {
	var op = "width=500, height=300, left=50, top=150";
	open("passchgform.jsp","",op);
	
}
</script>
<body>
<form action = "update.jsp" name="f" method="post">
	<input type="hidden" name="picture" value="<%=mem.getPicture()%>">
	<table border="1" style="border-collapse : collapse;">
	<caption>모델1으로 구현한 회원 수정 화면</caption>
	<tr>
		<td rowspan="4" align="center" valign="bottom">
		<img src=" img/<%=mem.getPicture()%>" width="100" height="120" id="pic"><br>
		<font size="1"><a href="javascript:win_open()">사진수정</a></font></td>
		<td>아이디</td>
		<td><input type="text" name="id" value="<%=mem.getId()%>" readonly></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pass" value="<%=mem.getPass()%>" ></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="<%=mem.getName()%>" ></td>
	</tr>		
	<tr>
		<td>성별</td>
		<td><input type="radio" name="gender" value="1"  id="g1">남자
				<input type="radio" name="gender" value="2" id="g2">여자</td>
	</tr>
	<script>
	gender = <%=mem.getGender()%>;
	if(gender ==1)
			g1.setAttribute("checked","checked");
	else
		    g2.setAttribute("checked","checked");
	</script>
	<tr>
		<td>전화번호</td>
		<td colspan="2"><input type="text" name="tel" value="<%=mem.getTel()%>" ></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td colspan="2"><input type="text" name="email" value="<%=mem.getEmail()%>" ></td>
	</tr>
	<tr>
		<td colspan="3" align="center"><input type="submit"  value="회원 수정" >
		<input type="button" value="비밀번호수정" onclick="passchg_winopen()">
		</td>
	</tr>	
</table>
</form>
</body>
</html>
<%	}	} %>