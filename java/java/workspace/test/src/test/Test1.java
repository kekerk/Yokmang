package test;

import java.util.Scanner;

/*
 * 1.ȭ��(Fahrenheit)�� ����(Celcius)�� ��ȯ�ϴ� �ڵ� �ۼ��ϱ�.
 * ��ȯ ���� : C = 5/9 * (F-32)
 * ��, ��ȯ ������� �Ҽ�����°�ڸ����� �ݿø��ؾ��Ѵ�.
 */

public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("ȭ�� �µ��� �Է��Ͻÿ�.");
		double fahr = scan.nextInt();
		double celc = (double)5/9*(fahr-32.0);
		System.out.println("ȭ�� "+fahr +"�� ������ �ٲٸ� "+String.format("%.2f", celc));
	}
}
