package chap6;
//Arrays : �迭�� ���õ� ����� ���� Ŭ����.
import java.util.Arrays;

//Arrays.copyOf
public class ArrayEx14 {
	public static void main(String[] args) {
		int score[] = { 90, 80, 70 };
		int score2[] = Arrays.copyOf(score, 5);
		Arrays.sort(score2); //����   ���߿� API �ϸ鼭 �ٽ�  ������ ��.
		for (int s : score2) {
			System.out.println(s);
		}

	}

}
