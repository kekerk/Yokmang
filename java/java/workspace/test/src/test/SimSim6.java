package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class SimSim6 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("ù��° ���� �̸��� �Է��ϼ���.");
			String file1 = scan.nextLine();
			FileInputStream fis1 = new FileInputStream(file1);
			System.out.println("�ι�° ���� �̸��� �Է�������.");
			String file2 = scan.nextLine();
			FileInputStream fis2 = new FileInputStream(file2);
			System.out.println(file1 + "�� " + file2 + "�� ���մϴ�.");
			int len1 = 0;
			int len2 = 0;
			byte[] buf1 = new byte[fis1.available()];
			byte[] buf2 = new byte[fis2.available()];
			String s1 = null;
			String s2 = null;
			if (buf1.length != buf2.length) {
				System.out.println("�� ������ ����Ʈ ���� ���� �ʽ��ϴ�.");
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
					System.out.println("byte ���� ������ ������ �ٸ� �κ��� �ֽ��ϴ�.");
					break;
				}else {
					cnt++;
					if(cnt==buf1.length) {
						System.out.println("���� ����");
						break;
					}
				}
			}
		}
	}
}
