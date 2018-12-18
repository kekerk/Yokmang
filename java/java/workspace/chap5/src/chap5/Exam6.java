package chap5;

public class Exam6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0, i = 1;
		for (i = 1; i <= 100; i++) {
			if ((i % 2 == 0) || (i % 3 == 0)) // 6의 배수일 때는, or(||) 연산자일 때는 앞부분이 true 이면 뒷부분은 실행하지 않는다.
										      // 
				sum = sum + i;

		}
/*
		for (i = 1; i <= 100; i++) {
			if (i % 6 == 0)
				sum = sum - i;

		}
*/
		System.out.println("for문을 이용한 합계 : " + sum);
	}

}
