package chap5;

import java.util.Scanner;

public class HomeWork801 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1.  ������ �־��� ���ڿ�(value)�� ���������� �Ǻ��ϴ�  ���α׷��� �ۼ��Ͻÿ�.
//		  String �Լ� charAt(i), length() �� �����.
		/*
		  System.out.println("�ƹ��ų� �Է��Ͻÿ�"); Scanner scan = new Scanner(System.in);
		  String ar = scan.nextLine();
		  
		  int a = 0;
		  
		  for (int i = 0; i < ar.length(); i++) {
		  
		  if ((ar.charAt(i) < '0') || (ar.charAt(i) > '9')) {
		  System.out.println("���ڿ��� �ƴմϴ�.");
		  
		  }
		  
		  else { a++; }
		  
		  } if (a == ar.length()) System.out.println("���ڿ��Դϴ�.");
		  
		  // 2. ���� ���߱� ���� ���α׷��� �ۼ��ϱ� // ��ǻ�ʹ� 1�� 100������ ���� �����ϰ� �ְ�, ����ڴ� �ݺ������� ���ڸ� �Է��ؼ�
		  // ��ǻ�Ͱ� ������ ���� ���߸� ������ ������.
		  
		  System.out.println("��ǻ�� ���� ������"); int num = (int) (Math.random() * 100) + 1;
		  System.out.println("���ڸ� �Է��ϼ���"); Scanner scan1 = new Scanner(System.in); int
		  i = scan1.nextInt(); int cnt = 1; do {
		  
		  if (i < num) { System.out.println("�۾�!!! �ٽ� �Է�");
		  
		  i = scan1.nextInt(); } else if (i > num) { System.out.println("Ŀ!!! �ٽ� �Է�");
		  
		  i = scan1.nextInt(); } else { break; } cnt++; } while (i != num);
		  
		  System.out.println("���� ¦¦¦"); System.out.println(cnt + "ȸ ���� ���߼̽��ϴ�.");
		 */
//      3. ������ ȸ������ ���ϴ� ���α׷��� �ۼ��ϱ�
//        ȸ������ ���ڸ� �Ųٷ� �о ������ �д� �Ͱ�  ���� ���� ���Ѵ�.
//        12321 : ȸ����
//        12345 : ȸ���� �ƴ�

		System.out.println(" ���ڸ� �Է��Ͻÿ�");
		Scanner scan2 = new Scanner(System.in);
		String arr = scan2.nextLine();
		int c = 0, d = 0;

		if (arr.length() % 2 == 0) {

			for (int t = 0; t <= arr.length() / 2; t++) {
				if (arr.charAt(t) == arr.charAt(arr.length() - t)) {
					c++;
				}
				if (c == (arr.length() / 2)) {
					System.out.println("ȸ�����Դϴ�.");

				} else {
					System.out.println("ȸ������ �ƴմϴ�.");
				}
			}

		} else if (arr.length() % 2 == 1) {

			for (int t = 0; t <= (arr.length() / 2) + 1; t++) {
				if (arr.charAt(t) == arr.charAt(arr.length() - (t + 1))) {
					d++;
				}
				if (d == (arr.length() / 2) + 1) {
					System.out.println("ȸ�����Դϴ�.");

				} else {
					System.out.println("ȸ������ �ƴմϴ�.");
				}
			}

		}

	}
}
