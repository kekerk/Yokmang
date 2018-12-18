package chap14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 화면에서 홀수개의 숫자를 입력받아서 숫자의 평균과 중간값을 출력하기.
 * 
 */
public class Exam1 {

	public static void main(String[] args) {

		List<Integer> scorelist = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("홀수개의 숫자를 입력하세요.");
		for (int i = 0; i <= 999; i++) {
			int score = scan.nextInt();
			scorelist.add(score);
			if (scorelist.size() % 2 != 0) {
				System.out.println("계속 입력하시겠습니까");

			}

		}
	}
}
