package test;

import java.util.Scanner;

/*
 * 삼각형의 높이 n과 종류 m을 
입력받은 후 다음과 같은 삼각형 
형태로 출력하는 프로그램을 작성하시오.
종류 1                  종류 2             종류 3
 *                    *****                *
 **                   ****                ***
 ***                  ***                *****
 ****                 **                *******
 *****                *                *********

삼각형의 크기 n(n의 범위는 100 이하의 자연수)과 종류 m(m은 1부터 3사이의 자연수)을 입력받는다
 */
public class Q2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("삼각형의 높이를 입력하세요");
		int height = scan.nextInt();
		System.out.println("삼각형의 종류를 입력하세요");
		int type = scan.nextInt();
		switch (type) {
		case 1:
			for (int i = 1; i <= height; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 1; i <= height; i++) {
				for (int j = 1; j <= height + 1 - i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 1; i <= height; i++) {
				for(int j=1;j<=(height*2)-1;j++) {
					if(j >= (height-(i-1)) && j <= (height+(i-1))) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			break;
		}
	}
}
