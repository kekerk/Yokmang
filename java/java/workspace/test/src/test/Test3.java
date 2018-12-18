package test;

public class Test3 {
	public static void main(String[] args) {
		for (double i = 0.0; i <= 10.0; i++) {
			for (double j = 0.0; j <= 10.0; j++) {
				if ((2 * i) + (4 * j) == 10) {
					System.out.println("x: " + i + ",y: " + j);
				}
			}
		}

	}

}
