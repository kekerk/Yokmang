package chap5;

public class LoopEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0, i = 1;
		for (i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("for문을 이용한 합계 : " + sum);

		sum = 0; // sum, i를 다시 0과 1로 초기화
		i = 1;
		while (i <= 100) {
			sum += i;
			i++;
		}
		System.out.println("while문을 이용한 합계:" + sum);

		sum = 0; // sum, i를 다시 0과 1로 초기화
		i = 1;
		do {
			sum += i;
			i++;
		} while (i <= 100);
		System.out.println("do while문을 이용한 합계:" + sum);
	}

}
