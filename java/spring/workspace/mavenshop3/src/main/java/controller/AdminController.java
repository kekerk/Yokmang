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
 * AOP ���� : AdminController�� ��� �޼���� �ݵ�� admin���� �α��� �ؾ߸� ����ǵ��� �ϱ�
 * AdminAspect Ŭ���� ����
 * 1. �α��� �ȵ� ��� : �α��� �ϼ��� ��� �� loginForm.shop���� �̵�
 * 2. �����ڰ� �ƴ� ��� : �����ڸ� ��밡�� �մϴ�. ��� �� mypage.shop���� �̵�
 * 3. �������� ��� : ����
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
			throw new ShopException("������ ���� ����ڸ� �����ϼ���","list.shop");
		}
		//userList : ���õ� ������� ���� ����
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
	// MyAuthenticator : �ڹ� ������ �̿��Ͽ� ���� ���۽� ���� ������ ���� �ޱ����� ��ü
	private final class MyAuthenticator extends Authenticator {
		private String id;
		private String pw;
		public MyAuthenticator(String id, String pw) {
			this.id = id;
			this.pw = pw;
		}
		@Override
		protected PasswordAuthentication getPasswordAuthentication() { //��й�ȣ ����
			return new PasswordAuthentication(id,pw);
		}		
	}
	
	private void mailSend(Mail mail) {
		// auth : ���� ��ü
		//���� ������ ���� ȯ�� ���� ����
		MyAuthenticator auth = new MyAuthenticator(mail.getNaverid(),mail.getNaverpw());
		Properties prop = new Properties(); // Map ��ü (HashTable ���� Ŭ����)
		prop.put("mail.smtp.host", "smtp.naver.com"); //���̹� smtp������ ȣ��Ʈ ����. �������ۼ��� �ּ� ����.
		prop.put("mail.smtp.starttls.enable", "true");//���� ���� 
		prop.put("mail.user", mail.getNaverid());
		prop.put("mail.from", mail.getNaverid());
		prop.put("mail.debug","false"); //debug ���·� �ǽ��ϱ�
		prop.put("mail.smtp.auth","true");//���� ���� �� ���� �ʼ�.
		prop.put("mail.smtp.port","465");//���� ��Ʈ
		prop.put("mail.smtp.user", mail.getNaverid()); //������ ��� ����
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//���� ������ ���� ������ ���� (SSL)
		prop.put("mail.smtp.socketFactory.fallback", "false");
		// Session.getInstance(prop,auth) : ���� ������ ����(������ü ����). �غ� �Ϸ�
		Session session = Session.getInstance(prop,auth);
		// session�� ���� ���۵Ǵ� ��ü
		MimeMessage msg = new MimeMessage(session);//���Ϸ� ������ ��ü ����
		
		//�޴� ��� ����
		try {
			msg.setFrom(new InternetAddress(mail.getNaverid()+"@naver.com"));
			List<InternetAddress> addrs = new ArrayList<InternetAddress>();
			System.out.println(mail.getRecipient());
			String[] emails = mail.getRecipient().split(",");
			for(String email : emails) {
				try {
					addrs.add(new InternetAddress(new String(email.getBytes("utf-8"),"8859_1"))); // "8859_1" : ISO-8859-1(�ѱ� ���ڵ�)
				}catch(UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			InternetAddress[] arr = new InternetAddress[emails.length];
			for(int i=0;i<addrs.size();i++) {
				arr[i] = addrs.get(i);
			}
			msg.setSentDate(new Date());//��������
			//�޴� ��� ����
			//Message.RecipientType.TO : �޴� ��� ���� ����
			//Message.RecipientType.CC : �����ϴ� ��� ���� ����
			msg.setRecipients(Message.RecipientType.TO, arr);
			msg.setSubject(mail.getTitle());//����
			
			//���� �κ� ����
			// multipart : ���� �κ��� �������� ����(����, ÷������1, ÷������2)
			MimeMultipart multipart = new MimeMultipart();
			//���� �κ��� msg�� �߰�
			MimeBodyPart message = new MimeBodyPart();
			message.setContent(mail.getContents(), mail.getMtype());
			multipart.addBodyPart(message);//���� ����
			//���� �κ��� msg�� �߰�
			// List<MultipartFile> = mail.getFile1()
			for(MultipartFile mf : mail.getFile1()) {
				if((mf != null) && (!mf.isEmpty())) {
					multipart.addBodyPart(bodyPart(mf));//���� ����
				}
			}
			//���ļ� ����� ������ �ϳ��� ���ļ� msg�� ����
			msg.setContent(multipart);
			//���� ���� ����
			Transport.send(msg);
		}catch(MessagingException me) {
			me.printStackTrace();
		}
	}
	
	//÷������ ��ɵ� ����ִ�.
	private BodyPart bodyPart(MultipartFile mf) {
		MimeBodyPart body = new MimeBodyPart();
		String orgFile = mf.getOriginalFilename(); //���� �̸�
		// f1 : upload�� ������ ������ ������ ��ġ
		File f1 = new File("D:/2018.07.30/spring/workspace/mavenshop3/mailupload/"+orgFile);
		try {
			mf.transferTo(f1); //���Ϸ� �����ϱ�
			body.attachFile(f1); //������ ���Ͽ� ÷��.
			body.setFileName(new String(orgFile.getBytes("EUC-KR"),"8859_1"));//�޴� �ʿ��� �ѱ۷� �ν��ϱ� ���� ISO-8859-1 incoding
		}catch(Exception e) {
			e.printStackTrace();
		}
		return body;
	}
}
