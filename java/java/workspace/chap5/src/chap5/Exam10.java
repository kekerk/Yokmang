package chap5;

import java.util.Scanner;

/*
 * ȭ�鿡�� ���ڸ� �Է¹ޱ�.
 * �Է¹��� ���� 99999�� �Ǹ� �� �̻� �Է��� ���� �ʰ�, 99999������ 
 */
public class Exam10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);

		int sum = 0;
		double c = 0;
		while (true) { // break ������ ��� �ݺ�
			
		int n = scan.nextInt();
			if (n == 99999)
				break;
			sum += n;
			c++;

		}
		
		System.out.println("����: " + sum + "\t ���: " + (sum/c));
	}

}
