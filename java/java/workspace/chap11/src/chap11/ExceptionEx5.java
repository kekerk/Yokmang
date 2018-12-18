package chap11;

/*
 * throws : 예외처리의 다른 방법.
 */
public class ExceptionEx5 {
	public static void main(String[] args) throws Exception {
		first();

	}

	private static void first() throws Exception {
		System.out.println("first 메서드 호출");
		second();
	}

	private static void second() throws Exception {
		System.out.println("second 메서드 호출");
		System.out.println(10 / 0);
	}
}
