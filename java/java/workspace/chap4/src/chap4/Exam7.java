package chap4;

import java.util.Scanner;

/*
 * ȭ�鿡�� score�� �Է¹޾Ƽ�
 * 90 �̻� A, 80�̻� B,... 60�̸� F
 */
public class Exam7 {

	public static void main(String[] args) {
		System.out.println("������ �Է��Ͻÿ�");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		String ans = ((a >= 90) ? "A" : 
					 ((a >= 80) ? "B" : 
					 ((a >= 70) ? "C" : 
					 ((a >= 60) ? "D" : "F"))));
		System.out.println(a + "���� " + ans + "�Դϴ�.");
	}

}
