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
// 문제 : 파일의 용량이 10*1024*1024 보다 큰 경우 용량 초과 메세지 출력. memberimgForm.jsp 이동.
// 문제 : 파일 업로드시 3분의 1크기의 썸네일 이미지 파일 생성하기.
	try{	
	MultipartRequest multi = new MultipartRequest(request, path, 1*1024*1024,"euc-kr");
	String filename = multi.getFilesystemName("picture");
	/*
		boolean imgable = multi.getContentType("picture").contains("image");
	
		multi.getContentType("picture") : picture 파일의 형식을 MIME 타입으로 리턴. image/jpg, image/gif .... 에서 image
		.contains("image") : picture의 타입이 image 형식
	*/
	ParameterBlock pb = new ParameterBlock();
	pb.add(path+filename);
	RenderedOp rop = JAI.create("fileload", pb);
	BufferedImage bi = rop.getAsBufferedImage(); //원본 이미지를 버퍼 이미지로 로드
	int width = bi.getWidth()/3;
	int height = bi.getHeight()/3;
	BufferedImage thumb = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	Graphics2D g = thumb.createGraphics();
	g.drawImage(bi, 0, 0, width, height, null);
	File f =new File(path+"sm_"+filename);
	ImageIO.write(thumb, "jpg", f);
	boolean imgable = multi.getContentType("picture").contains("image");

	if(imgable){ //업로드된 파일이 이미지 파일인지?
				%>
<script type="text/javascript">
	<%-- 
		opener : 나를 오픈한 윈도우(joinform.jsp)를 지칭
	 --%>
	img = opener.document.getElementById("pic");
	img.src = "img/<%=filename%>";
	opener.document.f.picture.value="<%=filename %>";
	// self : 현재 윈도우(win_open()에 의해 열린 창)
	self.close();
</script>		
<% }else{ %>
<script>
	alert("이미지파일만 업로드 가능합니다.");
	location.href="memberimgForm.jsp";
</script>
<%
       }
	}catch(IOException e){
			response.setStatus(200);
%>
<script>
	alert("용량 초과");
	location.href="memberimgForm.jsp";
</script>
<% } %>