package chap10;
/*
 * 이름 없는 내부 클래스 예제
 */
interface I {
	void test();
}

abstract class Abs{
	int  x;
	abstract void testmethod();
	
}
public class InnerEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		I i = new I() {  // 일회성 객체. 이름없는 내부 클래스 예제.
			public void test() {
				System.out.println("I 인터페이스의 test 메서드 구현함.");
			}
		};
		i.test();
		Abs a = new Abs() {  //다른 타입으로 참조할 수 없다.
			void testmethod() {
				System.out.println("Abs 추상 클래스의 testnethod 메서드 구현함. x="+x);
			}
		};   //추상메서드 구현. 중괄호 끝에 세미콜론 찍어야 함.
		
		
		a.testmethod();
		Object o = (Object) i; //형변환 연산자. 자동 형변환.
	//	o.test(); // test()는 Object의 멤버가 아니라서 호출이 안됨.
		o =a;
		
		
		
	}

}
