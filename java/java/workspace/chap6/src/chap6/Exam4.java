package chap6;

public class Exam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int l = 1; l < 10; l++) {
					if ((i == j || j == l || l == i)) {
						continue;
					}

					else {
						if ((i + j + l) == 9) {

							System.out.println(++c + ":" + i + j + l);
						}
					}
				}
			}
		}
	}
}
