package aes;

import java.util.Scanner;

/*
 * 평문파일 이름, 비밀번호, 암호화 파일이름을 입력받아서 파일 생성 
 */
public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("평문파일 이름");
		String pfile = scan.nextLine();
		System.out.println("비밀번호");
		String passkey = scan.nextLine();
		System.out.println("암호화파일 이름");
		String cfile = scan.nextLine();
		CipherFileAES.encryptFileWithPasskey(passkey,pfile,cfile);
	}

}
