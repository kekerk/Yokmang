package chap10;
/*
 * 내부 클래스 특징
 * 1. 클래스 내부에 존재하는 클래스(중첩클래스라고도 함)
 * 2. 참조자료형, 객체화 가능. Object 클래스의 하위 클래스.
 *    멤버(변수, 메서드, 생성자) 소유함. 
 * 3. 외부클래스의 멤버임. 외부클래스의 private 멤버에 접근 가능.
 * 
 * 내부클래스 종류
 * 1. static 내부 클래스 : static 멤버 소유 가능.
 * 2. 인스턴스 내부 클래스 : static 멤버 소유 불가능. 단 상수 가능.
 * 3. 지역 내부 클래스 : 메서드 내부에 선언된 클래스. 메서드 내부에서만 클래스가 된다. 다른 곳에서는 쓸 수 없다.
 * 4. 무명의 내부 클래스 : 일회성 객체.
 */
class Outer1 {
	//인스턴스 내부 클래스
	class InstanceInner {  // 자료형은 Outer1.InstanceInner 
		int iv = 100;
		// static int cv = 10; //클래스 멤버를 소유할 수 없다.
		final static int MAX = 200; //단 상수는 가능. 
	}
	// static 내부 클래스
	static class StaticInner { 
		int iv = 300; //인스턴스 멤버
		static int cv = 400; //클래스 멤버
		final static int MAX = 500; // 상수
	}

	void method() {
		//지역 내부 클래스
		class LocalInner { 
			int iv = 600;
//			static int cv = 700; //클래스 멤버를 소유할 수 없다.
			final static int MAX = 700; //상수 가능.
		}
		LocalInner lc = new LocalInner(); //객체화
		System.out.println(lc.iv); //600
		System.out.println(lc.MAX); //700
		System.out.println(LocalInner.MAX);
	}
	void method2() { 
//		LocalInner lc  = new LocalInner();
		// 지역 내부 클래스는 선언된 메서드 내부에서만 사용 가능.
	}
	
}

public class InnerEx1 {
	public static void main(String[] args) {
	Outer1.StaticInner si = new Outer1.StaticInner(); //객체화
	System.out.println(si.iv);
	System.out.println(Outer1.StaticInner.cv);
	System.out.println(Outer1.StaticInner.MAX);
//	Outer1.InstanceInner ii = new Outer1.InstanceInner(); //오류 발생. Outer1울 객체화 하여야 InstanceInner를 클래스화 시킬 수 있다.
//	Outer1.InstanceInner ii = new Outer1().new InstanceInner(); //Outer1의 객체화를 먼저 한 뒤, 내불 클래스 객체화	
	Outer1 out = new Outer1();
	Outer1.InstanceInner ii = out. new InstanceInner();
	System.out.println(ii.iv);
	System.out.println(Outer1.InstanceInner.MAX);
	out.method();
	}
}
