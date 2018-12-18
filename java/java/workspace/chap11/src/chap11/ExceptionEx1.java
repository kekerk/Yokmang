package chap11;
/*
 * 예외처리 : 발생된 예외를 제거
 * try catch 구문
 * 		  try 블럭 : 예외가 발생 할 수 있는 영역.
 * 		catch 블럭 : try 블럭에서 예외가 발생한 경우 처리 하는 영역.
 * 
 * 	자바는 예외처리가 필수임.
 *  단 RuntimeException 예외인 경우 예외처리를 생략 가능함.
 */	
public class ExceptionEx1 {
	public static void main(String[] args) {
		System.out.print(1); //이 부분에서 예외가 생기면 JVM에서 처리함.
		
		try {
			System.out.print(2);
			System.out.print(3/0); //ArithmeticException 예외 발생.
			System.out.print(4);
			
		} catch (ArithmeticException e) { // 에러가 발생했을 때만 실행이 된다.
			System.out.print(5);
		}
		System.out.print(6);
	}

}
