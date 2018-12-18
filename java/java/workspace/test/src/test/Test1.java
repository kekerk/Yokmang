package test;

import java.util.Scanner;

/*
 * 1.화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드 작성하기.
 * 변환 공식 : C = 5/9 * (F-32)
 * 단, 변환 결과값은 소수점셋째자리에서 반올림해야한다.
 */

public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("화씨 온도를 입력하시오.");
		double fahr = scan.nextInt();
		double celc = (double)5/9*(fahr-32.0);
		System.out.println("화씨 "+fahr +"를 섭씨로 바꾸면 "+String.format("%.2f", celc));
	}
}
