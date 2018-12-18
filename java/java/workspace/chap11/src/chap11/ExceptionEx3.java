package chap11;

/*
 * finally 예제 : 정상 처리 또는 예외 발생 시 모두 실행되는 블럭.
 * 				 중간에 retrun 구문이 실행되도 finally 블럭은 실행된다.
 */

public class ExceptionEx3 {
	public static void main(String[] args) {
		try {
			System.out.println("작업을 시작합니다.");
			System.out.println(args[0]);
			System.out.println("작업 중입니다.");
			// return;
		} catch (Exception e) {
			System.out.println("작업 중 오류가 발생했습니다.");
			return; // 메서드 종료.

		} catch (Throwable e) {
			System.out.println("작업 중 오류가 발생했습니다.");
		}

		finally { // catch에서 return을 만나도 finally는 하고 끝내야 한다.
			System.out.println("작업을 마무리합니다.");
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
