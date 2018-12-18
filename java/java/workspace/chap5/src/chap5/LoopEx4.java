package chap5;

/*
 * 중첩 반복문 예제 : 구구단 출력하기
 * break : 반복문과 switch 구문을 벗어남.
 * coutinue : 반복문의 처음으로 제어 이동, continue 다음 구문들을 실행하지 않고 바로 처음으로 이동. 
 */
public class LoopEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		for (i = 2; i <= 9; i++) {
			System.out.println("\n" + i + "단 시작");
			for (j = 1; j <= 9; j++) {
//				if(j==5) break; //현재 반복문을 벗어남
				if(j==5) continue; //현재 반복문의 처음으로 제어 이동  , coutinue 밑의 문장은 실행하지 않는다.
				System.out.println(i + "*" + j + "=" + (i * j));
			}
		}
	}

}
