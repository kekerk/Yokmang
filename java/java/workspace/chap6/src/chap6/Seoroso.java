package chap6;

import java.util.Scanner;

/*
 * ���� n�� �Է¹ް�,
 * ���� n�� ���μ��� 1 �̻� n �̸��� ������ ������ ����ϴ� ���α׷� �����ϱ�
 * ���⼭ ������ ���� n�� ���μҶ�, n���� ������� 1�ۿ� ���� ���ڸ� ���Ѵ�.
 * [���]
 * ���ڸ� �Է��ϼ���
 * 20
 * 20�� ���μ� : 1,3,7,9,11,13,17,19
 * ���μ��� ������ ���� : 8
 */
public class Seoroso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int cnt = 0; //num�� ���μ��� ���� ����
		System.out.print(num+"�� ���μ��� ��: ");
		for(int i=0;i<num;i++) {
			int index=0;
			for(int j=1;j<=i;j++) {
				if(num%j==0 && i%j==0) {
					index++;
				}
			}
			if(index==1) { //������� 1�� �͸� ��� �ɷ����� ���.
				cnt++;
				System.out.println(i+",");
			}
		}
		System.out.println();
		System.out.println(num+"�� ���μ��� ���� ����: "+cnt);
	}

}
