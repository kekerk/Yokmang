package chap6;

import java.util.Scanner;

public class Exam10_2 {
	/*
	 * ����,����,����,����,ȭ��,��ȸ,��ǻ�� ������ �Է¹��� ��, ����, ����� ���ϰ� �̵� ��ο� ���� ���� �׷����� �Ʒ� ���ǿ� �°� �׸�
	 * �� �ִ� ���α׷��� �ۼ��Ͻÿ�.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int sum1 = 0;// �л��� ����
		String[] sub = { "����", "����", "����", "����", "ȭ��", "��ȸ", "��ǻ��" };
		int[] grade = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
		System.out.println("������ ��Դϱ�");
		int a = scan.nextInt();
		int[] score = new int[a];
		int i = 0;
		int j = 0;

		System.out.println("���� �Է�");

		for (i = 0; i < score.length; i++) {
			int num = scan.nextInt();
			score[i] = num;
			sum1 += score[i];

		}
		// �Է��� ������ 40~49 : 40�� *
		// �Է��� ������ 50: 50�� *
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
		System.out.println("����: " + sum1);
		System.out.println("���: " + (double) sum1 / score.length);
	}

}
