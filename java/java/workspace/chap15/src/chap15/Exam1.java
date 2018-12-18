package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * ȭ�鿡�� ���ϸ��� �Է¹ް�, ������ �Է¹޾� ���ϸ� ����ϴ� ���α׷�.
 * ������ "exit"���� �Է¹ޱ�.
 */

public class Exam1 {
	public static void main(String[] args) throws IOException {
		// system.in -> Ű���� �Է�.
		Scanner scan = new Scanner(System.in);
		System.out.println("���ϸ��� �Է��Ͻÿ�.");
		// 
		String file = scan.nextLine();
		// FileOutputStream ���� ���� ����.
		FileOutputStream fos = new FileOutputStream(file,true);
		System.out.println("������ �Է��ϼ���.");
		byte[] buf = new byte[1000];
		boolean a = true;
		// �Է� ����.
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
