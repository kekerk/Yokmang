package test;

/* ���� �˰���.
 * ������ ��� ���. ������ �����Ѵ�.
 * 0�� �ƴ� ������ ��ġ�� ���ڰ��� B ��Ŀ� �ֱ�.
 * 
 */
public class Test6 {

	public static void main(String[] args) {
		int[][] a = { { 0, 0, 0, 9 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 7, 0 }, { 0, 0, 2, 0 }, { 3, 0, 0, 0 },
				{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != 0) {
				cnt++;
				}
			}
		}
		int[][] b = new int[cnt + 1][3];
		b[0][0] = a.length;
		b[0][1] = a[0].length;
		b[0][2] = cnt;
		int s =0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] != 0) {
					b[++s][0] = i;
					b[s][1] = j;
					b[s][2] = a[i][j];
				//	s++;
				}
			}
		}
		//��� ��� B ���
		System.out.println("������ �籸��");
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}

	}
}
