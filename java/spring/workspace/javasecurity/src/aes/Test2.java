package aes;

import java.util.Scanner;
/*
 * 암호화 파일이름, 비밀번호, 평문화 파일이름을 입력받아서 파일 생성 
 */
public class Test2 {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("암호문파일 이름");
	String cfile = scan.nextLine();
	System.out.println("비밀번호");
	String passkey = scan.nextLine();
	System.out.println("평문파일 이름");
	String pfile = scan.nextLine();
	CipherFileAES.decryptFileWithPasskey(passkey,cfile,pfile);
	}
}
