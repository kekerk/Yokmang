package test;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("암호화시킬 문자열을 입력하시오");
		String src = scan.nextLine();
		String result = "";
		result = encrypt(src);
		System.out.println("암호화");
		System.out.println("src:" + src);
		System.out.println("result:" + result);
		System.out.println();
		src = result;
		result = decrypt(src);
		System.out.println("복호화");
		System.out.println("src:" + src);
		System.out.println("result:" + result);

	}

	private static String encrypt(String src) {
		char pCode[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char cCode[] = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']',
				'{', '}', ';', ':', ',', '.', '/', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		String tmp="";
		for(int i=0;i<src.length();i++) {
			for(int j=0;j<pCode.length;j++) {
				if(pCode[j]==src.charAt(i)) {
					tmp += cCode[j];
				}
			}
			
		}
		return tmp;
	}

	private static String decrypt(String src) {
		char pCode[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char cCode[] = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']',
				'{', '}', ';', ':', ',', '.', '/', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		String tmp="";
		for(int i=0;i<src.length();i++) {
			for(int j=0;j<cCode.length;j++) {
				if(cCode[j]==src.charAt(i)) {
					tmp += pCode[j];
				}
			}
			
		}
		return tmp;
	}

}
