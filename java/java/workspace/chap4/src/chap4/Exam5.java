package chap4;

import java.util.Scanner;

/*
 * 두자리 정수를 화면에서 입력받아 입력받은 수보다 크거나 같은 10의 배수중 가장 작은 수를 구하고 
 * 입력받은 정수와의 차를 구하여 출력하기.
 */
public class Exam5 {

	public static void main(String[] args) {
		System.out.println("두자리 정수를 입력하시오");
		Scanner scan = new Scanner (System.in);
		int a = scan.nextInt();
		int b = (a>((a/10)*10))? ((a/10)+1)*10 : (a/10*10);
//		int b = (a/10)*10 + ((a%10==0)? 0 : 10 );
		int c = b-a;
		System.out.println("입력받은 "+a+"보다 크거나 같은 10의 배수중 작은 수는 "+b);
		System.out.println(b+"-"+a+"="+c);
	}

}
