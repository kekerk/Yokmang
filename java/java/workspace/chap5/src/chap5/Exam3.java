package chap5;

public class Exam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		int sum = 0;

		for (i = 1; i < 100; i += 2) {
			sum += i;
		}
		System.out.println("홀수의 합 1:" + sum);

		sum = 0; //변수 초기화
		i = 0;
		for (i = 2; i <= 100; i += 2) {
			sum += i;
		}
		System.out.println("짝수의 합 1:" + sum);

		sum = 0; //변수 초기화
		i = 1;
		while (i <= 100) {
			sum += i;
			i += 2;
		}
		System.out.println("홀수의 합 2:" + sum);

		sum = 0; //변수 초기화
		i = 0;
		while (i <= 100) {
			sum += i;
			i += 2;
		}
		System.out.println("짝수의 합 2:" + sum);

		sum = 0; //변수 초기화
		i = 1;
		do {
			if (i % 2 == 1)
				sum += i;
		} while (i <= 100);
		System.out.println("홀수의 합 3:" + sum);

		sum = 0; //변수 초기화
		i = 1;
		do {
			if (i % 2 == 0)
				sum += i;
		} while (i <= 100);
		System.out.println("홀수의 합 3:" + sum);
	}

}
