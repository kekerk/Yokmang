package chap6;

import java.util.Scanner;

public class Exam10_2 {
	/*
	 * 국어,영어,수학,물리,화학,사회,컴퓨터 점수를 입력받은 후, 총점, 평균을 구하고 이들 모두에 대한 막대 그래프를 아래 조건에 맞게 그릴
	 * 수 있는 프로그램을 작성하시오.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int sum1 = 0;// 학생별 총점
		String[] sub = { "국어", "영어", "수학", "물리", "화학", "사회", "컴퓨터" };
		int[] grade = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
		System.out.println("과목이 몇개입니까");
		int a = scan.nextInt();
		int[] score = new int[a];
		int i = 0;
		int j = 0;

		System.out.println("점수 입력");

		for (i = 0; i < score.length; i++) {
			int num = scan.nextInt();
			score[i] = num;
			sum1 += score[i];

		}
		// 입력한 점수가 40~49 : 40에 *
		// 입력한 점수가 50: 50에 *
		for (i = 0; i < grade.length; i++) {
			System.out.print(grade[i] + " " + "\t");

			for (j = 0; j < score.length; j++) {

				if (grade[i] <= score[j] && score[j] > grade[grade.length - 1]) {

					System.out.print("*" + "\t");}
				
				 else { 
					System.out.print(" " + "\t");
				}

			}
			System.out.println();
		}
		System.out.print("\t");
		for (i = 0; i < sub.length; i++) {
			System.out.print(sub[i] + "\t");
		}
		System.out.println();
		System.out.println("총합: " + sum1);
		System.out.println("평균: " + (double) sum1 / score.length);
	}

}
