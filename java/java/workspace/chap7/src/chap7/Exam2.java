package chap7;

/*
 *  ���� �ΰ��� ������ �ϳ��� ������ �����ؼ� �ո��� 3�� ������ �¸�.
 */
public class Exam2 {

	public static void main(String[] args) {

		Coin c1 = new Coin();
		Coin c2 = new Coin();
		int[] k = new int[1000];
		int[] l = new int[1000];
		int c1cnt = 0, c2cnt = 0;
		int i=0;
		for (i = 0; i < 1000; i++) {

			c1.flip();
			c2.flip();
			k[i] = c1.side;
			l[i] = c2.side;
			c1cnt++;
			c2cnt++;
			System.out.print("c1��" + i + "��° ����" + k[i] + "  " +  "c2��" + i + "��° ����" + l[i]+"\n");
			if (k[i] == k[i + 1] && k[i + 1] == k[i + 2] && k[i + 2] == k[i]) {
				System.out.println("c2�¸�");
				break;
			} else if (l[i] == l[i + 1] && l[i + 1] == l[i + 2] && l[i + 2] == k[i]) {
				System.out.println("c1�¸�");
				break;

			}
		}
		
	}

}
