package chap4;

import java.util.Scanner;

/*
 * 소문자를 대문자로 변경하기
 * 문자를 입력받아서 소문자인 경우 대문자, 대문자인 경우 소문자
 */
public class Exam9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("문자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		char a = scan.next().charAt(0); // 형변환 아님
		// scan.next(); 의 결과는 String. "a"로 입력됨.
		// "a".charAt(0); : 문자열에서 첫번째 문자를 리턴
		System.out.println(a + (((a >= 'a') && (a <= 'z')) ? "의 대문자는 " + (char) (a - 32) : "는 소문자가 아닙니다."));

	}

}
