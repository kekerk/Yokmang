package chap6;
//Arrays : 배열에 관련된 기능을 가진 클래스.
import java.util.Arrays;

//Arrays.copyOf
public class ArrayEx14 {
	public static void main(String[] args) {
		int score[] = { 90, 80, 70 };
		int score2[] = Arrays.copyOf(score, 5);
		Arrays.sort(score2); //정렬   나중에 API 하면서 다시  나오게 됨.
		for (int s : score2) {
			System.out.println(s);
		}

	}

}
