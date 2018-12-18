package chap6;

import java.util.Scanner;

/*
 * 10진수를 2진수로 변경하기. 
 */
public class ArrayEx4 {
	public static void main(String[] args) {
	int num[] = new int[32];
	System.out.println("2진수로 변경할 10진수를 입력하세요.");
	Scanner scan = new Scanner(System.in);
	int b = scan.nextInt();
	int divnum = b; 
	int index = 0;
	while(divnum!=0) {
		num[index++]=divnum%2; //index에 0을 먼저하고 줄이 실행되고 1로 카운트
		divnum/=2;			   // 
		
	}
	System.out.print(b+"의 2진수:");
	for(int i= index -1; i>=0;i--) {
		System.out.print(num[i]);
	}
		System.out.println();
	}
}
