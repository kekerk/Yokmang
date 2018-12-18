package chap6;

/*
 *  개선된 for 구문 예제
 *  배열에 저장된 요소의 자료형이 표시되야 한다.
 *  첨자 사용이 안된다. 
 *  첨자를 사용하려면 일반적인 for구문을 이용해야 한다.
 *  
 */
public class ArrayEx15 {
	public static void main(String[] args) {
		String[] strarr = new String[5];
		strarr[0] = "홍길동";
		strarr[1] = "김삿갓";
		strarr[2] = "이몽룡";
		//// strarr[3] = null; 빈공간일시 null로 되어있음.
		//// strarr[4] = null;
		for (String s : strarr) {
			System.out.println(s);
		}
		// 일반 for 구문으로 변경하기
		System.out.println();

		for (int i = 0; i < strarr.length; i++) {
			System.out.println(strarr[i]);
		}
		System.out.println();
		double[] darr = { 0.1, 0.2, 0.3, 0.4, 0.5 };
		for (double d : darr) {
			System.out.println(d);
		}
		System.out.println();
		// 일반 for 구문으로 변경하기
		for (int j = 0; j < darr.length; j++) {
			System.out.println(darr[j]);
		}
	}

}
