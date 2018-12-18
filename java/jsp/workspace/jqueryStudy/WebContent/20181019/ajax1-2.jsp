<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/20181019/ajax1-2.jsp --%>
<% request.setCharacterEncoding("UTF-8"); %> <!--  ajax 언어 인코딩 시 UTF-8로 반드시 인코딩하여야 한다. -->
<h2>안녕하세요 ${param.name},${param.age}살 입니다.</h2>