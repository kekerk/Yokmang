package chap5;

import java.util.Scanner;

/*
 * �Ѱ��� ���ڸ� �Է¹޾Ƽ� �빮�� �ҹ��� ���� �׿ܹ��ڿ��� ����ϱ�
 */
public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		char a = scan.next().charAt(0); //���ڿ����� ù��° ���ڸ� �������.

		if (((a >= 'a') && (a <= 'z'))) { // char a�� 'a'���� ũ�� 'z'���� ���� ��
			System.out.println(a + "�� �ҹ����Դϴ�.");
		} else if (((a >= 'A') && (a <= 'Z'))) { // char a�� 'A'���� ũ�� 'Z'���� ���� ��
			System.out.println(a + "�� �빮���Դϴ�.");
		} else if ((a >= '0') && (a <= '9')) {
			System.out.println(a + "�� �����Դϴ�.");
		} else {
			System.out.println(a + "�� �Ϲݹ����Դϴ�.");

		}
		
	
		
	}

}
