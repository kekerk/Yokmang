package chap14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * ȭ�鿡�� Ȧ������ ���ڸ� �Է¹޾Ƽ� ������ ��հ� �߰����� ����ϱ�.
 * 
 */
public class Exam1 {

	public static void main(String[] args) {

		List<Integer> scorelist = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Ȧ������ ���ڸ� �Է��ϼ���.");
		for (int i = 0; i <= 999; i++) {
			int score = scan.nextInt();
			scorelist.add(score);
			if (scorelist.size() % 2 != 0) {
				System.out.println("��� �Է��Ͻðڽ��ϱ�");

			}

		}
	}
}
