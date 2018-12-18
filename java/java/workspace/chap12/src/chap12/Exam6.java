package chap12;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {
		int[][] calendar = new int[7][7];
		Calendar cal = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			//Arrays.fill : 1���� �迭�� ��� ����.
			for(int i=0;i<calendar.length;i++) {
			Arrays.fill(calendar[i], 0);
			}
			System.out.println("�⵵�� �Է��ϼ���. ����(0)");
			int year = scan.nextInt();
			if (year == 0)
				break;
			System.out.println("���� �Է��ϼ���.");
			int month = scan.nextInt();
			// �ش� ���� 1���� Calendar ��ü�� ����.
			cal.set(year, month - 1, 1); // Ex) 2018�� 8�� 1���� ������ ����.
			// (1���� ���� �������� ���ڷ� ����)(1~7������ ������ ����)
			// 8�� : 4
     		int week = cal.get(Calendar.DAY_OF_WEEK);
			// �ش� ���� ������ ����.
			int end = cal.getActualMaximum(Calendar.DATE);
			int day = 1; // ���� ����� ���� ����. 1��
			// %10d : %d�� ������ ���. %10d�� 10�ڸ��� 10���� ���.
			// %4s : 4�ڸ��� ���ڿ� ���.
			// �迭�� ��¥ �Է��ϱ�.
			for (int i = 1; i <= end; i++) {
				cal.set(year, month - 1, i);
				int week1 = cal.get(Calendar.DAY_OF_WEEK);
				int cnt = cal.get(Calendar.WEEK_OF_MONTH);
				calendar[cnt - 1][week1 - 1] = i;
			}
			System.out.println(String.format("%10d��%3d��", year, month));
			System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n", "��", "��", "ȭ", "��", "��", "��", "��");
			for (int i = 0; i < calendar.length; i++) {
				for (int j = 0; j < calendar[i].length; j++) {
					if (calendar[i][j] == 0) {
						System.out.print("   ");
					} else
						System.out.printf("%3d", calendar[i][j]);
				}
				System.out.println();
			}

		}

	}

}
