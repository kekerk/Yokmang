package chap4;

import java.util.Scanner; //Scanner ����� ����� �� ��ƿ�� ����Ʈ ���Ѿ���

/*
 * ȭ�鿡�� ���ڸ� ������ �Է¹޾� 100�ڸ� �̸��� ������ ����ϱ�
 */
public class Exam2 {

	public static void main(String[] args) {
		System.out.println("����� ���ڸ� ������ �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
// 		int ans = num - (num%100);
		int ans = (num/100)*100;
		System.out.println("��:"+ans);
		// TODO Auto-generated method stub

	}

}
