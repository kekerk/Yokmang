package chap5;

import java.util.Scanner;

//조건연산자를
//if조건문으로 변경하기
public class IfEx2 {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하시오");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();

		if (a > 0)
			System.out.println(a + "는 양수입니다.");
		else if (a < 0)
			System.out.println(a + "는 음수입니다.");
		else
			System.out.println(a + "는 영입니다.");

	}

}
