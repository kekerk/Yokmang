<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.io.IOException"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String url = "https://www.koreaexim.go.kr/site/program/financial/exchange?menuid=001001004002002";
		String line = "";
		String date="";
		try {
			// �ҽ� ��ü ��������
			Document doc = Jsoup.connect(url).get();
			// "p.mt5.tr" ���ǿ� �´� �±�
			Elements hdate = doc.select("p.mt5.tr"); 
			for (Element src : hdate) {
				String tmpline = src.toString();
				line += tmpline;
			}
			Elements htv = doc.select("div.table_type_h2.mt1"); //div �±� �� class�Ӽ��� tbl_type02
			for (Element src : htv) {
				// ������ ȯ�� ���� ���� ����ϱ�.
				for(Element c : src.select("caption")){
					System.out.println(c.text());// src.text() : �±��� ���� �κ� ���
				}
				String tmpline = src.toString();
				line += tmpline;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	%>
<%=line %>
</body>
</html>