package chap6;

import java.util.Scanner;

public class Exer1 {

	public static void main(String[] args) {
		
		int octal[] = new int[32];
		System.out.println("8진수로 변경할 10진수를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int divnum = num; 
		int index = 0;
		while(divnum!=0) {
			octal[index++]=divnum%8; 
			divnum/=8;			   
			
		}
		System.out.print(num+"의 8진수:");
		for(int i= index -1; i>=0;i--) {
			System.out.print(octal[i]);
		}
			System.out.println();
	}

}
