package chap8;
/*
 * final : 마지막의, 변경 불가의 의미를 가진다.
 * final class : 상속 불가 클래스, 다른 클래스의 부모가 될 수 없다.\
 * 				 String, Math 클래스가 final class. 
 * 
 * final method : 재정의 불가 메서드. 오버라이딩 불가 메서드로 설정.
 * final value : 변경불가 변수. 상수.
 * 				 명시적 초기화가 되어 있지 않은 경우, 멤버 변수인 생성자에서 한번 변경이 가능함.
 */

public final class FinalClass {
}

class sub extends FinalClass {
}

class FinalMethod {
	 final void finalmethod() { //부모의 메서드 오버라이딩 불가.  (메서드 - 오버라이딩)
		System.out.println("final method : 오버라이딩 불가 메서드");

	}

}

class Sub2 extends FinalMethod {
	void finalmethod() {
		System.out.println("이 메서드는 오류 발생됨");
	}
}