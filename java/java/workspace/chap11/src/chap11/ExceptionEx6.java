package chap11;

public class ExceptionEx6 {

	public static void main(String[] args) {
		try {
			throw new Exception("예외 강제 발생"); // 예외 객체 생성. JVM에 발생을 알려주는 것.
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 정상 종료");
	}

}
