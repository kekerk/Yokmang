package chap12;

import java.util.Calendar;
import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("년도를 입력하세요. 종료(0)");
			int year = scan.nextInt();
			if (year == 0)
				break;
			System.out.println("월을 입력하세요.");
			int month = scan.nextInt();
			//해당 월의 1일을 Calendar 객체로 설정.
			cal.set(year, month - 1, 1); // Ex) 2018년 8월 1일을 가지고 있음.
			//(1일이 무슨 요일인지 숫자로 지정)(1~7까지의 값으로 리턴)
			// 8월 : 4
			int week = cal.get(Calendar.DAY_OF_WEEK);
			//해당 월의 마지막 일자.
			int end = cal.getActualMaximum(Calendar.DATE);
			int day = 1; //일자 출력을 위한 변수. 1일
			//%10d : %d는 십진수 출력.  %10d는 10자리로 10진수 출력.
			//%4s  : 4자리로 문자열 출력.
			System.out.println(String.format("%10d년%3d월",year,month));
			System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n","일","월","화","수","목","금","토");
			for (int i = 1; i < (end + week); i++) {
				if (i < week) {
					System.out.print("   ");
					continue;
				}
				System.out.print(String.format("%3d", day++));

				if (i % 7 == 0) {
					System.out.println();
				
				}
				
			}
			System.out.println();
			System.out.println();
		}
	}

}
