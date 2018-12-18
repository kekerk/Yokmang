package chap12;
/*

1. 다음과 결과가 나오도록 프로그램을 완성하시오.

[결과]

***3

*******7

*1

****4




***3

*******7

*1

****4 */

public class Q0822_2 {

	public static void main(String[] args) {
		printGraph(new int[] { 3, 7, 1, 4 }, '*');

		System.out.println();

		printGraph("3, 7, 1, 4", '*');

	}

	public static void printGraph(int[] is, char c) {
		for (int i = 0; i < is.length; i++) {
			for (int j = 0; j < is[i]; j++) {
				System.out.print(c);
			}
			System.out.println(is[i]);
		}
	}

	public static void printGraph(String str, char c) {
		String[] str1 = str.split(", ");
		int[] sub = new int[4];
		for(int i=0;i<sub.length;i++) {
			sub[i] = Integer.parseInt(str1[i]);
		}
		for (int i = 0; i < sub.length; i++) {
			for (int j = 0;j<sub[i]; j++) {
				System.out.print(c);
			}
			System.out.println(sub[i]);
		}

	}
}
