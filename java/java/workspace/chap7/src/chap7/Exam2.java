package chap7;

/*
 *  동전 두개를 던져서 하나의 동전이 연속해서 앞면이 3번 나오면 승리.
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
			System.out.print("c1의" + i + "번째 면은" + k[i] + "  " +  "c2의" + i + "번째 면은" + l[i]+"\n");
			if (k[i] == k[i + 1] && k[i + 1] == k[i + 2] && k[i + 2] == k[i]) {
				System.out.println("c2승리");
				break;
			} else if (l[i] == l[i + 1] && l[i + 1] == l[i + 2] && l[i + 2] == k[i]) {
				System.out.println("c1승리");
				break;

			}
		}
		
	}

}
