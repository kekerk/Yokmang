package chap14;

import java.util.Scanner;

/*
 * Scanner 예제
 */
public class ScannerEx1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0, cnt = 0;
		System.out.println("두자리의 자연수를 입력하세요. 종료(0)");
		while (true) {
			int num = scan.nextInt();
			if (num < 1)
				break;
			sum += num;
			cnt++;
		}
		System.out.println("시스템 입력 데이터 건수: " + cnt + ",합계: " + sum);
	}
}
