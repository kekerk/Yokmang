package chap4;

import java.util.Scanner;

// �Է��� ���ڸ� �������� 1�� �ڸ��� 1�� �ٲٱ�.
public class Exam3 {

	public static void main(String[] args) {
		System.out.println("����� ���ڸ� ������ �Է��ϼ���");
		Scanner scan = new Scanner(System.in); // system.in �ý������� �Է� , scanner �Է¹��� �� ����
		int num = scan.nextInt(); //���� ��ĵ���� ���� ���������� num�� ����
//		int ans = (num-(num%10)) + 1;
		int ans = ((num/10)*10) + 1; //1�ڸ��� �ٲٱ� ���� 10���� ���� �� �ٽ� ���ϱ� 10 �� �� +1
		System.out.println("��:"+ans);
		
	}

}
