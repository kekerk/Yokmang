package chap6;

import java.util.Scanner;

public class Exer4 {

	public static void main(String[] args) {
		System.out.println("�迭�� ũ�⸦ Ȧ���� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int data = 0;
		int[][] arr = new int[size][size];
		for(int i=1;i<=size;i+=2) {  // �迭�� �� �������� ũ�� ���ϱ�.
			data+=i;
		}
		data*=2;
		data--;
		for (int i = 0; i <= arr.length / 2; i++) {
			for (int j = i; j < arr.length - i; j++) {
				arr[i][j] = data--;
			}

		}

		for (int i = (arr.length / 2) + 1; i < arr.length; i++) {
			for (int j = arr.length - 1 - i; j <= i; j++) {
				arr[i][j] = data--;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(((arr[i][j] != 0) ? arr[i][j] : " ") + "\t");
			}
			System.out.println();
		}
	}
}
