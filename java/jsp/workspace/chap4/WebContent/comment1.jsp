<%@ page language="java" contentType="text/html; charset=EUC-KR"    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!--  chap4 ������Ʈ  ����
		 /WebContent/comment1.jsp -->
<html>
<head>
<meta charset="EUC-KR">
<title>�ּ� ����</title>
</head>
<body>
<h1>jsp���� ���Ǵ� �ּ� 3����</h1>
<ol> <!--  ol ����Ʈ �⺻�� : 1 -->
	<li>jsp �ּ� : &lt;%-- JSP �ּ� ǥ�� --%&gt;</li>
	<!--  �̰��� JSP �ּ��Դϴ�. JSP ������������ �������� ���������� �������� �ʽ��ϴ�. -->
	<li>�ڹ��ּ� : &lt;% // ���� �ڹ� �ּ� %&gt;
						   &lt;% /* ������ �ڹ� �ּ� */ %&gt;<br>
						  �ڹ� �������� ���Ǵ� �ּ�. ��ũ��Ʈ ���ο��� ���˴ϴ�.<br>
						  �ڹ� �ּ��� jsp�� servlet���� �� �� �ֽ��ϴ�.
	</li>
	<% //���� �ּ��Դϴ�.
		  /* ������ �ּ��Դϴ� */ 
    	  String msg = "HTML �ּ�";
	%>
	<li> HTML �ּ� : &lt;!-- HTML �ּ� ǥ�� --&gt;<br>
			JSP�� ���������� �ּ��� �ƴմϴ�.<br>
			���������� ȭ�� ��½� �ּ����� �ν��մϴ�.
			<!--  <%=msg %> �̰��� HTML �ּ��Դϴ�. �������� �ּ��� �ƴմϴ�. HTML �ּ��� �������� �ҽ������ �� �� �ֽ��ϴ�. -->
	</li>
</ol>
</body>
</html>