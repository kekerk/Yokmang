package chap6;

/*
 * �迭�� ����, ����, �ʱ�ȭ
 */
public class ArrayEx2 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 }; // �迭�� ����,{����,�ʱ�ȭ) �ѹ���.
		for (int a : arr) { // ÷�� ��� �Ұ�.
			System.out.println(a);
		}
		for (int i = 0; i < arr.length; i++) {
			if (i == 2)
				arr[i] += 100;
			System.out.println("arr[" + i + "]=" + arr[i]);
		}

		arr = new int[] { 100, 200, 300, 400, 500 };
		for (int a : arr) { // ÷�� ��� �Ұ�.
			System.out.println(a);
		}
		
		
		int[] ar = {1,2,3,4,5};
		for (int a : ar) { // ÷�� ��� �Ұ�.
			System.out.println(a);}
	}

}
