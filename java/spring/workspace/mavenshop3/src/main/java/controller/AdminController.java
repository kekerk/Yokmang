package controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import exception.ShopException;
import logic.Mail;
import logic.ShopService;
import logic.User;

/*
 * AOP 설정 : AdminController의 모든 메서드는 반드시 admin으로 로그인 해야만 실행되도록 하기
 * AdminAspect 클래스 생성
 * 1. 로그인 안된 경우 : 로그인 하세요 출력 후 loginForm.shop으로 이동
 * 2. 관리자가 아닌 경우 : 관리자만 사용가능 합니다. 출력 후 mypage.shop으로 이동
 * 3. 관리자인 경우 : 접속
 */
@Controller
public class AdminController {
	@Autowired
	private ShopService service;
	
	@RequestMapping("admin/list")
	public ModelAndView list(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<User> userList = service.userList();
		mav.addObject("userlist",userList);
		return mav;
	}
	
	@RequestMapping("admin/mailForm")
	public ModelAndView mailForm(String[] idchks, HttpSession session) {
		ModelAndView mav = new ModelAndView("admin/mail");
		if(idchks == null || idchks.length==0) {
			throw new ShopException("메일을 보낼 대상자를 선택하세요","list.shop");
		}
		//userList : 선택된 사용자의 정보 저장
		List<User> userList = service.userList(idchks);
		mav.addObject("userList",userList);
		return mav;
	}
	

	@RequestMapping("admin/mail")
	public ModelAndView mail(Mail mail, HttpSession session) {
		ModelAndView mav = new ModelAndView("admin/mail");
		mailSend(mail);
		mav.setViewName("admin/mailSuccess");
		return mav;
		
	}
	// MyAuthenticator : 자바 메일을 이용하여 메일 전송시 메일 서버에 인증 받기위한 객체
	private final class MyAuthenticator extends Authenticator {
		private String id;
		private String pw;
		public MyAuthenticator(String id, String pw) {
			this.id = id;
			this.pw = pw;
		}
		@Override
		protected PasswordAuthentication getPasswordAuthentication() { //비밀번호 인증
			return new PasswordAuthentication(id,pw);
		}		
	}
	
	private void mailSend(Mail mail) {
		// auth : 인증 객체
		//메일 전송을 위한 환경 변수 설정
		MyAuthenticator auth = new MyAuthenticator(mail.getNaverid(),mail.getNaverpw());
		Properties prop = new Properties(); // Map 객체 (HashTable 하위 클래스)
		prop.put("mail.smtp.host", "smtp.naver.com"); //네이버 smtp서버로 호스트 설정. 메일전송서버 주소 저장.
		prop.put("mail.smtp.starttls.enable", "true");//보안 서버 
		prop.put("mail.user", mail.getNaverid());
		prop.put("mail.from", mail.getNaverid());
		prop.put("mail.debug","false"); //debug 상태로 실습하기
		prop.put("mail.smtp.auth","true");//메일 전송 시 인증 필수.
		prop.put("mail.smtp.port","465");//서버 포트
		prop.put("mail.smtp.user", mail.getNaverid()); //보내는 사람 설정
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//서버 구현시 보안 서버로 구현 (SSL)
		prop.put("mail.smtp.socketFactory.fallback", "false");
		// Session.getInstance(prop,auth) : 메일 서버에 연결(인증객체 전달). 준비 완료
		Session session = Session.getInstance(prop,auth);
		// session을 통해 전송되는 객체
		MimeMessage msg = new MimeMessage(session);//메일로 전송할 객체 생성
		
		//받는 사람 설정
		try {
			msg.setFrom(new InternetAddress(mail.getNaverid()+"@naver.com"));
			List<InternetAddress> addrs = new ArrayList<InternetAddress>();
			System.out.println(mail.getRecipient());
			String[] emails = mail.getRecipient().split(",");
			for(String email : emails) {
				try {
					addrs.add(new InternetAddress(new String(email.getBytes("utf-8"),"8859_1"))); // "8859_1" : ISO-8859-1(한글 인코딩)
				}catch(UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			InternetAddress[] arr = new InternetAddress[emails.length];
			for(int i=0;i<addrs.size();i++) {
				arr[i] = addrs.get(i);
			}
			msg.setSentDate(new Date());//전송일자
			//받는 사람 설정
			//Message.RecipientType.TO : 받는 사람 구분 설정
			//Message.RecipientType.CC : 참조하는 사람 구분 설정
			msg.setRecipients(Message.RecipientType.TO, arr);
			msg.setSubject(mail.getTitle());//제목
			
			//내용 부분 설정
			// multipart : 내용 부분을 여러개로 설정(내용, 첨부파일1, 첨부파일2)
			MimeMultipart multipart = new MimeMultipart();
			//내용 부분을 msg에 추가
			MimeBodyPart message = new MimeBodyPart();
			message.setContent(mail.getContents(), mail.getMtype());
			multipart.addBodyPart(message);//내용 저장
			//파일 부분을 msg에 추가
			// List<MultipartFile> = mail.getFile1()
			for(MultipartFile mf : mail.getFile1()) {
				if((mf != null) && (!mf.isEmpty())) {
					multipart.addBodyPart(bodyPart(mf));//파일 저장
				}
			}
			//합쳐서 내용과 파일을 하나로 합쳐서 msg에 저장
			msg.setContent(multipart);
			//메일 전송 실행
			Transport.send(msg);
		}catch(MessagingException me) {
			me.printStackTrace();
		}
	}
	
	//첨부파일 기능도 들어있다.
	private BodyPart bodyPart(MultipartFile mf) {
		MimeBodyPart body = new MimeBodyPart();
		String orgFile = mf.getOriginalFilename(); //파일 이름
		// f1 : upload된 파일을 서버에 저장할 위치
		File f1 = new File("D:/2018.07.30/spring/workspace/mavenshop3/mailupload/"+orgFile);
		try {
			mf.transferTo(f1); //파일로 생성하기
			body.attachFile(f1); //파일을 메일에 첨부.
			body.setFileName(new String(orgFile.getBytes("EUC-KR"),"8859_1"));//받는 쪽에서 한글로 인식하기 위해 ISO-8859-1 incoding
		}catch(Exception e) {
			e.printStackTrace();
		}
		return body;
	}
}
