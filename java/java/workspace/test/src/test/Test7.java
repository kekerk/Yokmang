package test;

public class Test7 {

	public static void main(String[] args) {
		int[][] a = { { 7, 4, 4 }, { 0, 3, 9 }, { 1, 1, 1 }, { 3, 2, 7 }, { 5, 0, 3 } };

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");

			}
			System.out.println();
		}

		System.out.println("������ �����ϱ�");
		int[][] b = new int[a[0][0]][a[0][1]];

		for (int i = 1; i < a.length; i++) {
			//a[i][0]�� ���� ��ǥ, a[i][1]�� ���� ��ǥ , a[i][2]�� ��ǥ��
			b[a[i][0]][a[i][1]] = a[i][2];
		}
	//2���� �迭 ���.
		
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
}
