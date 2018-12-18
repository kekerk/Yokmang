package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class SimSim6 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("첫번째 파일 이름을 입력하세요.");
			String file1 = scan.nextLine();
			FileInputStream fis1 = new FileInputStream(file1);
			System.out.println("두번째 파일 이름을 입려갛세요.");
			String file2 = scan.nextLine();
			FileInputStream fis2 = new FileInputStream(file2);
			System.out.println(file1 + "와 " + file2 + "를 비교합니다.");
			int len1 = 0;
			int len2 = 0;
			byte[] buf1 = new byte[fis1.available()];
			byte[] buf2 = new byte[fis2.available()];
			String s1 = null;
			String s2 = null;
			if (buf1.length != buf2.length) {
				System.out.println("두 파일의 바이트 수가 같지 않습니다.");
				continue;
			}
			int cnt = 0;
			while(((len1=fis1.read(buf1))!= -1)) {
				s1 = new String(buf1,0,len1);
			}
			while(((len2=fis2.read(buf2))!= -1)) {
				s2 = new String(buf2,0,len2);
			}
			
			for(int i=0;i<s1.length();i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					System.out.println("byte 수는 같으나 내용이 다른 부분이 있습니다.");
					break;
				}else {
					cnt++;
					if(cnt==buf1.length) {
						System.out.println("내용 비교중");
						break;
					}
				}
			}
		}
	}
}
