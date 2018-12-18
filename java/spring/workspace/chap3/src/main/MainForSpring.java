package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.AlreadyExistingMemberException;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.exitService;


/*
 * 1. chap3 ������Ʈ ����
 * 2. main ��Ű�� ����
 * 3. MainForSpring ���� Ŭ���� ����
 * 4. lib classpath�� ����
 * 
 * ���� : exit �Է��� �ϸ� ���� ��ϵ� ȸ���� ����� ���.
 */
public class MainForSpring {
	private static ApplicationContext ctx = null; //ctx : container
	public static void main(String[] args) throws IOException {
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml"); // GenericXmlApplicationContext : xml������ �̿��ؼ� �����̳� ����
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//System.in :���� �Է�
		while(true) {
			System.out.println("��ɾ �Է��ϼ���");
			String command = reader.readLine();
			///////////////////////////////////////////
			if(command.equalsIgnoreCase("exit")) {//��ҹ��� ������� exit����
				processexitCommand();
				System.out.println("�����մϴ�.");
				break;
			}
			///////////////////////////////////////////
			if(command.startsWith("new ")) { //ȸ�����
				processNewCommand(command.split(" "));
				continue;
			}else if(command.startsWith("change ")) {//��й�ȣ ����
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();//���� ���
		}
	}
	////////////////////////////////////////////////////////////////////////////
		private static void processexitCommand() {
		exitService exitSvc = ctx.getBean("exitSvc", exitService.class);
		exitSvc.exit();
	}
	////////////////////////////////////////////////////////////////////////////
		private static void processChangeCommand(String[] arg) {
			// arg[1] : �̸���, arg[2] : ������й�ȣ , arg[3] : ������ ��й�ȣ
			if(arg.length != 4) {
				printHelp(); return;
			}
			ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc",ChangePasswordService.class);
			try {
				changePwdSvc.changePassword(arg[1],arg[2],arg[3]);
				System.out.println("��ȣ�� �����߽��ϴ�.\n");
			}catch(MemberNotFoundException e) {
				System.out.println("�������� �ʴ� �̸����Դϴ�.\n");
			}catch(IdPasswordNotMatchingException e) {
				System.out.println("�̸��ϰ� ��ȣ�� ��ġ���� �ʽ��ϴ�.\n");
			} 
		}
		private static void printHelp() {
			System.out.println();
			System.out.println("\n�߸��� ����Դϴ�. �Ʒ� ��ɾ� ������ Ȯ���ϼ���");
			System.out.println("��ɾ� ���� :");
			System.out.println("new �̸��� �̸� ��ȣ Ȯ��");
			System.out.println("change �̸��� �����ȣ �����ȣ\n");
		}
		private static void processNewCommand (String[] arg){
			//arg[0]=new arg[1]=�̸��� arg[2]=�̸� arg[3]=��й�ȣ arg[4]=��й�ȣȮ��
			if(arg.length != 5) {
				printHelp(); return;
			}
			MemberRegisterService reqSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class);
			RegisterRequest req = new RegisterRequest();
			req.setEmail(arg[1]);
			req.setName(arg[2]);
			req.setPassword(arg[3]);
			req.setConfirmPassword(arg[4]);
			if(!req.isPasswordEqualToConfirmPassword()) { 
				System.out.println("��ȣ�� Ȯ���� ��ġ���� �ʽ��ϴ�.\n");
				return; 
			}
			//��й�ȣ�� ��й�ȣ Ȯ���� ������ ��� 
			try {
				reqSvc.regist(req); 
				System.out.println("����߽��ϴ�.\n");
			}catch(AlreadyExistingMemberException e) {
				System.out.println("�̹� �����ϴ� �̸��� �Դϴ�.\n");
			}
		}
	}

