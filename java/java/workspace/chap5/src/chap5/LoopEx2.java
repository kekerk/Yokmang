package chap5;

public class LoopEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0, i = 1;
		for (i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("for���� �̿��� �հ� : " + sum);

		sum = 0; // sum, i�� �ٽ� 0�� 1�� �ʱ�ȭ
		i = 1;
		while (i <= 100) {
			sum += i;
			i++;
		}
		System.out.println("while���� �̿��� �հ�:" + sum);

		sum = 0; // sum, i�� �ٽ� 0�� 1�� �ʱ�ȭ
		i = 1;
		do {
			sum += i;
			i++;
		} while (i <= 100);
		System.out.println("do while���� �̿��� �հ�:" + sum);
	}

}
