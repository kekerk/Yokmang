package chap12;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {
		int[][] calendar = new int[7][7];
		Calendar cal = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			//Arrays.fill : 1차원 배열만 사용 가능.
			for(int i=0;i<calendar.length;i++) {
			Arrays.fill(calendar[i], 0);
			}
			System.out.println("년도를 입력하세요. 종료(0)");
			int year = scan.nextInt();
			if (year == 0)
				break;
			System.out.println("월을 입력하세요.");
			int month = scan.nextInt();
			// 해당 월의 1일을 Calendar 객체로 설정.
			cal.set(year, month - 1, 1); // Ex) 2018년 8월 1일을 가지고 있음.
			// (1일이 무슨 요일인지 숫자로 지정)(1~7까지의 값으로 리턴)
			// 8월 : 4
     		int week = cal.get(Calendar.DAY_OF_WEEK);
			// 해당 월의 마지막 일자.
			int end = cal.getActualMaximum(Calendar.DATE);
			int day = 1; // 일자 출력을 위한 변수. 1일
			// %10d : %d는 십진수 출력. %10d는 10자리로 10진수 출력.
			// %4s : 4자리로 문자열 출력.
			// 배열에 날짜 입력하기.
			for (int i = 1; i <= end; i++) {
				cal.set(year, month - 1, i);
				int week1 = cal.get(Calendar.DAY_OF_WEEK);
				int cnt = cal.get(Calendar.WEEK_OF_MONTH);
				calendar[cnt - 1][week1 - 1] = i;
			}
			System.out.println(String.format("%10d년%3d월", year, month));
			System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n", "일", "월", "화", "수", "목", "금", "토");
			for (int i = 0; i < calendar.length; i++) {
				for (int j = 0; j < calendar[i].length; j++) {
					if (calendar[i][j] == 0) {
						System.out.print("   ");
					} else
						System.out.printf("%3d", calendar[i][j]);
				}
				System.out.println();
			}

		}

	}

}
