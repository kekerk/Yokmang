package chap6;

import java.util.Scanner;

/*
 *  Ȧ������ �迭�� ũ�⸦ �Է¹޾� matrix�� �����ϰ� * ���ڸ� �̿��Ͽ� �𷡽ð� ����ϱ�.
 */
public class Work2 {
	public static void main(String[] args) {
		System.out.println("�迭�� ũ�⸦ Ȧ���� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		char[][] matrix = new char[size][size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = ' ';
			}
		}
		for (int i = 0; i <= matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - i; j++) {
				matrix[i][j] = '*';
			}
		}
		for (int i = matrix.length / 2 + 1; i < matrix.length; i++) {
			for (int j = matrix.length - i - 1; j <= i; j++) {
				matrix[i][j] = '*';
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
