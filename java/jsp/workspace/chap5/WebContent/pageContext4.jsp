<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<hr>
���� ��¥ : <%=request.getAttribute("today") %><br> <!-- pageContext3.jsp�� request.setAttribute("today",new Date());�� ���� �޾ƿ� �� �ִ�. -->
name : <%=request.getParameter("name") %><br>
msg�� : <%=request.getAttribute("msg") %><br>
msg�� : <%=pageContext.getAttribute("msg") %> <!--  ���� ���������� �̷������ ���� �ƴ϶� null������ ���´�. -->
<hr>
