package chap6;

import java.util.Scanner;

/*
 * �ݾ��� �Է¹޾Ƽ� �ּҰ��� �������� �ٲ��ִ� ���α׷�
 */
public class Exam7 {
	public static void main(String[] args) {
		System.out.println("�ݾ��� �Է��Ͻÿ�");
		int coin[] = { 500, 100, 50, 10 };
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		// money�� �ּ� �������̱�.

		for (int s : coin) {
			System.out.println(s + "������ ������ " + (money / s));

			money %= s;

		}

	}

}
