package chap5;

/*
 * ��ø �ݺ��� ���� : ������ ����ϱ�
 * break : �ݺ����� switch ������ ���.
 * coutinue : �ݺ����� ó������ ���� �̵�, continue ���� �������� �������� �ʰ� �ٷ� ó������ �̵�. 
 */
public class LoopEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		for (i = 2; i <= 9; i++) {
			System.out.println("\n" + i + "�� ����");
			for (j = 1; j <= 9; j++) {
//				if(j==5) break; //���� �ݺ����� ���
				if(j==5) continue; //���� �ݺ����� ó������ ���� �̵�  , coutinue ���� ������ �������� �ʴ´�.
				System.out.println(i + "*" + j + "=" + (i * j));
			}
		}
	}

}
