package chap4;

import java.util.Scanner; //Scanner 기능을 사용할 때 유틸을 임포트 시켜야함

/*
 * 화면에서 세자리 정수를 입력받아 100자리 미만을 버리고 출력하기
 */
public class Exam2 {

	public static void main(String[] args) {
		System.out.println("계산할 세자리 정수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
// 		int ans = num - (num%100);
		int ans = (num/100)*100;
		System.out.println("값:"+ans);
		// TODO Auto-generated method stub

	}

}
