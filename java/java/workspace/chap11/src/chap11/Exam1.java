package chap11;

public class Exam1 {

	public static void main(String[] args)  {
	method1();
	}

	private static void method1()  {
		throw new RuntimeException("Exam1 예외 발생: 예외처리 안하도록 수정");
		
	}

}
