<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- /WebContent/model2/alert.jsp --%>
<c:if test="${!empty type}">
<script>
alert('${msg}');
self.close();
window.opener.location.href='${url}';
</script>
</c:if>
<script>
alert('${msg}');
location.href='${url}';
</script>

