package chap11;

/*
 * 다중 catch 구문 예제
 * 발생된 예외 별로 다른 예외 처리를 할 수 있다. (하나의 Try 안에 다중 catch 가능)
 * 
 * catch 구문의 배치 : 자손 exception - > 부몬 exception 순으로 배치해야 함. => 예외의 최상위 클래스인 Exception타입의 catch 구문은 반드시 최하단에 배치해야 한다.
 * 
 *   
 */
public class ExceptionEx2 {
	public static void main(String[] args) {
		try {
			System.out.println(args[0]); //현재 0번지에 아무것도 없다.
			//args[0]에 홍길동 입력함. -> NumberFormatException e 실행.
			//args[0] 를 0으로 변경. -> Arr
			System.out.println(Integer.parseInt(args[0]));
			System.out.println(2 / Integer.parseInt(args[0]));
			// 현재 args[0]는 1
			String str = null;
			System.out.println(str.trim());
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (ArrayIndexOutOfBoundsException e) { //0번 첨자를 가진 내용이 없을 때 실행.
			System.out.println("명령 실행시 파라미터를 입력하세요.");
		} catch (NumberFormatException e) { //숫자가 아닐 시 실행.
			System.out.println("숫자만 가능합니다.");
		} catch (Exception e) {
			System.out.println("전산부로 연락하세요(전화:1234)");
		}
	}
}
