package test;

/*
 *      0
 *     1 2
 *    3   4
 *   5     6
 *  7       8
 * 90123456789 
 */
public class Q3 {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int num = 6;
		int t = 0;
		// 삼각형 빗변 쪽 수 출력
		for (int i = 1; i <= num - 1; i++) {
			for (int j = 1; j < num * 2 - 1; j++) {
				if (j == num - (i - 1) || j == num + (i - 1)) {
					System.out.print(a[t]);
					t++;
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		//아래는 마지막줄 부분
		String m = "";
		m+=String.format("%d", a[9]);
		for(int s=0;s<a.length;s++) {
			m+=String.format("%d", a[s]);
		}
		System.out.print(m);
	}
}
