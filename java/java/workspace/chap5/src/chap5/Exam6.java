package chap5;

public class Exam6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0, i = 1;
		for (i = 1; i <= 100; i++) {
			if ((i % 2 == 0) || (i % 3 == 0)) // 6�� ����� ����, or(||) �������� ���� �պκ��� true �̸� �޺κ��� �������� �ʴ´�.
										      // 
				sum = sum + i;

		}
/*
		for (i = 1; i <= 100; i++) {
			if (i % 6 == 0)
				sum = sum - i;

		}
*/
		System.out.println("for���� �̿��� �հ� : " + sum);
	}

}
