package chap4;

import java.util.Scanner;

/*
 * ���ڸ� ������ ȭ�鿡�� �Է¹޾� �Է¹��� ������ ũ�ų� ���� 10�� ����� ���� ���� ���� ���ϰ� 
 * �Է¹��� �������� ���� ���Ͽ� ����ϱ�.
 */
public class Exam5 {

	public static void main(String[] args) {
		System.out.println("���ڸ� ������ �Է��Ͻÿ�");
		Scanner scan = new Scanner (System.in);
		int a = scan.nextInt();
		int b = (a>((a/10)*10))? ((a/10)+1)*10 : (a/10*10);
//		int b = (a/10)*10 + ((a%10==0)? 0 : 10 );
		int c = b-a;
		System.out.println("�Է¹��� "+a+"���� ũ�ų� ���� 10�� ����� ���� ���� "+b);
		System.out.println(b+"-"+a+"="+c);
	}

}
