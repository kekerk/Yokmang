package chap6;

public class Q0806_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 10, 20 }, { 30, 40 }, { 50, 60, 70 } };
		int[][] arr1 = new int[4][4];
		int[] sum1 = new int[3];
		int[] sum2 = new int[3];
				
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr1[i][j] = arr[i][j];
				sum1[i] += arr1[i][j];
				sum2[j] += arr1[i][j];
				arr1[3][j] = sum2[j];
				arr1[i][3] = sum1[i];

			}

		}

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " " + ((j == arr1[i].length - 1) ? "\n" : " "));

			}
		}
		System.out.println();
		for (int i = 0; i < sum1.length; i++) {

			System.out.println(i + "행의 합:" + sum1[i]);
		}
		System.out.println();
		for (int i = 0; i < sum2.length; i++) {

			System.out.println(i + "열의 합:" + sum2[i]);
		}

	}
}
