<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.media.jai.JAI"%>
<%@page import="javax.media.jai.RenderedOp"%>
<%@page import="java.awt.image.renderable.ParameterBlock"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<meta charset="EUC-KR">
<%
	String path = application.getRealPath("/") + "model1/member/img/";
// ���� : ������ �뷮�� 10*1024*1024 ���� ū ��� �뷮 �ʰ� �޼��� ���. memberimgForm.jsp �̵�.
// ���� : ���� ���ε�� 3���� 1ũ���� ����� �̹��� ���� �����ϱ�.
	try{	
	MultipartRequest multi = new MultipartRequest(request, path, 1*1024*1024,"euc-kr");
	String filename = multi.getFilesystemName("picture");
	/*
		boolean imgable = multi.getContentType("picture").contains("image");
	
		multi.getContentType("picture") : picture ������ ������ MIME Ÿ������ ����. image/jpg, image/gif .... ���� image
		.contains("image") : picture�� Ÿ���� image ����
	*/
	ParameterBlock pb = new ParameterBlock();
	pb.add(path+filename);
	RenderedOp rop = JAI.create("fileload", pb);
	BufferedImage bi = rop.getAsBufferedImage(); //���� �̹����� ���� �̹����� �ε�
	int width = bi.getWidth()/3;
	int height = bi.getHeight()/3;
	BufferedImage thumb = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	Graphics2D g = thumb.createGraphics();
	g.drawImage(bi, 0, 0, width, height, null);
	File f =new File(path+"sm_"+filename);
	ImageIO.write(thumb, "jpg", f);
	boolean imgable = multi.getContentType("picture").contains("image");

	if(imgable){ //���ε�� ������ �̹��� ��������?
				%>
<script type="text/javascript">
	<%-- 
		opener : ���� ������ ������(joinform.jsp)�� ��Ī
	 --%>
	img = opener.document.getElementById("pic");
	img.src = "img/<%=filename%>";
	opener.document.f.picture.value="<%=filename %>";
	// self : ���� ������(win_open()�� ���� ���� â)
	self.close();
</script>		
<% }else{ %>
<script>
	alert("�̹������ϸ� ���ε� �����մϴ�.");
	location.href="memberimgForm.jsp";
</script>
<%
       }
	}catch(IOException e){
			response.setStatus(200);
%>
<script>
	alert("�뷮 �ʰ�");
	location.href="memberimgForm.jsp";
</script>
<% } %>