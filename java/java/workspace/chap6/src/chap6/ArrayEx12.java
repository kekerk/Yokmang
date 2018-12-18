package chap6;
// for 구무을 이용한 배열의 복사
public class ArrayEx12 {
	public static void main(String[] args) {
		int score[] = {90,80,70};
		int score2[] = new int[5];
		//score.length =5; //오류 : length값은 변경 불가, 외부적으로 변경 불가
//		score2 = score; // score 배열을 score2 배열도 참조.
//		score2[3] = 60; //오류 발생. 
//		score2[4] = 50;
		//for문을 이용한 배열의 복사.
		for(int i =0; i < score.length ; i++ ) {
			score2[i] = score[i];
		}
		score2[3] = 60;
		score2[4] = 50;
		for(int s : score2) {
			System.out.println(s);
		}
	}

}
