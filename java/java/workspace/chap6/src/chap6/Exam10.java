package chap6;

import java.util.Scanner;

/*
 * �߱� ����
 * 
 */
public class Exam10 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] ar = new int[4];
		int[] t = new int[4];
		Scanner scan = new Scanner(System.in);
		int s = 0;
		int b = 0;
		int c = 0;

		// �������� 4�ڸ� ���� ���� �� �� �ڸ��� �� ������� ����
		System.out.println("��ǻ�� ���ڸ� ���� ������");
		for (int i = 0; i < 1000; i++) {
			int t1 = (int) ((Math.random() * 10));
			int t2 = (int) ((Math.random() * 10));
			int a = arr[t1];
			arr[t1] = arr[t2];
			arr[t2] = a;
		}

		System.out.print("Ƚ�� Ȯ�θ� ���� ���� : ");
		for (int i = 0; i < ar.length; i++) {
			ar[i] = arr[i];
			System.out.print(ar[i]);
		}
		System.out.println();
		/////////////////////////////////////////
		do {
			System.out.println("���ڸ� ���ڸ� �Է��Ͻÿ�.");
			int num = scan.nextInt();
			int tmp = num;

			// �Է��� ���ڸ� ���� ������� ���� (10������ 2�������� �ٲٴ� �������� Ȱ��)
			int index = 3; // �� �ڸ� ������ ���� ������ ���ʴ�� �ֱ����� �������� ����
			while (tmp != 0) {
				t[index--] = tmp % 10;
				tmp /= 10;
			}
			// ���� �ڸ��� ���� ���� ������ ��Ʈ����ũ ó��
			s = 0;
			for (int i = 0; i < 4; i++) {

				if (ar[i] == t[i]) {
					s++;
				}
			}
			// �ڸ��� �ٸ��� �� ���� ������ ���� ��ġ�� ���ڰ� ������ �� ó��
			b = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (i != j) { //���� �ڸ��� �ƴѵ�
						if (ar[i] == t[j]) { //���ڰ� ��ģ�ٸ�

							b++; //�� ó��

						}
					}
				}
			}

			System.out.println("��Ʈ����ũ :" + s);

			System.out.println("�� :" + b);
			c++;
		} while (s != 4);
		System.out.println(c + "��°���� ���� �������ϴ�.");
		System.out.println();
	}
}
