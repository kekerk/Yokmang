<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="EUC-KR">
<title>fmt 태그 연습</title>
</head>
<body>
<fmt:requestEncoding value="euc-kr"/>
<form method="post" name="f">
이름 : <input type="text" name="name" value="${param.name }"><br>
입사일 : <input type="text" name="hiredate" value="${param.hiredate }"> yyyy-MM-dd로 입력<br>
급여 : <input type="text" name="salary" value="${param.salary }"><br>
<script type="text/javascript">
	document.f.salary.value='<fmt:formatNumber value="${param.salary }" pattern="#,###,###" />';
</script>
<input type="submit" value="전송">
</form>
<hr>
이름 : ${param.name}<br>
입사일 : ${param.hiredate}<br>
급여 : ${param.salary}<br>
<hr>
<h3>문제 : 입사일을 yyyy년 dd일 E요일로 출력<br> 급여는 세자리마다 , 출력하고 숫자앞에 원화표시하기.<br>급여*12로 연봉을 계산하고, 세자리마다 ,출력 후 원화 표시하기</h3>
<%-- 요일이 없으니 parameter값을 date 형식으로 한번 바꿔주고(fmt:parseDate) 원하는 형식으로 다시 출력하기 위해 fmt:formatDate를 써서 출력--%>
<fmt:parseDate value="${param.hiredate }" pattern="yyyy-MM-dd" var="date"/>
이름 : ${param.name}<br>
입사일 :<fmt:formatDate value="${date}" pattern="yyyy년 MM월 dd일 E요일" /><br>
급여 : <fmt:formatNumber value="${param.salary }" type="currency" /><br>
연봉:  <fmt:formatNumber value="${param.salary*12 }" type="currency"/><br>
</body>
</html>