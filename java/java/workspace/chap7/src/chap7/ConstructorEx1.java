package chap7;
/*
 *  생성자 예제
 *  생성자란 객체 생성 시 호출되는 특별한 메서드.
 *  생성자 없는 객체 생성은 불가.
 *  주요 기능은 메모리 생성이 아니고, 인스턴스변수의 초기화를 담당한다.
 *  생성자는 클래스와 이름이 같고, 리턴타입이 없다. void가 아니고 기술하지 않는다.
 *  생성자는 오버로딩이 가능하다.
 *  
 *  기본생성자 : 개발자가 생성자를 구현하지 않으면 컴파일러가 추가하는 기본생성자.
 *  		 public 클래스명() {            }
 */

class Number1{ //기본생성자가 제공됨.
	int num;
}
class Number2{
	int num;
	Number2(int x) {
		num = 'x';  //생성자
	} //return타입 없음.
}
public class ConstructorEx1 {
	public static void main(String[] args) {
		Number1 n1 = new Number1(); //new 다음에 있는 Number1()가 생성자.
		/*
		 *  new 예약어 기능
		 *  1. 힙 영역에 메모리 할당
		 *  2. 멤버변수를 초기화
		 *  3. 생성자 (Number1())호출
		 */
		n1.num = 10;
		Number2 n2 = new Number2(20);
		System.out.println("n1 객체의 num = " + n1.num);
		System.out.println("n2 객체의 num = " + n2.num);
		
	}

}
