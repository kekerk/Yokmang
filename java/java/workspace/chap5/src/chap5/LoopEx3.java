package chap5;

/*
 * 중첩 반복문 예제 : 구구단 출력하기
 */
public class LoopEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		for (i = 2; i <= 9; i++) {
			System.out.println("\n" + i + "단 시작");
			for (j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + (i * j));
			}
		}
	}

}
