<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.IOException"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	table,tr,td,th{
		border : 2px solid gold;
		border-collapse: collapse;
	}
</style> 
</head>
<body>
<%
		String url = "https://www.koreaexim.go.kr/site/program/financial/exchange?menuid=001001004002002";
		String line = "";
		String date="";
		String tmpline ="";
		try {
			// �ҽ� ��ü ��������
			Document doc = Jsoup.connect(url).get();

			// "p.mt5.tr" ���ǿ� �´� �±�
			Elements hdate = doc.select("p.mt5.tr"); 
			for (Element src : hdate) {
				tmpline = src.toString();
				// src.text() : �±��� ���� �κ� ���
				line += tmpline;
			}
			Elements htv = doc.select("div.table_type_h2.mt1"); //div �±� �� class�Ӽ�
			List<String> keys = new ArrayList<String>(); //��ȭ�̸�
			List<String> vals = new ArrayList<String>();
			Map<String,String> map = new HashMap<String,String>();
			for (Element src : htv) {
				//����ȯ �۱� : ������ ��
				System.out.println("����ȯ : ������ ��");
				for(Element c : src.select("th:eq(1)")){ // tr�� �������� �ι�° th ����
					keys.add(c.text());
				}
				for(Element c : src.select("td:eq(2)")){// tr�� �������� ����° td ���� 
					vals.add(c.text());
				}
				for(int i=0;i<vals.size();i++){
					map.put(keys.get(i+2), vals.get(i));
				}
				System.out.println(map);
				// �ʱ�ȭ
				map.clear();
				vals.clear();
				//�Ÿű�����
				System.out.println("�Ÿ� ������");
				for(Element c : src.select("td:eq(4)")){// tr�� �������� ����° td ���� 
					vals.add(c.text());
				}
				for(int i=0;i<vals.size();i++){
					map.put(keys.get(i+2), vals.get(i));
				}
				System.out.println(map);
				line += src.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	%>
<%=line %>
</body>
</html>