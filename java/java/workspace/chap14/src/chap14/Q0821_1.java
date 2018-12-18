package chap14;

/*
 * 
 */
public class Q0821_1 {
	public static void main(String[] args) {
		for (int i = 2; i <= 9; i += 4) {
			for (int j = 2; j <= 9; j++) {
				for (int k = 0; k <= 3; k++) {// 2,3,4,5           6,7,8,9
					System.out.print((i + k) + "*" + j + "=" + ((i + k) * j) + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}

	}
}
