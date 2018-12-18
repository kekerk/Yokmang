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
			// 소스 전체 가져오기
			Document doc = Jsoup.connect(url).get();

			// "p.mt5.tr" 조건에 맞는 태그
			Elements hdate = doc.select("p.mt5.tr"); 
			for (Element src : hdate) {
				tmpline = src.toString();
				// src.text() : 태그의 내용 부분 출력
				line += tmpline;
			}
			Elements htv = doc.select("div.table_type_h2.mt1"); //div 태그 중 class속성
			List<String> keys = new ArrayList<String>(); //통화이름
			List<String> vals = new ArrayList<String>();
			Map<String,String> map = new HashMap<String,String>();
			for (Element src : htv) {
				//전신환 송금 : 받으실 때
				System.out.println("전신환 : 받으실 때");
				for(Element c : src.select("th:eq(1)")){ // tr을 기준으로 두번째 th 선택
					keys.add(c.text());
				}
				for(Element c : src.select("td:eq(2)")){// tr을 기준으로 세번째 td 선택 
					vals.add(c.text());
				}
				for(int i=0;i<vals.size();i++){
					map.put(keys.get(i+2), vals.get(i));
				}
				System.out.println(map);
				// 초기화
				map.clear();
				vals.clear();
				//매매기준율
				System.out.println("매매 기준율");
				for(Element c : src.select("td:eq(4)")){// tr을 기준으로 세번째 td 선택 
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