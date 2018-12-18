package chap5;

public class Exam9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 1; i <= 100; i++) {

			if (i % 2 == 0 || i % 3 == 0)
				continue; //해당되는 수들은 건너뛴다.
			sum += i;
		}
		System.out.println("2 또는 3의 배수를 제외한 나머지 수들의 합은 " + sum + "입니다.");
	}
}
