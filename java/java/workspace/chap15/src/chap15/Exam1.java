package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 화면에서 파일명을 입력받고, 내용을 입력받아 파일명에 출력하는 프로그램.
 * 내용은 "exit"까지 입력받기.
 */

public class Exam1 {
	public static void main(String[] args) throws IOException {
		// system.in -> 키보드 입력.
		Scanner scan = new Scanner(System.in);
		System.out.println("파일명을 입력하시오.");
		// 
		String file = scan.nextLine();
		// FileOutputStream 으로 파일 생성.
		FileOutputStream fos = new FileOutputStream(file,true);
		System.out.println("내용을 입력하세요.");
		byte[] buf = new byte[1000];
		boolean a = true;
		// 입력 구문.
		while (true) {
			String text = scan.nextLine();
			if (text.equals("exit")) {
				break;
			}
			buf = (text + "\n").getBytes();
			fos.write(buf);
		}
		fos.flush();
		fos.close();
	}
}
