package chap6;
// for ������ �̿��� �迭�� ����
public class ArrayEx12 {
	public static void main(String[] args) {
		int score[] = {90,80,70};
		int score2[] = new int[5];
		//score.length =5; //���� : length���� ���� �Ұ�, �ܺ������� ���� �Ұ�
//		score2 = score; // score �迭�� score2 �迭�� ����.
//		score2[3] = 60; //���� �߻�. 
//		score2[4] = 50;
		//for���� �̿��� �迭�� ����.
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
