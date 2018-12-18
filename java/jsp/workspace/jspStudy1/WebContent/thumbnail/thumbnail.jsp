
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
<title>ThumbNail 이미지 보기</title>
</head>
<body>
<%
	/* -------------------------파일 업로드 구간--------------------------------- */
	String path = application.getRealPath("/")+"thumbnail/"; //파일 업로드를 위한 폴더 지정
	int size = 10 * 1024 * 1024; // 최대 업로드 파일의 크기
	MultipartRequest multi = new MultipartRequest(request,path,size,"euc-kr");//파일 업로드
	String filename = multi.getFilesystemName("image"); //업로드된 파일의 이름을 저장.
	/* ---------jai_codec.jar, jai_core.jar 이용한 썸네일 이미지 제작-------------- */
	ParameterBlock pb = new ParameterBlock();
	pb.add(path+filename); 
	RenderedOp rop = JAI.create("fileload",pb);// 해당 (이미지) 파일(pb)을 메모리에 로드(fileload라는 이름으로)
	BufferedImage bi = rop.getAsBufferedImage();//bi : 원본이미지를 버퍼 이미지로 로드(메모리에 이미지를 로드)
	int width = bi.getWidth()/5; //원본 이미지의 너비를 5분의 1 값 저장
	int height = bi.getHeight()/5; //원본 이미지의 길이를 5분의 1 값 저장
	// thumb : BufferedImage.TYPE_INT_RGB -> 컬러 이미지로 설정.
	BufferedImage thumb = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	Graphics2D g = thumb.createGraphics(); // 그리기 도구 설정.
	g.drawImage(bi, 0, 0, width,height,null);// thumb 이미지에 그림을 그리기. 
	//bi라는 원본 이미지를 width,height의 크기에 맞게 그리기.
	// thumb 이미지에 그림이 완성 상태
	File f= new File(path+"sm_" + filename);//thumb을 파일로 저장하기.
	ImageIO.write(thumb, "jpg", f);//버퍼 이미지를 파일로 저장.
	
%>
<h3> 원본 이미지</h3>
<img src="<%=filename %>"><p>
<h3>썸네일 이미지</h3>
<img src="sm_<%=filename %>"><p>
</body>
</html>