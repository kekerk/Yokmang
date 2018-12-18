package chap5;

import java.util.Scanner;

/*
 * 한개의 문자를 입력받아서 대문자 소문자 숫자 그외문자여부 출력하기
 */
public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("문자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		char a = scan.next().charAt(0); //문자열에서 첫번째 문자를 떼어오기.

		if (((a >= 'a') && (a <= 'z'))) { // char a는 'a'보다 크고 'z'보다 작을 때
			System.out.println(a + "는 소문자입니다.");
		} else if (((a >= 'A') && (a <= 'Z'))) { // char a는 'A'보다 크고 'Z'보다 작을 때
			System.out.println(a + "는 대문자입니다.");
		} else if ((a >= '0') && (a <= '9')) {
			System.out.println(a + "는 숫자입니다.");
		} else {
			System.out.println(a + "는 일반문자입니다.");

		}
		
	
		
	}

}
