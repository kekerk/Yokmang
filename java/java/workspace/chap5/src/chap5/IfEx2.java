package chap5;

import java.util.Scanner;

//���ǿ����ڸ�
//if���ǹ����� �����ϱ�
public class IfEx2 {

	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��Ͻÿ�");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();

		if (a > 0)
			System.out.println(a + "�� ����Դϴ�.");
		else if (a < 0)
			System.out.println(a + "�� �����Դϴ�.");
		else
			System.out.println(a + "�� ���Դϴ�.");

	}

}
