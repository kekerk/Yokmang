package chap4;

import java.util.Scanner;

/*
 * �ҹ��ڸ� �빮�ڷ� �����ϱ�
 * ���ڸ� �Է¹޾Ƽ� �ҹ����� ��� �빮��, �빮���� ��� �ҹ���
 */
public class Exam9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		char a = scan.next().charAt(0); // ����ȯ �ƴ�
		// scan.next(); �� ����� String. "a"�� �Էµ�.
		// "a".charAt(0); : ���ڿ����� ù��° ���ڸ� ����
		System.out.println(a + (((a >= 'a') && (a <= 'z')) ? "�� �빮�ڴ� " + (char) (a - 32) : "�� �ҹ��ڰ� �ƴմϴ�."));

	}

}
