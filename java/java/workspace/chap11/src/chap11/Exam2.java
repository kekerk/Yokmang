package chap11;

public class Exam2 {
	public static void main(String[] args) {
		
	try {
		badmethod();
	} catch (Exception e) {
		System.out.println("main 에서 예외 처리됨");
		e.printStackTrace();
	}
		
		
	}

	private static void badmethod() throws Exception {
		//badmethod() 와 main에서 두번 예외처리를 하기.
	try {
		throw new Exception("예외 처리 문제");
	} catch (Exception e) {
		System.out.println("badmethod 에서 예외 처리됨");
		e.printStackTrace();
		throw e;
	}
		
	}

}
