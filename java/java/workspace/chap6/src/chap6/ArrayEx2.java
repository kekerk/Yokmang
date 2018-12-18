package chap6;

/*
 * 배열의 선언, 생성, 초기화
 */
public class ArrayEx2 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 }; // 배열의 선언,{생성,초기화) 한번에.
		for (int a : arr) { // 첨자 사용 불가.
			System.out.println(a);
		}
		for (int i = 0; i < arr.length; i++) {
			if (i == 2)
				arr[i] += 100;
			System.out.println("arr[" + i + "]=" + arr[i]);
		}

		arr = new int[] { 100, 200, 300, 400, 500 };
		for (int a : arr) { // 첨자 사용 불가.
			System.out.println(a);
		}
		
		
		int[] ar = {1,2,3,4,5};
		for (int a : ar) { // 첨자 사용 불가.
			System.out.println(a);}
	}

}
