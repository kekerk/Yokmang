package chap4;

import java.util.Scanner;

/*
 * 정수를 입력받아서 양수인 경우 양수로 음수인 경우는 음수, 0인 경우 0으로 출력하기
 * 
 */
public class Exam6 {

	public static void main(String[] args) {
		System.out.println("두자리 정수를 입력하시오");
		Scanner scan = new Scanner (System.in);
		int a = scan.nextInt();
		String ans = (a>0)? "양수" :((a==0)? "0":"음수"); //세 개 이상의 선택에는 false나 true 자리에 조건 연산자를 다시 이용해준다.
		System.out.println("입력하신 값 "+a+"는 "+ans+"입니다.");
	}

}
