package chap4;

import java.util.Scanner;

/*
 * ������ �Է¹޾Ƽ� ����� ��� ����� ������ ���� ����, 0�� ��� 0���� ����ϱ�
 * 
 */
public class Exam6 {

	public static void main(String[] args) {
		System.out.println("���ڸ� ������ �Է��Ͻÿ�");
		Scanner scan = new Scanner (System.in);
		int a = scan.nextInt();
		String ans = (a>0)? "���" :((a==0)? "0":"����"); //�� �� �̻��� ���ÿ��� false�� true �ڸ��� ���� �����ڸ� �ٽ� �̿����ش�.
		System.out.println("�Է��Ͻ� �� "+a+"�� "+ans+"�Դϴ�.");
	}

}
