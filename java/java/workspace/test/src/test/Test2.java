package test;

import java.util.Scanner;

/*
 * switch ������ �̿��Ͽ� �ý��۰� ���������� �����ϱ�.
 * ������ ���� ���Ͽ� 1�� ��� ����, 2�� ��� ����, 3�� ��� ��
 * ����� ������ ���� ����ڰ� �Է��� ���� ���Ͽ�
 * �ý����� �¸��� ��� ��ǻ�� �¸�, ���� �¸��� ���  ����� �¸�
 * ������ ���.
 */
public class Test2 {
	public static void main(String[] args) {
		int comn = (int) (Math.random() * 3) + 1;
		System.out.println("��ǻ�Ͱ� ���Ŵ�"+comn);
		Scanner scan = new Scanner(System.in);
		System.out.println("����(1), ����(2), ��(3) �� �ϰ� �� ����?");
		int num = scan.nextInt();
		switch (comn) {
		case 1:
			if (num == 2) {
				System.out.println("����� �¸�");
				break;
			} else if (num == comn) {
				System.out.println("���");
				break;
			} else {
				System.out.println("��ǻ�� �¸�");
				break;
			}

		case 2:
			if (num == 1) {
				System.out.println("��ǻ�� �¸�");
				break;
			} else if (num == comn) {
				System.out.println("���");
				break;
			} else {
				System.out.println("���� �¸�");
				break;
			}
		case 3:
			if (num == 1) {
				System.out.println("����� �¸�");
				break;
			} else if (num == 2) {
				System.out.println("��ǻ�� �¸�");
				break;
			} else {
				System.out.println("���");
				break;
			}
		}

	}
}
