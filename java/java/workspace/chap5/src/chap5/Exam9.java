package chap5;

public class Exam9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 1; i <= 100; i++) {

			if (i % 2 == 0 || i % 3 == 0)
				continue; //�ش�Ǵ� ������ �ǳʶڴ�.
			sum += i;
		}
		System.out.println("2 �Ǵ� 3�� ����� ������ ������ ������ ���� " + sum + "�Դϴ�.");
	}
}
