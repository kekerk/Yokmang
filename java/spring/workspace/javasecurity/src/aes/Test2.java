package aes;

import java.util.Scanner;
/*
 * ��ȣȭ �����̸�, ��й�ȣ, ��ȭ �����̸��� �Է¹޾Ƽ� ���� ���� 
 */
public class Test2 {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("��ȣ������ �̸�");
	String cfile = scan.nextLine();
	System.out.println("��й�ȣ");
	String passkey = scan.nextLine();
	System.out.println("������ �̸�");
	String pfile = scan.nextLine();
	CipherFileAES.decryptFileWithPasskey(passkey,cfile,pfile);
	}
}
