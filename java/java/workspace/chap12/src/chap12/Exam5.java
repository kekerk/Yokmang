package chap12;

import java.util.Calendar;
import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("�⵵�� �Է��ϼ���. ����(0)");
			int year = scan.nextInt();
			if (year == 0)
				break;
			System.out.println("���� �Է��ϼ���.");
			int month = scan.nextInt();
			//�ش� ���� 1���� Calendar ��ü�� ����.
			cal.set(year, month - 1, 1); // Ex) 2018�� 8�� 1���� ������ ����.
			//(1���� ���� �������� ���ڷ� ����)(1~7������ ������ ����)
			// 8�� : 4
			int week = cal.get(Calendar.DAY_OF_WEEK);
			//�ش� ���� ������ ����.
			int end = cal.getActualMaximum(Calendar.DATE);
			int day = 1; //���� ����� ���� ����. 1��
			//%10d : %d�� ������ ���.  %10d�� 10�ڸ��� 10���� ���.
			//%4s  : 4�ڸ��� ���ڿ� ���.
			System.out.println(String.format("%10d��%3d��",year,month));
			System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n","��","��","ȭ","��","��","��","��");
			for (int i = 1; i < (end + week); i++) {
				if (i < week) {
					System.out.print("   ");
					continue;
				}
				System.out.print(String.format("%3d", day++));

				if (i % 7 == 0) {
					System.out.println();
				
				}
				
			}
			System.out.println();
			System.out.println();
		}
	}

}
