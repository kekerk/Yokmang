package chap6;

import java.util.Scanner;

/*
 * 정수 n을 입력받고, 정수 n과 서로소인 1 이상  n 미만의 정수와 갯수를 출력하는 프로그램 구현하기.
 * 여기서 임의의 정수 n의 서로소란, n과의 공약수가 1밖에 없는 숫자를 뜻한다.
 * 
 */
public class Exam10_1 {
	public static void main(String[] args) {
		// 공약수가 1개이면 출력
		int[] t = new int[100];
		int[] w = new int[100];
		int num = 0;
		int c = 0;
		int d = 0;
		System.out.println("정수를 입력하시오.(1~100)");
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();

		for (int i = 1; i < num; i++) {

			int index = 0;
			for (int j = 1; j <= i; j++) {

				if (num % j == 0 && i % j == 0) {
					t[index++] = j;

				}

			}

			System.out.print(num + "와 " + i + "의 공약수: ");
			for (int k = 0; k <= index - 1; k++) {
				System.out.print(t[k] + "  ");

			}
			System.out.println();

		}

	}
}
