package chap6;

import java.util.Scanner;

/*
 * 금액을 입력받아서 최소개의 동전으로 바꿔주는 프로그램
 */
public class Exam7 {
	public static void main(String[] args) {
		System.out.println("금액을 입력하시오");
		int coin[] = { 500, 100, 50, 10 };
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		// money를 최소 개수줄이기.

		for (int s : coin) {
			System.out.println(s + "동전의 개수는 " + (money / s));

			money %= s;

		}

	}

}
