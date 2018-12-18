
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="javax.media.jai.JAI"%>
<%@page import="javax.media.jai.RenderedOp"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.image.renderable.ParameterBlock"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ThumbNail �̹��� ����</title>
</head>
<body>
<%
	/* -------------------------���� ���ε� ����--------------------------------- */
	String path = application.getRealPath("/")+"thumbnail/"; //���� ���ε带 ���� ���� ����
	int size = 10 * 1024 * 1024; // �ִ� ���ε� ������ ũ��
	MultipartRequest multi = new MultipartRequest(request,path,size,"euc-kr");//���� ���ε�
	String filename = multi.getFilesystemName("image"); //���ε�� ������ �̸��� ����.
	/* ---------jai_codec.jar, jai_core.jar �̿��� ����� �̹��� ����-------------- */
	ParameterBlock pb = new ParameterBlock();
	pb.add(path+filename); 
	RenderedOp rop = JAI.create("fileload",pb);// �ش� (�̹���) ����(pb)�� �޸𸮿� �ε�(fileload��� �̸�����)
	BufferedImage bi = rop.getAsBufferedImage();//bi : �����̹����� ���� �̹����� �ε�(�޸𸮿� �̹����� �ε�)
	int width = bi.getWidth()/5; //���� �̹����� �ʺ� 5���� 1 �� ����
	int height = bi.getHeight()/5; //���� �̹����� ���̸� 5���� 1 �� ����
	// thumb : BufferedImage.TYPE_INT_RGB -> �÷� �̹����� ����.
	BufferedImage thumb = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	Graphics2D g = thumb.createGraphics(); // �׸��� ���� ����.
	g.drawImage(bi, 0, 0, width,height,null);// thumb �̹����� �׸��� �׸���. 
	//bi��� ���� �̹����� width,height�� ũ�⿡ �°� �׸���.
	// thumb �̹����� �׸��� �ϼ� ����
	File f= new File(path+"sm_" + filename);//thumb�� ���Ϸ� �����ϱ�.
	ImageIO.write(thumb, "jpg", f);//���� �̹����� ���Ϸ� ����.
	
%>
<h3> ���� �̹���</h3>
<img src="<%=filename %>"><p>
<h3>����� �̹���</h3>
<img src="sm_<%=filename %>"><p>
</body>
</html>