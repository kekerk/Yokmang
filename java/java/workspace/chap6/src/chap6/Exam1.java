package chap6;

import java.util.Scanner;

/*
 * 화면에서 점수를 10개 입력받아서 score 배열에 저장하고, 
 * 점수의 합계와 평균을 구하고, 최대점수를 출력하기.
 */
public class Exam1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("점수 10개를 입력하시오.");
		/////////////////////////////////////////////
		int[] score = new int[10];
		for (int i = 0; i < score.length; i++) {	//스코어 배열에 값 입력.
			score[i] = scan.nextInt();
		}
		/////////////////////////////////////////////
		int sum = 0, max = 0;
		/////////////////////////////////////////////
		for (int s : score) {							
			System.out.print(s + " ");
			System.out.print("\n");
			sum += s; // 점수합계 구하기					//입력된 스코어 배열 10개 s로 초기화.
			if (max < s) { //점수 중 최대점수 도출               
				max = s;
			}
		}
		/////////////////////////////////////////////
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (double) sum / score.length);
		System.out.println("최대값 : " + max);
	}
}
