package chap4;

import java.util.Scanner;

/*
 * 화면에서 score를 입력받아서
 * 90 이상 A, 80이상 B,... 60미만 F
 */
public class Exam7 {

	public static void main(String[] args) {
		System.out.println("점수를 입력하시오");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		String ans = ((a >= 90) ? "A" : 
					 ((a >= 80) ? "B" : 
					 ((a >= 70) ? "C" : 
					 ((a >= 60) ? "D" : "F"))));
		System.out.println(a + "점은 " + ans + "입니다.");
	}

}
