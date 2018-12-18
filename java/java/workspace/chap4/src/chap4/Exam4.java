package chap4;

import java.util.Scanner;

/*
 * 화면에서 두 수를 입력받아서 더 큰수를 출력하기
 */
public class Exam4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("두 수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int ans = (a > b)? a:b;
		System.out.println("두 수중 더 큰 수는"+ans+"입니다.");
		
	}

}
