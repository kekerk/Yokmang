<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ taglib prefix="test" uri="/ELFunctions" %>  
  <%-- uri="/ELFunctions" : WEB_INF�� ���� ���� �� <uri> �±װ� /ELFunctions �� ������ �ε���.
     -->   /WEB_INF/tlds/elfunction.tld ������ �ǹ� --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>EL���� �ڹ� �Լ� ����ϱ� : taglib Directive ����ϱ�</title>
</head>
<body>
<form method="post">
	x : <input type="text" name="x" value="${param.x }"><br> <%-- param.x , param.y�� ���� ������ null�� �ƴ϶� �������� ���� --%>
	y : <input type="text" name="y" value="${param.y }"><br>
	<input type="submit" value="���ϱ�">
</form><p>
<%--
	 test:  -> /WEB-INF/tlds/elfunction.tld ���� ����
	add   -> el.Compute Ŭ������ add  �޼��带 �ǹ� 
				   elfunction.tld�� 	<name>add</name> �� ����
 --%>
�հ� : ${test:add(param.x,param.y) }<br> 
<%--
	 test(���λ�):add(�Լ�)( param.x,param.y )
	���λ� test�� <%@taglib prefix="test" .... %>���� �����Ǿ��⿡ test�� ���λ縦 ����Ѵ�.
--%>
</body>
</html>