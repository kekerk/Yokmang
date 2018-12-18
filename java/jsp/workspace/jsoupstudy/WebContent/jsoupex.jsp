<%@page import="java.io.IOException"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%-- /jsoupstudy/WebContent/jsoupex.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
</head>
<body>
	<%
		String url = "http://www.hanwhaeagles.co.kr/html/players/player/pitcher_view.asp?sGubunCd=PLPPPC&sMSId=P424";
		String line = "";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements htv = doc.select("div.tbl_type02"); //div 태그 중 class속성이 tbl_type02
			for (Element src : htv) {
				String tmpline = src.toString();
				line += tmpline;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	%>
	<%=line%>
</body>
</html>