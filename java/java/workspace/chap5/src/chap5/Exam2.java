package chap5;

import java.util.Scanner;

/*
 * 년도를 숫자로 입력받아 윤년 구하기 (네자리 숫자)
 * 윤년은 4로 나누어 떨어지고 100으로 나누어 떨어지지 않는다.
 * 단 100나누어 떨어지는 년도중 400으로 나누어 떨어지면 윤년이다.
 */
public class Exam2 {

	public static void main(String[] args) {
		System.out.println("년도를 입력하시오");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();

		if (((a % 4) == 0)) {
			if ((a % 100) == 0)
				System.out.println(a + "는 윤년입니다.");
			else
				System.out.println(a + "는 윤년입니다.");
		} else if (((a % 100) == 0)) {
			if ((a % 4) == 0)
				System.out.println(a + "는 윤년입니다.");
			else
				System.out.println(a + "는 평년입니다.");

		} else
			System.out.println(a + "는 평년입니다.");
	}

}
