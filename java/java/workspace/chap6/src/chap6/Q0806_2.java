package chap6;

import java.util.Scanner;

public class Q0806_2 {

	public static void main(String[] args) {
		System.out.println("배열의 크기를 홀수로 입력하세요");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[][] arr = new int[size][size];
		for (int i = 0; i <= arr.length / 2; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				System.out.print((j < i) ? "  " : "" + "*" + ((j == arr.length - i - 1) ? "\n" : " "));
			}

		}

		for (int i = (arr.length / 2) + 1; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((j < arr.length - 1 - i) ? "  " : "" + "*" + ((j == i) ? "\n" : " "));
			}

		}

	}

}
