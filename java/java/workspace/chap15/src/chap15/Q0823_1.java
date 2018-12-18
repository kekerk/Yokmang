package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * ȭ�鿡�� ���ϸ�� ���ڸ� �Է¹ޱ�.
 * �ش� ���ϸ��� �Է¹��� ���ڸ�ŭ�� ��ȸ�Ͽ�
 * ���ϸ�.sub ���Ͽ� �����ϱ�.
 * 
 * [���]
 * ���� ���� ���� �Է��ϼ���.
 * a.txt 5 (������ �ٽ� �Է¹ްԲ�)
 * 
 * a.txt            a.txt.sub
 * aaa				aaa
 * bbb				bbb
 * ccc				ccc
 * ddd				ddd	
 * eee				eee
 * fff
 * 
 */
public class Q0823_1 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("���� ���� ��� ������ ��´��� �Է��ϼ���");
				String file = scan.next();
				int numl = scan.nextInt();
				int cnt = 0;
				//�� ���α׷����� ���� �ҷ����� �� �б�.
				FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(file + ".sub");
				Scanner scan2 = new Scanner(fis);
				byte[] buf = new byte[fis.available()];
				while (scan2.hasNextLine()) {
					String line = scan2.nextLine();
					buf = (line + "\n").getBytes();
					fis.read(buf);
					fos.write(buf);
					cnt++;
					if (cnt == numl) {
						break;
					}
				}
				fos.flush();
				fos.close();

				System.out.println("�Ű������ϴ�. Ȯ���� ������.");
				break;
			} catch (FileNotFoundException e) {
				System.out.println("������ �����ϴ�.");
				continue;
			}

		}

	}

}
