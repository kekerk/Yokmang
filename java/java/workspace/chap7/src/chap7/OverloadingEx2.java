package chap7;
/*
 * 메서드 오버로딩 
 *    -> 동일 클래스 내부에 같은 이름을 가진 메서드가 여러개 존재 가능함.
 *    -> 단 매개변수 목록이 달라야 한다.
 *     ( 변수명이 아니고 자료형이 달라야한다. 갯수,순서, 자료형자체 )
 *     1. 메서드 명이 같다.
 *     2. 매개변수가 다르다.
 *     3. return 타입이나 접근 제어자는 상관이 없다.
 *     
 *     
 *     오버로딩된 메서드의 선택 기준
 *     1.메서드호출 시 입력된 매개변수값의 자료형과 메서드의 선언부의 자료형이 동일
 *     2. 1의 기준이 없는 경우 최소개수를 자동형변환하는 매개변수를 가진 메서드를 선택.
 *     주의 : 동일한 선택 기준이 되는 메서드가 여려개인 경우 오류 발생.-
 */
class Math4{

	int add(int a, int b) {
		System.out.print(" int int 메서드 결과: ");
		return a+b;
	}
	long add(long a, int b) {
		System.out.print(" long int 메서드 결과: ");
		return a+b;
	}
	long add(int a, long b) {
		System.out.print(" int long 메서드 결과: ");
		return a+b;
	}
	long add(long a, long b) {
		System.out.print(" long long 메서드 결과: ");
		return a+b;
	}
	
}
public class OverloadingEx2 {

	public static void main(String[] args) {
		Math4 m4 = new Math4();
		System.out.println(m4.add(10, 10));  //int int 를 주석처리하면 2개의 add문에서 충돌
		System.out.println(m4.add(10L, 10)); //long 타입이 int 타입 안으로 들어갈 수 없다.
		System.out.println(m4.add(10, 10L));
		System.out.println(m4.add(10L, 10L));
		
	}

}
