package chap6;
//System.arraycopy 메서드를 이용한 복사.
public class ArrayEx13 {

	public static void main(String[] args) {
		int score[] = {90,80,70};
		int score2[] = new int[5];
		System.arraycopy(score, 0, score2, 0, score.length); //score 배열의 0에서부터의 값을 score2 배열의 0에서부터 복사붙여넣기. score.length의 길이만큼. 
		score2[3] = 60;
		score2[4] = 50;
		for(int s : score2) {
			System.out.println(s);
		}
	}

}
