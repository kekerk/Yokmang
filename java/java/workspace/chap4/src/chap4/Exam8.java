package chap4;

import java.util.Scanner;

/*�ѹڽ��� 10��
 * 10�� �̸��� ������ 1�ڽ� ����.
 */
public class Exam8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������ ����");
		Scanner scan = new Scanner (System.in);
		int a = scan.nextInt();
		
		int b = a/10 ; 
		int d = a%10 ;
		int c = (a>(a/10)*10)? b+1 : b ;
		// int b = a/10 + ((a%10==0)?0:1);
		// System.out.println("������ "+ a +"���� ��µ� �ʿ��� �ڽ� ���� "+b+"�ڽ��Դϴ�.")
		System.out.println("������ ����: "+d);
		System.out.println("������ "+ a +"���� ��µ� �ʿ��� �ڽ� ���� "+c+"�ڽ��Դϴ�.");
	}

}
