package chap14;

public class Q0821 {
	public static void main(String[] args) {
		for (int x = 0; x < 2; x++) {
			for (int i = 2; i < 10; i++) {
				if (x == 0) {
					for (int j = 2; j <= 5; j++) {
						System.out.print(j + "*" + i + "=" + (j * i) + "\t");
						if (j == 5 && i == 9) {
							System.out.println();
						}
					}
				} else {
					for (int j = 6; j <= 9; j++) {
						System.out.print(j + "*" + i + "=" + (j * i) + "\t");
					}
				}
				System.out.println();
			}
		}
	}
}