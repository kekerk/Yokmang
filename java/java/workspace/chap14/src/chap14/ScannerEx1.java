package chap14;

import java.util.Scanner;

/*
 * Scanner ����
 */
public class ScannerEx1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0, cnt = 0;
		System.out.println("���ڸ��� �ڿ����� �Է��ϼ���. ����(0)");
		while (true) {
			int num = scan.nextInt();
			if (num < 1)
				break;
			sum += num;
			cnt++;
		}
		System.out.println("�ý��� �Է� ������ �Ǽ�: " + cnt + ",�հ�: " + sum);
	}
}
