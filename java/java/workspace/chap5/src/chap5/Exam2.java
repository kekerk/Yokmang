package chap5;

import java.util.Scanner;

/*
 * �⵵�� ���ڷ� �Է¹޾� ���� ���ϱ� (���ڸ� ����)
 * ������ 4�� ������ �������� 100���� ������ �������� �ʴ´�.
 * �� 100������ �������� �⵵�� 400���� ������ �������� �����̴�.
 */
public class Exam2 {

	public static void main(String[] args) {
		System.out.println("�⵵�� �Է��Ͻÿ�");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();

		if (((a % 4) == 0)) {
			if ((a % 100) == 0)
				System.out.println(a + "�� �����Դϴ�.");
			else
				System.out.println(a + "�� �����Դϴ�.");
		} else if (((a % 100) == 0)) {
			if ((a % 4) == 0)
				System.out.println(a + "�� �����Դϴ�.");
			else
				System.out.println(a + "�� ����Դϴ�.");

		} else
			System.out.println(a + "�� ����Դϴ�.");
	}

}
