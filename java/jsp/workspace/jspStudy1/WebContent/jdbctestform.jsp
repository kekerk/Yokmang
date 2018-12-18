<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>테이블 조회하기</title>
<script type="text/javascript">
	function con(f){
		if(f.col.value.length==0){
			alert("조회컬럼명을 입력해야합니다.");
			f.col.focus();
			return false;
		}
	}
</script>
</head>
<body>
<form action="jdbctest.jsp" method="post" onsubmit="return con(this)" >
<table>
<tr><td colspan="2"> <!--  테이블명 --> <%-- request.parameter로 name(tb)에 대한 value를 받아온다. --%>
		<input type="radio" value="student" name="tb"> 학생
		<input type="radio" value="professor" name="tb"> 교수
		<input type="radio" value="emp" name="tb"> 사원
		<input type="radio" value="dept" name="tb"> 부서
</td></tr>
<tr><td>조회 컬럼</td>
		<td><textarea name="col" cols="30" rows="3"></textarea></td></tr>
<tr><td>where</td>
		<td><textarea name="wh" cols="30" rows="3"></textarea></td></tr>
<tr><td>group by</td>
		<td><textarea name="gr" cols="30" rows="3"></textarea></td></tr>
<tr><td>having</td>
		<td><textarea name="ha" cols="30" rows="3"></textarea></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="테이블 조회하기"></td></tr>
</table>
</form>
</body>
</html>