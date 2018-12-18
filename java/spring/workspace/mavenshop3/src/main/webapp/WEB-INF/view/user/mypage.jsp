<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>MyPage</title>
<style type="text/css">
table {
	width: 90%;
	border-collapse: collapse;
}

th, td {
	border: 3px solid #bcbcbc;
	text-align: center;
	padding: 8px;
}

th {
	background-color: #4CAF50;
	color: white;
	text-align: center;
}

td {
	background-color: #f2f2f2;
}

td.title {
	background-color: #e2e2e2;
	color: blue;
}
</style>
<script type="text/javascript">
	window.onload=function() {
		document.getElementById("minfo").style.display="none";
		document.getElementById("oinfo").style.display="block";
	}
	function disp_div(id){
		document.getElementById("minfo").style.display="none";
		document.getElementById("oinfo").style.display="none";
		document.getElementById(id).style.display="block";
	}
	
	function list_disp(id){
		var disp=document.getElementById(id);
		if(disp.style.display=="block"){
			disp.style.display = "none";
		}else{
			disp.style.display = "block";
		}
	}
</script>
</head>
<body>
<div>
<h3>
<a href="javascript:disp_div('oinfo')">�ֹ� ���</a>&nbsp;<a href="javascript:disp_div('minfo')">ȸ�� ����</a>
</h3>
</div>
<div id="oinfo" style="display: none; width:100%;" align="center">
	<table border="1"style="width:100%">
		<tr><td colspan="3" align="center"><b>�ֹ� ���</b></td></tr>
		<tr><th>�ֹ� ��ȣ</th><th>�ֹ� ����</th><th>�� �ֹ� �ݾ�</th></tr>
		<c:forEach items="${salelist}" var="sale" varStatus="stat">
			<tr>
				<td align="center">
					<a href="javascript:list_disp('saleLine${stat.index}')">${sale.saleId}</a>
				</td>
				<td align="center">
					<fmt:formatDate value="${sale.updateTime}" pattern="yyyy-MM-dd"/>
				</td>
				<td align="right">
					${sale.totAmount}��
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<div id="saleLine${stat.index}" style="display:none;" align="center">
						<table border="1" style="width:90%;" >
							<tr>
								<th width="25%">��ǰ��</th>
								<th width="25%">��ǰ����</th>
								<th width="25%">���ż���</th>
								<th width="25%">��ǰ�Ѿ�</th>
						<c:forEach items="${sale.itemList}" var="saleItem">
							<tr>
								<td align="center" class="title"><a href="../item/detail.shop?id=${saleItem.item.id}">${saleItem.item.name}</a></td>		
								<td align="right">${saleItem.item.price}��</td>	
								<td align="right">${saleItem.quantity}��</td>	
								<td align="right">${saleItem.quantity*saleItem.item.price}��</td>
							</tr>
						</c:forEach>
						</table>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>	
<div id="minfo" style="display:none; width:100%;">
	<table border="1" style="width:100%">
		<tr>
			<td colspan="2"><b>ȸ�� ����</b></td>
		</tr>
		<tr><td>���̵�</td><td>${user.userId}</td></tr>
		<tr><td>�̸�</td><td>${user.userName}</td></tr>
		<tr><td>�����ȣ</td><td>${user.postcode}</td></tr>
		<tr><td>��ȭ��ȣ</td><td>${user.phoneNo}</td></tr>
		<tr><td>�ּ�</td><td>${user.address}</td></tr>
		<tr><td>�̸���</td><td>${user.email}</td></tr>
		<tr><td>�������</td><td><fmt:formatDate value="${user.birthDay}" pattern="yyyy-MM-dd"/></td></tr>
	</table>
</div> 
<br>
<a href="updateForm.shop?id=${user.userId}">[ȸ����������]</a>&nbsp;
<c:if test="${loginUser.userId != 'admin'}">
<a href="delete.shop?id=${user.userId}">[ȸ��Ż��]</a>&nbsp;
</c:if>
<c:if test="${loginUser.userId == 'admin'}">
<a href="../admin/list.shop">[ȸ�����]</a>&nbsp;
</c:if>
<a href="logout.shop?id=${user.userId}">[�α׾ƿ�]</a>&nbsp;
</body>
</html>