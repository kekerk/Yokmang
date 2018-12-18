package chap5;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		
				System.out.println("숫자를 입력하세요");
				Scanner scan = new Scanner(System.in);
				int i = scan.nextInt();
				int sum = 0;
				while(i>0) {
					sum+=(i%10);
					i/=10;
							}
				System.out.println("각 자리수의 합: "+sum);
	}

}
