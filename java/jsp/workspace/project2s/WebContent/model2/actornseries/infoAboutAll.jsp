<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("euc-kr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>About Harry Potter</title>
<style>
.main {
	width: 100%;
	margin-top: 15px;
}

.test {
	width: 50%;
}

.head {
	margin-top: 20px;
	text-align: center;
}

.img {
	width: 100%;
}

.content h4 {
	text-align: center;
}

.content h5 {
	text-align: center;
}

.magic h5 {
	text-align: center;
	margin-top:15%;
}
</style>
</head>
<body>
	<div class="main">
		<hr style="border: 2px solid silver">
		<h3 class="head">�Կ� ���</h3>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/kingscorss_station.png"
						class="img">
				</div>
				<div class="content">
					<h5>9�� 3/4 �°����� �Կ��� ŷ�� ũ�ν� ��</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/Australia_House.png"
						class="img">
					<div class="content">
						<h6>
							���� ������ ������ ������ �׸���Ʈ ���� ���� �Կ�����<br>���� �� ����Ʈ���ϸ��� ����
						</h6>
					</div>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/Bodleian_Library_Oxford.jpg"
						class="img">
					<div class="content">
						<h5>ȣ�׿�Ʈ ���������� ���� �����۵�� ���鷹�̾� ������</h5>
					</div>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/The_Christ_Church_Colledge_Oxford.jpg"
						class="img">
					<div class="content">
						<h5>ȣ�׿�Ʈ �뿬ȸ������ ���� �����۵�� ��ȸ</h5>
					</div>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img src="${path}/model2/actornseries/img/place/Alnwick_Castle.jpg"
						class="img">
					<div class="content">
						<h5>ȣ�׿�Ʈ ������ ���Դ� ����ũ ĳ��</h5>
					</div>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="${path}/model2/actornseries/img/place/Glenfinnan_Viaduct.jpg"
						class="img">
					<div class="content">
						<h5>ȣ�׿�Ʈ�� �� ������ ���İ��� �۷��ǳ� ����</h5>
					</div>
				</div>
			</div>
		</div>
		<hr style="border: 2px solid silver">
		<h3 class="head">������(?) ���� �ִ� ���� �ֹ� �Ұ�</h3>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_163/eog990428_1344577592320CROnr_GIF/%BE%CB%B7%CE%C8%A3%B8%F0%B6%F3.GIF?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>�˷�ȣ���(Alohomora)</strong><br> ����ִ� �ڹ��質 �� ���� �����ִ� �ֹ�
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>�귡Ű�� ���൵(Brakium Ememdo)</strong><br>
						�η��� ���� �ٿ��ִ� �ֹ�</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_52/eog990428_1344233819874BQrQm_GIF/anigif.gif?type=w2"
						class="img">
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_59/eog990428_1344577279979A3355_GIF/%BE%C6%B9%D9%B4%D9%C4%C9%B4%D9%BA%EA%B6%F3.GIF?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>�ƹٴ� �ɴٺ��(Avada Kedabra)</strong><br> �뼭���� ���� 3���� �ֹ� �� �ϳ��� ���� �ֹ�<br>
						�ظ� ���͸��� �� �ֹ��� ������ ������
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>�ͽ����� ��Ʈ�δ�(Expecto Patronum)</strong><br> ����͸� ���� �� �ִ� ��Ʈ�δ��� ��ȯ �ֹ�
					</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_87/eog990428_1344234963334cU8w5_GIF/anigif.gif?type=w2"
						class="img">
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_134/eog990428_1344578470227WD0vn_GIF/%C6%C4%B8%A3%C6%BC%BD%BA_%C5%DB%C6%F7%B7%AF%BD%BA.GIF?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>�ĸ�Ƽ�� ��������(Partis Temporus)</strong><br> ���� �����ϰ� ������ ȭ���� ����� �ֹ�
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>��ŧ���� ���ķ�(Oculus Reparo)</strong><br> �Ȱ��� �����ϰ� �۰ų� ��ġ�� �ֹ�
					</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_128/eog990428_1344577960193Ax3eL_GIF/%BF%C0%C4%F0%B7%E7%BD%BA_%B7%B9%C6%C4%B7%CE.GIF?type=w2"
						class="img">
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_139/eog990428_1344234565623yfvJs_GIF/anigif.gif?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>����ŧ����(Riddikulus)</strong><br> ����Ʈ�� �콺�ν����� ������� �����<br> ��ġ�ϴ� ����Ʈ
						��ġ ����
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>������� �������(Wingardium Leviosa)</strong><br> ����̳� �繰�� ���� ���ߺξ� ����
					</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_85/eog990428_1344231323590Wm7jr_GIF/%C0%AE%B0%A1%B8%A3%B5%F0%BF%F2%B7%B9%BA%F1%BF%C0%BF%EC%BB%E7.gif?type=w2"
						class="img">
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120810_97/eog990428_1344578982484chees_GIF/%C8%A3%B1%D7%BF%CD%C6%AE%B8%B6%B9%FD%C1%F6%B5%B5.GIF?type=w2"
						class="img">
				</div>
			</div>
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>���� õ���� ���ֱ������� ������ �����մϴ�</strong><br><strong>(I Solemly Swear That I'm Up To
						No Good)</strong><br> ȣ�׿�Ʈ ��������� ����ϱ� ���� �õ��ֹ�
					</h5>
				</div>
			</div>
		</div>
		<div class="w3-row-padding w3-center">
			<div class="test w3-half">
				<div class="magic">
					<h5>
						<strong>�����ַ��� �̷���(Slugulus Eructo)</strong><br> �Կ��� �����̰� ������ �ϴ� �ֹ�
					</h5>
				</div>
			</div>
			<div class="test w3-half">
				<div>
					<img
						src="https://mblogthumb-phinf.pstatic.net/20120806_209/eog990428_1344233204629MMPe3_GIF/anigif.gif?type=w2"
						class="img">
				</div>
			</div>
		</div>
	</div>
</body>
</html>