package chap6;
//System.arraycopy �޼��带 �̿��� ����.
public class ArrayEx13 {

	public static void main(String[] args) {
		int score[] = {90,80,70};
		int score2[] = new int[5];
		System.arraycopy(score, 0, score2, 0, score.length); //score �迭�� 0���������� ���� score2 �迭�� 0�������� ����ٿ��ֱ�. score.length�� ���̸�ŭ. 
		score2[3] = 60;
		score2[4] = 50;
		for(int s : score2) {
			System.out.println(s);
		}
	}

}
