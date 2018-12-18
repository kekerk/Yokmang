package chap6;

import java.util.Scanner;

//키보드로부터 1부터 9까지의 값을 입력밭아 배열 answer에 저장하고 데이터를 읽어 각 숫자의 개수만큼 *을 찍는 프로그램을 작성
public class Q2 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.println("점수 10개를 입력하시오.");
		//배열 선언 생성
		int[] score = new int[10];
		int[] t =new int[10];
		for (int i = 0; i < score.length; i++) {	//스코어 배열에 숫자 10개 입력.
//			
				// 1<=a<=10
				int a=(int)(Math.random()*9 +1);
				
				t[i] =  a;
				
		}
		
		//'*' 출력하기		
//		for(int i : t) {
//			System.out.print(i);
//			System.out.print(":");
//			for(int j=1;j<=i;j++) {
//				
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		for(int i=0;i<t.length;i++) {
		System.out.print(t[i]);
		System.out.print(":");
		for(int j=1;j<=t[i];j++) {
			
			System.out.print("*");
		}
		System.out.println();
	}
	}

}
