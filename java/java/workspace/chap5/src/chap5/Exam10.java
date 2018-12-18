package chap5;

import java.util.Scanner;

/*
 * 화면에서 숫자를 입력받기.
 * 입력받은 수가 99999가 되면 더 이상 입력을 받지 않고, 99999제외한 
 */
public class Exam10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);

		int sum = 0;
		double c = 0;
		while (true) { // break 전까지 계속 반복
			
		int n = scan.nextInt();
			if (n == 99999)
				break;
			sum += n;
			c++;

		}
		
		System.out.println("총합: " + sum + "\t 평균: " + (sum/c));
	}

}
