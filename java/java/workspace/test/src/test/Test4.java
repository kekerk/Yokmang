package test;

import java.util.Scanner;

/*
 * �Ǻ���ġ ������ ���� �μ��� ���ؼ� ���� ���� ����� ������ �����̴�.
 * ���� ��� ���� �� ���� 1�� 1�̶�� �״��� ���� 2�� �ڰ�
 * �״��� ���� 1�� 2�� ���ؼ� 3�� �Ǿ
 * 1,1,2,3,5,8,13,21,...
 * 
 *
 */
public class Test4 {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		int count = 2;
		Scanner scan = new Scanner(System.in);
		System.out.println("���ϰ��� �ϴ� ������ ������ �Է�");
		int num = scan.nextInt();
		System.out.print(num1+","+num2+",");
		while (count != num) {
			num3 = num1 + num2;
			System.out.print( num3 );
			num1 = num2;
			num2 = num3;
			count++;
			System.out.print((count==num)?" ": ",");
		}
		System.out.println();
		System.out.println("10��° ��:" + num3);
	}
}
