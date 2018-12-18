package chap8;
/*
 *  super : 부모객체의 멤버에 접근하는 참조변수.
 *  super() : 부모클래스의 생성자를 호출.
 */
class Parent {
	int x = 10;
}

class Child extends Parent {
	int x = 20;

	void method() {
		int x = 30;
		System.out.println(x); // 30
		System.out.println(this.x); // 20
		System.out.println(super.x); // 10. 부모클래스의
	}
}

public class SuperEx1 {
	public static void main(String[] args) {
		Child c = new Child();
		/*
		 * new 연산자
		 * 1. 부모클래스의 객체를 제일 먼저 생성
		 * 2. 자손클래스의 객체를 생성
		 * 3. 기본값으로 초기화
		 * 4. 부모클래스의 생성자 실행 : super()
		 * 5. 자손클래스의 생성자 실행
		 */
		c.method();
	}
}
