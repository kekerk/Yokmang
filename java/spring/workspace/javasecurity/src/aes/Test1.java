package aes;

import java.util.Scanner;

/*
 * ������ �̸�, ��й�ȣ, ��ȣȭ �����̸��� �Է¹޾Ƽ� ���� ���� 
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �̸�");
		String pfile = scan.nextLine();
		System.out.println("��й�ȣ");
		String passkey = scan.nextLine();
		System.out.println("��ȣȭ���� �̸�");
		String cfile = scan.nextLine();
		CipherFileAES.encryptFileWithPasskey(passkey,pfile,cfile);
	}

}
