package chap6;

import java.util.Scanner;

/*
 * ȭ�鿡�� ������ 10�� �Է¹޾Ƽ� score �迭�� �����ϰ�, 
 * ������ �հ�� ����� ���ϰ�, �ִ������� ����ϱ�.
 */
public class Exam1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("���� 10���� �Է��Ͻÿ�.");
		/////////////////////////////////////////////
		int[] score = new int[10];
		for (int i = 0; i < score.length; i++) {	//���ھ� �迭�� �� �Է�.
			score[i] = scan.nextInt();
		}
		/////////////////////////////////////////////
		int sum = 0, max = 0;
		/////////////////////////////////////////////
		for (int s : score) {							
			System.out.print(s + " ");
			System.out.print("\n");
			sum += s; // �����հ� ���ϱ�					//�Էµ� ���ھ� �迭 10�� s�� �ʱ�ȭ.
			if (max < s) { //���� �� �ִ����� ����               
				max = s;
			}
		}
		/////////////////////////////////////////////
		System.out.println("���� : " + sum);
		System.out.println("��� : " + (double) sum / score.length);
		System.out.println("�ִ밪 : " + max);
	}
}
