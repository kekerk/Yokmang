package chap6;

import java.util.Scanner;

/*
 * ���� n�� �Է¹ް�, ���� n�� ���μ��� 1 �̻�  n �̸��� ������ ������ ����ϴ� ���α׷� �����ϱ�.
 * ���⼭ ������ ���� n�� ���μҶ�, n���� ������� 1�ۿ� ���� ���ڸ� ���Ѵ�.
 * 
 */
public class Exam10__1 {
	public static void main(String[] args) {
		// ������� 1���̸� ���
		int[] t = new int[100];
		int[] w = new int[100];
		int num = 0;
		int c = 0;
		int i=1;

		System.out.println("������ �Է��Ͻÿ�.(1~100)");
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		int x=0;
		for (i = 1; i < num; i++) {
			
			int index = 0;
			for (int j = 1; j <= i; j++) {

				if (num % j == 0 && i % j == 0) {
					t[index++] = j; // ��ƾ�� ������ index+1 ����
					x++;
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
