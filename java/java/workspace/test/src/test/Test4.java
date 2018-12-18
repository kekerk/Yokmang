package test;

import java.util.Scanner;

/*
 * 피보나치 수열은 앞의 두수를 더해서 다음 수를 만들어 나가는 수열이다.
 * 예를 들어 앞의 두 수가 1과 1이라면 그다음 수는 2가 뒤고
 * 그다음 수는 1과 2를 더해서 3이 되어서
 * 1,1,2,3,5,8,13,21,...
 * 
 *
 */
public class Test4 {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		int count = 2;
		Scanner scan = new Scanner(System.in);
		System.out.println("구하고자 하는 수열의 갯수를 입력");
		int num = scan.nextInt();
		System.out.print(num1+","+num2+",");
		while (count != num) {
			num3 = num1 + num2;
			System.out.print( num3 );
			num1 = num2;
			num2 = num3;
			count++;
			System.out.print((count==num)?" ": ",");
		}
		System.out.println();
		System.out.println("10번째 수:" + num3);
	}
}
