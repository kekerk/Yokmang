package chap6;

import java.util.Scanner;

/*
 * ���� n�� �Է¹ް�, ���� n�� ���μ��� 1 �̻�  n �̸��� ������ ������ ����ϴ� ���α׷� �����ϱ�.
 * ���⼭ ������ ���� n�� ���μҶ�, n���� ������� 1�ۿ� ���� ���ڸ� ���Ѵ�.
 * 
 */
public class Exam10_1 {
	public static void main(String[] args) {
		// ������� 1���̸� ���
		int[] t = new int[100];
		int[] w = new int[100];
		int num = 0;
		int c = 0;
		int d = 0;
		System.out.println("������ �Է��Ͻÿ�.(1~100)");
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();

		for (int i = 1; i < num; i++) {

			int index = 0;
			for (int j = 1; j <= i; j++) {

				if (num % j == 0 && i % j == 0) {
					t[index++] = j;

				}

			}

			System.out.print(num + "�� " + i + "�� �����: ");
			for (int k = 0; k <= index - 1; k++) {
				System.out.print(t[k] + "  ");

			}
			System.out.println();

		}

	}
}
