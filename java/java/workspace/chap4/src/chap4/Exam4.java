package chap4;

import java.util.Scanner;

/*
 * ȭ�鿡�� �� ���� �Է¹޾Ƽ� �� ū���� ����ϱ�
 */
public class Exam4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�� ���� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int ans = (a > b)? a:b;
		System.out.println("�� ���� �� ū ����"+ans+"�Դϴ�.");
		
	}

}
